package minegenshin.wrong.item.weapon;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import minegenshin.wrong.capability.MGCapability;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle1;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle2;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle3;
import minegenshin.wrong.init.CapabilityInit;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.network.message.MessageSABClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;

public class ItemDiluc extends Item implements IMineGenshinWeapon {


    public ItemDiluc() {
        this.setMaxStackSize(1);
        this.setCreativeTab(wrongCreativeTab);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        return true;
    }


    @Override
    public void skill(EntityPlayer player, ItemStack stack) {

        ItemDiluc item = (ItemDiluc) stack.getItem();
        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);

        if (!capability.hasSkillKey(item)) {
            capability.setSkillCd(item, 10 * 20);
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }
            stack.getTagCompound().setBoolean("skill1", true);
            stack.getTagCompound().setBoolean("skill2", false);
            stack.getTagCompound().setBoolean("skill3", false);
        }

        NBTTagCompound nbt = stack.getTagCompound();

        if (nbt.getBoolean("skill1") && !capability.hasExtraKey(item)) {

            EntityDilucSkillParticle1 entity = new EntityDilucSkillParticle1(player.world, player.posX, player.posY + 1, player.posZ, player.rotationYaw);
            player.world.spawnEntity(entity);

            nbt.setBoolean("skill1", false);
            nbt.setBoolean("skill2", true);
            capability.setExtraCd(item, 10);
            return;
        }

        if (nbt.getBoolean("skill2") && !capability.hasExtraKey(item)) {

            EntityDilucSkillParticle2 entity = new EntityDilucSkillParticle2(player.world, player.posX, player.posY + 1, player.posZ, player.rotationYaw);
            player.world.spawnEntity(entity);

            nbt.setBoolean("skill2", false);
            nbt.setBoolean("skill3", true);
            capability.setExtraCd(item, 10);
            return;
        }

        if (nbt.getBoolean("skill3") && !capability.hasExtraKey(item)) {

            EntityDilucSkillParticle3 entity = new EntityDilucSkillParticle3(player.world, player.posX, player.posY + 1, player.posZ, player.rotationYaw);
            player.world.spawnEntity(entity);

            nbt.setBoolean("skill3", false);
            capability.setExtraCd(item, 10);
        }

    }


    @Override
    public void burst(EntityPlayer player, ItemStack stack) {

        ItemDiluc item = (ItemDiluc) stack.getItem();
        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
        if (capability.hasBurstKey(item)) return;

        AxisAlignedBB aabb = new AxisAlignedBB(player.posX + 3, player.posY + 2, player.posZ + 3,
                player.posX + 3, player.posY + 2, player.posZ + 3);
        List<Entity> entityList = player.world.getEntitiesWithinAABB(Entity.class, aabb);

        for (Entity entity : entityList
        ) {
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityDilucBurst) && !(entity instanceof EntityPlayer)) {
                EntityLivingBase entityLiving = (EntityLivingBase) entity;
                entityLiving.attackEntityFrom(BURST, 10);
            }

        }

        EntityDilucBurst entity = new EntityDilucBurst(player.world, player.posX, player.posY + player.eyeHeight, player.posZ);
        entity.shoot(player, 0, player.rotationYaw, 0, 0.75F, 0);
        player.world.spawnEntity(entity);

        capability.setBurstCd(item, 20 * 20);

        SimpleNetworkWrapperLoader.INSTANCE.sendTo(new MessageSABClient(player.getEntityId(), player.getName(), EnumSAB.BURST), (EntityPlayerMP) player);
    }


    @Override
    public void skillClient(EntityPlayer player) {
    }


    @Override
    public void burstClient(EntityPlayer player) {

    }


    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack itemStack) {

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 19, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3, 0));
        }

        return multimap;
    }
}
