package minegenshin.wrong.event;

import minegenshin.wrong.item.weapon.ItemDiluc;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MGWeaponSweeping {

    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent event) {

        EntityPlayer player = event.getEntityPlayer();
        Entity entity = event.getTarget();

        if (player != null && entity instanceof EntityLivingBase) {
            EntityLivingBase target = (EntityLivingBase) entity;


            float f = (float) player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
            float f1;

            f1 = EnchantmentHelper.getModifierForCreature(player.getHeldItemMainhand(), target.getCreatureAttribute());

            float f2 = player.getCooledAttackStrength(0.5F);
            f = f * (0.2F + f2 * f2 * 0.8F);
            f1 = f1 * f2;

            if (f > 0.0F || f1 > 0.0F) {
                boolean flag = f2 > 0.9F;
                boolean flag1 = false;
                int i = 0;
                i = i + EnchantmentHelper.getKnockbackModifier(player);

                if (player.isSprinting() && flag) {
                    player.world.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, player.getSoundCategory(), 1.0F, 1.0F);
                    ++i;
                    flag1 = true;
                }

                boolean flag2 = flag && player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(MobEffects.BLINDNESS) && !player.isRiding();
                flag2 = flag2 && !player.isSprinting();

                net.minecraftforge.event.entity.player.CriticalHitEvent hitResult = net.minecraftforge.common.ForgeHooks.getCriticalHit(player, target, flag2, flag2 ? 1.5F : 1.0F);
                flag2 = hitResult != null;
                if (flag2) {
                    f *= hitResult.getDamageModifier();
                }

                f = f + f1;
                boolean flag3 = false;
                double d0 =  player.distanceWalkedModified - player.prevDistanceWalkedModified;

                if (flag && !flag2 && !flag1 && player.onGround && d0 < (double) player.getAIMoveSpeed()) {
                    ItemStack itemstack = player.getHeldItem(EnumHand.MAIN_HAND);

                    if (itemstack.getItem() instanceof ItemDiluc) {
                        flag3 = true;
                    }
                }


                if (flag3) {
                    float f3 = (float) (player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue() * 0.75);

                    for (EntityLivingBase entitylivingbase : player.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(1.0D, 0.25D, 1.0D))) {
                        if (entitylivingbase != player && entitylivingbase != target && !player.isOnSameTeam(entitylivingbase) && player.getDistanceSq(entitylivingbase) < 9.0D) {
                            entitylivingbase.knockBack(player, 0.4F, (double) MathHelper.sin(player.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(player.rotationYaw * 0.017453292F)));
                            entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(player), f3);
                        }
                    }

                    player.world.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, player.getSoundCategory(), 1.0F, 1.0F);
                    player.spawnSweepParticles();
                }

            }

        }
    }

}
