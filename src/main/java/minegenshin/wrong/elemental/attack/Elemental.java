package minegenshin.wrong.elemental.attack;

import minegenshin.wrong.capability.ElementalCapability;
import minegenshin.wrong.init.CapabilityInit;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.network.message.MessageElemental;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;
import java.util.List;

import static minegenshin.wrong.elemental.ElementalDamageType.Chaozai;
import static minegenshin.wrong.elemental.ElementalDamageType.Gandian;
import static minegenshin.wrong.elemental.ElementalType.*;

//元素反应 废案
public class Elemental {

    public static void elementalAttack(@Nullable EntityLivingBase attacker, EntityLivingBase target, DamageSource damageSource) {

        ElementalCapability elementalCapability = target.getCapability(CapabilityInit.ELEMENTAL, null);
        String attachType = elementalCapability.getElementalType();//附着元素
        String damageType = damageSource.getDamageType();//攻击元素
        int damage = 2;             //计算伤害


        if (damageType.equals(NULL)) {

            //攻击
        } else {

            if (damageType.equals(GEO)) {
                if (attachType.equals(NULL) || attachType.equals(GEO)) {

                } else if (attachType.equals(HYDRO)) {

                } else if (attachType.equals(PYRO)) {

                } else if (attachType.equals(CRYO)) {

                } else if (attachType.equals(ELECTRO)) {

                }


            } else if (damageType.equals(ANEMO)) {
                if (attachType.equals(NULL) || attachType.equals(GEO)) {

                } else if (attachType.equals(HYDRO)) {

                } else if (attachType.equals(PYRO)) {

                } else if (attachType.equals(CRYO)) {

                } else if (attachType.equals(ELECTRO)) {

                }


            } else if (damageType.equals(HYDRO)) {
                if (attachType.equals(NULL) || attachType.equals(HYDRO)) {

                    elementalAttach(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage);

                } else if (attachType.equals(PYRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage * 3);

                } else if (attachType.equals(CRYO)) {



                } else if (attachType.equals(ELECTRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    target.attackEntityFrom(Gandian, 2);

                }


            } else if (damageType.equals(PYRO)) {
                if (attachType.equals(NULL) || attachType.equals(PYRO)) {

                    elementalAttach(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage);

                } else if (attachType.equals(HYDRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage * 2);

                } else if (attachType.equals(CRYO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage * 3);

                } else if (attachType.equals(ELECTRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    elementalOverloaded(target);

                }

            } else if (damageType.equals(CRYO)) {

                if (attachType.equals(NULL) || attachType.equals(CRYO)) {

                    elementalAttach(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage);

                } else if (attachType.equals(HYDRO)) {




                } else if (attachType.equals(PYRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage * 2);

                } else if (attachType.equals(ELECTRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    elementalSuperconduct(target);

                }


            } else if (damageType.equals(ELECTRO)) {

                if (attachType.equals(NULL) || attachType.equals(ELECTRO)) {

                    elementalAttach(target, elementalCapability, damageSource);
                    target.attackEntityFrom(damageSource, damage);

                } else if (attachType.equals(HYDRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    elementalElectroCharged(target);

                } else if (attachType.equals(PYRO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    elementalOverloaded(target);

                } else if (attachType.equals(CRYO)) {

                    elementalRemove(target, elementalCapability, damageSource);
                    elementalSuperconduct(target);


                }

            }

        }


    }

    public static void elementalAttach(EntityLivingBase target, DamageSource damageSource) {

        ElementalCapability capability = target.getCapability(CapabilityInit.ELEMENTAL, null);
        capability.setElementalType(damageSource.getDamageType());
        capability.setElementalAmount(ElementalCapability.ELEMENTAL_AMOUNT);
        capability.setElementalCd(ElementalCapability.ELEMENTAL_CD);
        SimpleNetworkWrapperLoader.INSTANCE.sendToAll(new MessageElemental(target));
    }

    public static void elementalAttach(EntityLivingBase target, ElementalCapability elementalCapability, DamageSource damageSource) {

        elementalCapability.setElementalType(damageSource.getDamageType());
        elementalCapability.setElementalAmount(ElementalCapability.ELEMENTAL_AMOUNT);
        elementalCapability.setElementalCd(ElementalCapability.ELEMENTAL_CD);
        SimpleNetworkWrapperLoader.INSTANCE.sendToAll(new MessageElemental(target));
    }


    public static void elementalRemove(EntityLivingBase target, DamageSource damageSource) {

        ElementalCapability elementalCapability = target.getCapability(CapabilityInit.ELEMENTAL, null);
        elementalCapability.setElementalType(NULL);
        elementalCapability.setElementalAmount(0);
        SimpleNetworkWrapperLoader.INSTANCE.sendToAll(new MessageElemental(target));
    }

    public static void elementalRemove(EntityLivingBase target, ElementalCapability elementalCapability, DamageSource damageSource) {

        elementalCapability.setElementalType(NULL);
        elementalCapability.setElementalAmount(0);
        SimpleNetworkWrapperLoader.INSTANCE.sendToAll(new MessageElemental(target));
    }

    public static void elementalOverloaded(EntityLivingBase target) {

        AxisAlignedBB aabb = new AxisAlignedBB(target.posX + 2, target.posY + 2, target.posZ + 2,
                target.posX - 2, target.posY - 2, target.posZ - 2);
        List<EntityLiving> livings = target.world.getEntitiesWithinAABB(EntityLiving.class, aabb);
        for (EntityLiving entity : livings
        ) {

            entity.attackEntityFrom(Chaozai, 2);

        }
    }

    public static void elementalElectroCharged(EntityLivingBase target) {

    }

    public static void elementalSuperconduct(EntityLivingBase target) {

        AxisAlignedBB aabb = new AxisAlignedBB(target.posX + 2, target.posY + 2, target.posZ + 2,
                target.posX - 2, target.posY - 2, target.posZ - 2);
        List<EntityLiving> livings = target.world.getEntitiesWithinAABB(EntityLiving.class, aabb);
        for (EntityLiving entity : livings
        ) {

            entity.attackEntityFrom(Chaozai, 2);

        }


    }

}
