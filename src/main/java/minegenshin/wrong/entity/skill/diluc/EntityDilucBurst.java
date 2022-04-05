package minegenshin.wrong.entity.skill.diluc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

import static minegenshin.wrong.item.weapon.IMineGenshinWeapon.BURST;


public class EntityDilucBurst extends EntityLiving {

    public EntityDilucBurst(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 0.5f);
    }


    public EntityDilucBurst(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
        float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
        float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        this.shoot((double) f, (double) f1, (double) f2, velocity, inaccuracy);
    }

    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        float f = MathHelper.sqrt(x * x + y * y + z * z);
        x = x / (double) f;
        y = y / (double) f;
        z = z / (double) f;
        x = x + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
        y = y + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
        z = z + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
        x = x * (double) velocity;
        y = y * (double) velocity;
        z = z * (double) velocity;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        float f1 = MathHelper.sqrt(x * x + z * z);
        this.rotationYaw = (float) (MathHelper.atan2(x, z) * (180D / Math.PI));
        this.rotationPitch = (float) (MathHelper.atan2(y, (double) f1) * (180D / Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    @Override
    public void onUpdate() {

        if (this.ticksExisted >= 2.5 * 20) {
            this.setDead();
        }

        if (this.ticksExisted == 1.5 * 20) {
            this.motionX = 0.01 * this.motionX;
            this.motionY = 1;
            this.motionZ = 0.01 * this.motionZ;
        }

        if (this.ticksExisted % 2 == 0) {

            AxisAlignedBB aabb = new AxisAlignedBB(this.posX + 6, this.posY + 2, this.posZ + 6,
                    this.posX - 6, this.posY - 2, this.posZ - 6);
            List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, aabb);

            double x0 = this.posX;
            double z0 = this.posZ;
            double f = this.rotationYaw * 0.017453292F;
            double x1 = x0 + 5.7 * Math.cos(f);//a=6 b=2
            double z1 = z0 - 5.7 * Math.sin(f);
            double x2 = x0 - 5.7 * Math.cos(f);
            double z2 = z0 + 5.7 * Math.sin(f);


            for (Entity entity : entityList
            ) {
                if (entity instanceof EntityLivingBase && !(entity instanceof EntityDilucBurst) && !(entity instanceof EntityPlayer)) {

                    double l = Math.sqrt((entity.posX - x1) * (entity.posX - x1) + (entity.posZ - z1) * (entity.posZ - z1))
                            + Math.sqrt((entity.posX - x2) * (entity.posX - x2) + (entity.posZ - z2) * (entity.posZ - z2));

                    if (l <= 12) {

                        EntityLivingBase entityLiving = (EntityLivingBase) entity;
                        entityLiving.addVelocity(this.motionX, this.motionY * 0.2, this.motionZ);

                        if (this.ticksExisted % 4 == 0) {
                            entityLiving.attackEntityFrom(BURST, 5);
                        }

                    }
                }
            }

        }

        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;


        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;

        float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float) (MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

        for (this.rotationPitch = (float) (MathHelper.atan2(this.motionY, (double) f) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {

        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;

        this.setPosition(this.posX, this.posY, this.posZ);
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    @Override
    public void onLivingUpdate() {


    }

}


