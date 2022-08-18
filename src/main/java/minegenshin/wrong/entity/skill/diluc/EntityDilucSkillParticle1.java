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

public class EntityDilucSkillParticle1 extends Entity {
    public EntityDilucSkillParticle1(World worldIn) {
        super(worldIn);
        this.setSize(0.1F, 0.1F);
    }

    public EntityDilucSkillParticle1(World worldIn, double x, double y, double z, float playerYaw) {
        this(worldIn);
        this.setPosition(x, y, z);
        this.setInvisible(true);
        this.rotationYaw = playerYaw;

    }


    @Override
    public void onUpdate() {

        if (world.isRemote) {
            int tick = 120 - ticksExisted * 30;
            for (int i = tick; i <= tick && i >= tick - 30; i = i - 3) {
                for (float l = 1.5F; l <= 2.5; l = (float) (l + 0.2)) {
                    float dx = (float) (-Math.sin(this.rotationYaw * 0.017453292F) * Math.cos(i * 0.017453292F) * l);
                    float dy = (float) (Math.sin(i * 0.017453292F) * l);
                    float dz = (float) (Math.cos(this.rotationYaw * 0.017453292F) * Math.cos(i * 0.017453292F) * l);
                    world.spawnParticle(EnumParticleTypes.FLAME, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 0, 0, 0);
                    if (i % 2 == 0) {
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.4, 0);
                        world.spawnParticle(EnumParticleTypes.REDSTONE, posX + dx + Math.random() * 0.2, posY + dy + Math.random() * 0.2, posZ + dz + Math.random() * 0.2, 1F, 0.8, 0);
                    }
                }
            }
        }


        if (this.ticksExisted >= 4) {

            float x = (float) (this.posX + (-Math.sin(this.rotationYaw * 0.017453292F) * 2));
            float y = (float) this.posY;
            float z = (float) (this.posZ + (Math.cos(this.rotationYaw * 0.017453292F) * 2));

            AxisAlignedBB aabb = new AxisAlignedBB(x + 2, y + 2, z + 2, x - 2, y - 2, z - 2);
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, aabb);
            for (Entity entity : list
            ) {
                if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && !(entity instanceof IMineGenshinEntity)) {
                    ((EntityLivingBase) entity).attackEntityFrom(SKILL, 10);
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
