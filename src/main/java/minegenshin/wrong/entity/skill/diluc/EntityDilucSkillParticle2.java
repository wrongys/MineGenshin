package minegenshin.wrong.entity.skill.diluc;

import minegenshin.wrong.api.IMineGenshinEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

import static minegenshin.wrong.api.IMineGenshinWeapon.SKILL;

public class EntityDilucSkillParticle2 extends Entity {
    public EntityDilucSkillParticle2(World worldIn) {
        super(worldIn);
        this.setSize(0.1F, 0.1F);
    }

    public EntityDilucSkillParticle2(World worldIn, double x, double y, double z, float playerYaw) {
        this(worldIn);
        this.setPosition(x, y, z);
        this.setInvisible(true);
        this.rotationYaw = playerYaw;
    }

    @Override
    public void onUpdate() {

        if (world.isRemote) {

            int Yaw = (int) this.rotationYaw + 120 - 30 * ticksExisted;
            for (int yaw = Yaw; yaw <= Yaw + 30; yaw = yaw + 5) {
                for (int pitch = 9 * ticksExisted; pitch <= 9 * ticksExisted + 9; pitch = pitch + 3) {
                    for (float r = 2.5F; r <= 3.5; r = (float) (r + 0.3)) {
                        float dx = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                        float dy = (float) (Math.sin(pitch * 0.017453292F) * r - 1);
                        float dz = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F) * r);
                        world.spawnParticle(EnumParticleTypes.FLAME, posX + dx + Math.random() * 0.3, posY + dy + Math.random() * 0.3, posZ + dz + Math.random() * 0.3, 0, 0, 0);
                        if (pitch % 2 == 0) {
                            world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.4, 0);
                            world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.8, 0);
                        }
                    }
                }
            }

        }


        if (this.ticksExisted >= 5) {

            float x = (float) (this.posX + (-Math.sin(this.rotationYaw * 0.017453292F) * 2));
            float y = (float) this.posY;
            float z = (float) (this.posZ + (Math.cos(this.rotationYaw * 0.017453292F) * 2));

            AxisAlignedBB aabb = new AxisAlignedBB(x + 2, y + 2, z + 2, x - 2, y - 2, z - 2);
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, aabb);
            for (Entity entity : list
            ) {
                if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && !(entity instanceof IMineGenshinEntity)) {
                    ((EntityLivingBase) entity).attackEntityFrom(SKILL, 12);
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
