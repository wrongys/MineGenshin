package minegenshin.wrong.entity.skill.wendy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import static minegenshin.wrong.item.weapon.ItemMineGenshinWeapon.BURST;

public class EntityWendyBurst extends Entity {


    private ItemStack itemStack;

    public EntityWendyBurst(World worldIn) {
        super(worldIn);
    }

    public EntityWendyBurst(World worldIn, BlockPos blockPos) {
        super(worldIn);
        this.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());

    }

    @Override
    public void onUpdate() {

        double x = this.posX;
        double y = this.posY;
        double z = this.posZ;
        AxisAlignedBB aabb = new AxisAlignedBB(x + 10, y + 10, z + 10, x - 10, y - 10, z - 10);
        List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, aabb);


        for (Entity targetEntity : entityList
        ) {
            if (!(targetEntity instanceof EntityPlayer) && targetEntity.isNonBoss()) {

                double targetEntityPosX = targetEntity.posX;
                double targetEntityPosY = targetEntity.posY;
                double targetEntityPosZ = targetEntity.posZ;

                if (!(x == targetEntityPosX && y == targetEntityPosY && z == targetEntityPosZ)) {

                    double vectorX = x - targetEntity.posX;
                    double vectorY = y - targetEntity.posY;
                    double vectorZ = z - targetEntity.posZ;
                    double l = Math.sqrt(vectorX * vectorX + vectorY * vectorY + vectorZ * vectorZ);
                    if (l < 10 && l > 1) {

                        targetEntity.motionX = targetEntity.motionX + vectorX / l * 0.11;
                        targetEntity.motionY = targetEntity.motionY + vectorY / l * 0.11;
                        targetEntity.motionZ = targetEntity.motionZ + vectorZ / l * 0.11;

                    }

                    if (ticksExisted % 10 == 0 && targetEntity instanceof EntityLivingBase && l <= 6) {
                        targetEntity.attackEntityFrom(BURST, 1F);
                        if (world.isRemote) {
                            world.spawnParticle(EnumParticleTypes.SWEEP_ATTACK, targetEntityPosX, targetEntityPosY + 1, targetEntityPosZ, 0, 0, 0);
                        }
                    }
                }
            }
        }

        if (this.world.isRemote) {
            this.world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX + 6 * Math.random() - 3, this.posY + 6 * Math.random() - 3, this.posZ + 6 * Math.random() - 3, 0.01, 0.35, 0.27);
        }

        if (this.ticksExisted >= 10 * 20) {
            this.setDead();
        }


    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }
}
