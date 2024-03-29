package minegenshin.wrong.item.weapon;

import minegenshin.wrong.api.IMineGenshinWeapon;
import minegenshin.wrong.capability.MGCapability;
import minegenshin.wrong.entity.skill.wendy.EntityWendyAttack;
import minegenshin.wrong.init.CapabilityInit;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.network.message.MessageSABClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

import static minegenshin.wrong.Data.TOOLTIP_VENTI;
import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;

public class ItemVenti extends Item implements IMineGenshinWeapon {
    public ItemVenti() {

        this.setMaxStackSize(1);
        this.setCreativeTab(wrongCreativeTab);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (entityIn == null) {
                    return 0.0F;
                } else {
                    return !(entityIn.getActiveItemStack().getItem() instanceof ItemVenti) ? 0.0F : (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;

                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        this.addPropertyOverride(new ResourceLocation("charge"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (entityIn == null) {
                    return 0.0F;
                } else {
                    return !(entityIn.getActiveItemStack().getItem() instanceof ItemVenti) ? 0.0F : (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount() - 5) / 20.0F;

                }
            }
        });

        this.addPropertyOverride(new ResourceLocation("burst"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && hasNBTTagCompoundValue(stack, "burst") ? 1.0F : 0.0F;
            }
        });
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, true);
        if (ret != null) return ret;
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);

    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLivingBase, int timeLeft) {
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLivingBase;

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, true);
            if (i < 0) return;

            float f = getArrowVelocity(i);

            if ((double) f >= 0.1D) {
                if (!worldIn.isRemote) {
                    EntityWendyAttack entityWendyAttack = new EntityWendyAttack(worldIn, entityplayer);
                    if (f >= 1.20D) {
                        entityWendyAttack.setCharge(true);
                    }
                    if (f >= 1) {
                        f = 1;
                    }
                    if (hasNBTTagCompoundValue(stack, "burst")) {
                        entityWendyAttack.setBurst(true);
                        setNBTTagCompound(stack, "burst", false);
                        entityplayer.getCapability(CapabilityInit.MGWEAPON, null).setBurstCd((IMineGenshinWeapon) stack.getItem(), 15 * 20);
                    }
                    entityWendyAttack.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 2.5F, 0.5F);
                    worldIn.spawnEntity(entityWendyAttack);

                }

                worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            }

            entityplayer.addStat(StatList.getObjectUseStats(this));
        }
    }


    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.25F) {
            f = 1.25F;
        }

        return f;
    }


    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }


    public int getItemEnchantability() {
        return 1;
    }

    public EntityArrow customizeArrow(EntityArrow arrow) {
        return arrow;
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TextFormatting.DARK_GREEN + I18n.format(TOOLTIP_VENTI));
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

        if (entityIn instanceof EntityPlayer && entityIn.motionY < -0.3) {

            EntityPlayer player = (EntityPlayer) entityIn;
            ItemStack stack1 = player.getHeldItemMainhand();

            if (stack1 != null && stack1 == stack && !player.isInWater()) {
                player.motionY = -0.3;
                player.fallDistance = 0;
            }
        }

    }

    @Override
    public void skill(EntityPlayer player, ItemStack stack) {

        ItemVenti item = (ItemVenti) stack.getItem();
        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
        if (capability.hasSkillKey(item)) return;

        capability.setSkillCd(item, 10 * 20);
        SimpleNetworkWrapperLoader.INSTANCE.sendTo(new MessageSABClient(player.getEntityId(), this.getRegistryName().toString(), EnumSAB.SKILL), (EntityPlayerMP) player);
    }

    @Override
    public void burst(EntityPlayer player, ItemStack itemStack) {

        ItemVenti item = (ItemVenti) itemStack.getItem();
        MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
        if (capability.hasBurstKey(item)) return;
        if (item.hasNBTTagCompoundValue(itemStack, "burst") == true) return;

        setNBTTagCompound(itemStack, "burst", true);
    }

    @Override
    public void skillClient(EntityPlayer player) {
        player.motionY = 1.2;
    }

    @Override
    public void burstClient(EntityPlayer player) {
    }

//    @Override
//    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack stack) {
//        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
//
//        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
//            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 9, 0));
//        }
//
//        return multimap;
//    }

    public void setNBTTagCompound(ItemStack itemStack, String key, Boolean value) {

        if (!itemStack.hasTagCompound()) {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setBoolean(key, false);
            itemStack.setTagCompound(nbt);
        } else {
            NBTTagCompound nbt = itemStack.getTagCompound();
            nbt.setBoolean(key, false);
        }

        itemStack.getTagCompound().setBoolean(key, value);

    }

    public boolean hasNBTTagCompoundValue(ItemStack itemStack, String key) {
        if (!itemStack.hasTagCompound()) {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setBoolean(key, false);
            itemStack.setTagCompound(nbt);
        }
        return itemStack.getTagCompound().getBoolean(key);
    }

}

