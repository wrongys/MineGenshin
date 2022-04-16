package minegenshin.wrong.entity.skill.diluc;

import minegenshin.wrong.entity.skill.IMineGenshinEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

import static minegenshin.wrong.item.weapon.IMineGenshinWeapon.SKILL;

public class EntityDilucSkillParticle3 extends Entity {
    public EntityDilucSkillParticle3(World worldIn) {
        super(worldIn);
        this.setSize(0.1F, 0.1F);
    }

    public EntityDilucSkillParticle3(World worldIn, double x, double y, double z, float playerYaw) {
        this(worldIn);
        this.setPosition(x, y, z);
        this.rotationYaw = playerYaw;

    }


    @Override
    public void onUpdate() {
        if (this.ticksExisted <= 2) {
            for (int pitch = 45 - 45 * this.ticksExisted; pitch >= -45 * this.ticksExisted; pitch = pitch - 5) {

                float r0 = (float) (1 - pitch * 0.25 / 90);
                for (float r = r0; r <= r0 + 1; r = (float) (r + 0.2)) {

                    float dx = (float) (-Math.sin(this.rotationYaw * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                    float dy = (float) (Math.sin(pitch * 0.017453292F) * r);
                    float dz = (float) (Math.cos(this.rotationYaw * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                    world.spawnParticle(EnumParticleTypes.FLAME, posX + dx + Math.random() * 0.4, posY + dy + Math.random() * 0.1, posZ + dz + Math.random() * 0.4, 0, 0, 0);
                    if (pitch % 2 == 0) {
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.4, 0);
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.8, 0);
                    }

                }
            }
        }
        if (this.ticksExisted >= 3 && this.ticksExisted <= 6) {
            for (int pitch = 45 * this.ticksExisted - 225; pitch <= 45 * this.ticksExisted - 180; pitch = pitch + 5) {

                float r0 = (float) (1.25 + (pitch + 90) * 0.5 / 180);
                for (float r = r0; r <= r0 + 1; r = (float) (r + 0.2)) {

                    float dx = (float) (-Math.sin((this.rotationYaw + 180) * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                    float dy = (float) (Math.sin(pitch * 0.017453292F) * r);
                    float dz = (float) (Math.cos((this.rotationYaw + 180) * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                    world.spawnParticle(EnumParticleTypes.FLAME, posX + dx + Math.random() * 0.4, posY + dy + Math.random() * 0.1, posZ + dz + Math.random() * 0.4, 0, 0, 0);
                    if (pitch % 2 == 0) {
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.4, 0);
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.8, 0);
                    }

                }
            }
        }
        if (this.ticksExisted >= 7 && this.ticksExisted <= 8) {
            for (int pitch = 405 - 45 * this.ticksExisted; pitch >= 360 - 45 * this.ticksExisted; pitch = pitch - 5) {
                float r0 = (float) (2 - pitch * 0.25 / 90);

                for (float r = r0; r <= r0 + 1; r = (float) (r + 0.2)) {

                    float dx = (float) (-Math.sin(this.rotationYaw * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                    float dy = (float) (Math.sin(pitch * 0.017453292F) * r);
                    float dz = (float) (Math.cos(this.rotationYaw * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                    world.spawnParticle(EnumParticleTypes.FLAME, posX + dx + Math.random() * 0.4, posY + dy + Math.random() * 0.1, posZ + dz + Math.random() * 0.4, 0, 0, 0);
                    if (pitch % 2 == 0) {
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.4, 0);
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.8, 0);
                    }

                }
            }
        }

        if (this.ticksExisted >= 8) {

            float x = (float) (this.posX + (-Math.sin(this.rotationYaw * 0.017453292F) * 2));
            float y = (float) this.posY;
            float z = (float) (this.posZ + (Math.cos(this.rotationYaw * 0.017453292F) * 2));

            AxisAlignedBB aabb = new AxisAlignedBB(x + 2, y + 2, z + 2, x - 2, y - 2, z - 2);
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, aabb);
            for (Entity entity : list
            ) {
                if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && !(entity instanceof IMineGenshinEntity)) {
                    ((EntityLivingBase) entity).attackEntityFrom(SKILL, 15);
                }
            }

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
