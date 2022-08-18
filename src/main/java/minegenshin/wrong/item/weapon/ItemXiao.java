package minegenshin.wrong.item.weapon;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.api.IMineGenshinEntity;
import minegenshin.wrong.api.IMineGenshinWeapon;
import minegenshin.wrong.capability.MGCapability;
import minegenshin.wrong.init.CapabilityInit;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.network.message.MessageSABClient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;
import static minegenshin.wrong.init.ParticleInit.XIAO_BURST;

public class ItemXiao extends Item implements IMineGenshinWeapon {

    public ItemXiao() {
        this.setMaxStackSize(1);
        this.setCreativeTab(wrongCreativeTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


        if (playerIn.getCapability(CapabilityInit.MGWEAPON, null).hasMGState(MGCapability.EnumSABState.XIAO_EXPLOSION)) {

            for (int i = 0; i <= 4; i++) {
                BlockPos blockPos = new BlockPos(playerIn.posX, playerIn.posY - 0.2 - i, playerIn.posZ);
                Block block = worldIn.getBlockState(blockPos).getBlock();
                if (!(block instanceof BlockBush || block == Blocks.AIR))
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
            }

            playerIn.getCapability(CapabilityInit.MGWEAPON, null).setMGState(MGCapability.EnumSABState.PLUNGE_ATTACK, -1);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

        if (entityIn instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) entityIn;

            MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);

            if (capability.hasMGState(MGCapability.EnumSABState.XIAO_EXPLOSION)) {
                player.fallDistance = 0;
            }

            if (capability.hasMGState(MGCapability.EnumSABState.PLUNGE_ATTACK)) {
                player.motionX = 0;
                player.motionY = -1.5;
                player.motionZ = 0;
                if (player.world.isRemote) {
                    player.world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY, player.posZ, 0.01, 0.35, 0.27);
                }
            }

            if (capability.hasMGState(MGCapability.EnumSABState.PLUNGE_ATTACK) && (player.onGround || player.isInWater())) {
                capability.removeMGState(MGCapability.EnumSABState.PLUNGE_ATTACK);

                double x0 = player.posX;
                double y0 = player.posY;
                double z0 = player.posZ;

                AxisAlignedBB aabb = new AxisAlignedBB(x0 + 3, y0 + 2, z0 + 3, x0 - 3, y0 - 2, z0 - 3);
                List<EntityLivingBase> entityList = player.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb);

                for (EntityLivingBase targetEntity : entityList) {
                    if (!(targetEntity instanceof EntityPlayer) && !(targetEntity instanceof IMineGenshinEntity)) {

                        double dx = targetEntity.posX - x0;
                        double dz = targetEntity.posZ - z0;
                        double l = Math.sqrt(dx * dx + dz * dz);

                        targetEntity.attackEntityFrom(BURST, 10);
                        targetEntity.addVelocity(dx / l * 0.1, 0.3, dz / l * 0.1);

                    }
                }

                if (worldIn.isRemote) {
                    for (int i = 1; i <= 8; i++) {
                        double x = entityIn.posX - 4 * Math.sin(45 * i * 0.017453292F) * (0.25 + 0.75 * Math.random());
                        double y = entityIn.posY + 0.5 - Math.random();
                        double z = entityIn.posZ + 4 * Math.cos(45 * i * 0.017453292F) * (0.25 + 0.75 * Math.random());
                        worldIn.spawnParticle(XIAO_BURST, false, x, y, z, 0, 0, 0);
                    }
                }

                worldIn.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_SMALL_FALL, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));

            }
        }
    }

    @Override
    public void skill(EntityPlayer player, ItemStack stack) {

        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
        ItemXiao item = (ItemXiao) stack.getItem();

        if (capability.hasExtraKey(item)) return;

        boolean flag = capability.hasSkillKey(item);

        if (!flag || capability.getSkillCd(item) <= 20 * 20) {
            capability.setSkillCd(item, (flag ? capability.getSkillCd(item) : 0) + 20 * 10);
            capability.setExtraCd(item, 10);

            float yaw = -player.rotationYaw;
            double x0 = player.posX;
            double y0 = player.posY;
            double z0 = player.posZ;
            AxisAlignedBB aabb;

            if (yaw >= 0F && yaw < 180.0F) {
                aabb = new AxisAlignedBB(x0 - 1, y0 - 1, z0 - 7, x0 + 7, y0 + 2, z0 + 7);
            } else {
                aabb = new AxisAlignedBB(x0 - 7, y0 - 1, z0 - 7, x0 + 1, y0 + 2, z0 + 7);
            }

            List<EntityLivingBase> list = player.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb);

            for (EntityLivingBase targetEntity : list) {
                if (!(targetEntity instanceof EntityPlayer) && !(targetEntity instanceof IMineGenshinEntity)) {

                    double xo1 = x0 + Math.sin(yaw * 0.017453292F) * 6.5;
                    double zo1 = z0 + Math.cos(yaw * 0.017453292F) * 6.5;

                    double xo2 = x0 - Math.sin(yaw * 0.017453292F) * 0.5;
                    double zo2 = z0 - Math.cos(yaw * 0.017453292F) * 0.5;

                    double l = Math.sqrt((targetEntity.posX - xo1) * (targetEntity.posX - xo1) + (targetEntity.posZ - zo1) * (targetEntity.posZ - zo1)) +
                            Math.sqrt((targetEntity.posX - xo2) * (targetEntity.posX - xo2) + (targetEntity.posZ - zo2) * (targetEntity.posZ - zo2));

                    if (l <= 8) {
                        targetEntity.attackEntityFrom(SKILL, 8);
                    }
                }
            }


            SimpleNetworkWrapperLoader.INSTANCE.sendTo(new MessageSABClient(player.getEntityId(), this.getRegistryName().toString(), EnumSAB.SKILL), (EntityPlayerMP) player);

        }
    }

    @Override
    public void burst(EntityPlayer player, ItemStack stack) {

        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
        ItemXiao item = (ItemXiao) stack.getItem();

        if (capability.hasBurstKey(item)) return;

        capability.setMGState(MGCapability.EnumSABState.XIAO_EXPLOSION, 20 * 15);
        capability.setBurstCd(item, 20 * 20);

        player.attackEntityFrom(BURST, (int) (player.getHealth() * 0.3));
        SimpleNetworkWrapperLoader.INSTANCE.sendTo(new MessageSABClient(player.getEntityId(), this.getRegistryName().toString(), EnumSAB.BURST), (EntityPlayerMP) player);
    }

    @Override
    public void skillClient(EntityPlayer player) {

        float v = 1.5F;
        float x = (float) -Math.sin(player.rotationYaw * 0.017453292F);
        float z = (float) Math.cos(player.rotationYaw * 0.017453292F);

        if (!player.onGround) {
            v *= 0.5F;
        }

        player.motionX = x * v;
        player.motionY = 0.2;
        player.motionZ = z * v;

    }

    @Override
    public void burstClient(EntityPlayer player) {
        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
        capability.setMGState(MGCapability.EnumSABState.XIAO_EXPLOSION, 20 * 15);

        for (int i = 0; i <= 20; i++) {
            player.world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 4 * Math.random() - 2, player.posY + 4 * Math.random() - 2, player.posZ + 4 * Math.random() - 2, 0.01, 0.35, 0.27);
        }
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack itemStack) {

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 7, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", 2, 0));
        }

        return multimap;
    }
}

@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
class PlungeAttack {

    @SubscribeEvent
    public static void jumping(LivingEvent.LivingJumpEvent event) {

        if (event.getEntity() instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) event.getEntity();
            MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);

            if (capability.hasMGState(MGCapability.EnumSABState.XIAO_EXPLOSION)) {

                player.motionY = 1;
            }
        }
    }

}
