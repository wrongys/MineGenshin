package minegenshin.wrong.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EntityNingGuangA extends Entity implements IProjectile {

    public EntityLivingBase thrower;
    public EntityLivingBase target;
    public static final DataParameter<Integer> TARGET_ENTITY_ID = EntityDataManager.<Integer>createKey(EntityNingGuangA.class, DataSerializers.VARINT);
    public static final float SPEED = 1.5F;

    public EntityNingGuangA(World worldIn) {
        super(worldIn);
        this.setSize(0.5F, 0.5F);
    }

    public EntityNingGuangA(World worldIn, double x, double y, double z, EntityLivingBase thrower) {
        this(worldIn);
        this.setPosition(x, y, z);
        this.thrower = thrower;
    }

    @Override
    protected void entityInit() {
        this.dataManager.register(TARGET_ENTITY_ID, 0);
    }

    public void shoot(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy) {
        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float f1 = -MathHelper.sin(pitch * 0.017453292F);
        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.shoot((double) f, (double) f1, (double) f2, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;

        if (!shooter.onGround) {
            this.motionY += shooter.motionY;
        }
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

    public void onHit(RayTraceResult result) {
        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            Entity entity = result.entityHit;

            if (entity instanceof EntityLivingBase) {
                EntityLivingBase entity1 = (EntityLivingBase) entity;

                if (entity1.attackEntityFrom(new DamageSource("A"), 1)) {
                    entity1.hurtResistantTime = 0;
                    this.setDead();
                }
            }
        }

        if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            this.setDead();
        }
    }

    @Nullable
    protected Entity findEntityOnPath(Vec3d start, Vec3d end) {
        Entity entity = null;
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0D), null);
        double d0 = 0.0D;

        for (int i = 0; i < list.size(); ++i) {
            Entity entity1 = list.get(i);

            if (entity1 != this.thrower && entity1 instanceof EntityLivingBase && entity1.isEntityAlive()) {
                AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
                RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(start, end);

                if (raytraceresult != null) {
                    double d1 = start.squareDistanceTo(raytraceresult.hitVec);

                    if (d1 < d0 || d0 == 0.0D) {
                        entity = entity1;
                        d0 = d1;
                    }
                }
            }
        }

        return entity;
    }

    @Override
    public void onUpdate() {

        super.onUpdate();

        if (ticksExisted >= 20 * 4) {
            this.setDead();
        }

        tryTargeting();

        setRotation();


        Vec3d vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
        vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
        vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (raytraceresult != null) {
            vec3d = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
        }

        Entity entity = this.findEntityOnPath(vec3d1, vec3d);

        if (entity != null) {
            raytraceresult = new RayTraceResult(entity);
        }

        if (raytraceresult != null && raytraceresult.entityHit instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) raytraceresult.entityHit;

            if (this.thrower instanceof EntityPlayer && !((EntityPlayer) this.thrower).canAttackPlayer(entityplayer)) {
                raytraceresult = null;
            }
        }

        if (raytraceresult != null && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
            this.onHit(raytraceresult);
        }


        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f4 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float) (MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

        for (this.rotationPitch = (float) (MathHelper.atan2(this.motionY, (double) f4) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
            ;
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

        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);
            }
        }

        if (this.isWet()) {
            this.extinguish();
        }


        this.setPosition(this.posX, this.posY, this.posZ);
        this.doBlockCollisions();

    }


    public void tryTargeting() {

        if (getTargetEntityId() == 0) {
            this.target = findEntity(15, 3);
            if (this.target != null && target.isEntityAlive()) {
                this.dataManager.set(TARGET_ENTITY_ID, target.getEntityId());
            }
        }

        if (!this.world.isRemote && this.target == null) {
            this.dataManager.set(TARGET_ENTITY_ID, 0);
        }

    }

    public void setRotation() {

        Entity entity = this.world.getEntityByID(getTargetEntityId());

        if (entity != null && entity instanceof EntityLivingBase && entity.isEntityAlive()) {
            Vec3d vec3d1 = new Vec3d(this.motionX, this.motionY, this.motionZ);//速度方向
            Vec3d vec3d2 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d vec3d3 = new Vec3d(entity.posX, entity.posY + 0.5, entity.posZ);
            Vec3d vec3d = vec3d2.subtractReverse(vec3d3).normalize();//目标方向单位向量

            if (vec3d == Vec3d.ZERO) return;

            double d = vec3d1.dotProduct(vec3d) / (vec3d1.lengthVector() * vec3d.lengthVector());

            if (d >= 1 || d <= -1) return;

            double angle = Math.acos(d);
            double maxAngle = 0.523;

            if (angle < maxAngle) {
                this.motionX = vec3d.scale(SPEED).x;
                this.motionY = vec3d.scale(SPEED).y;
                this.motionZ = vec3d.scale(SPEED).z;
            } else {
                Vec3d vec3d4 = vec3d1.add(vec3d).normalize();//方向修正
                if (vec3d4 == Vec3d.ZERO) return;
                Vec3d vec3d5 = vec3d4.scale(SPEED);
                this.motionX = vec3d5.x;
                this.motionY = vec3d5.y;
                this.motionZ = vec3d5.z;
            }

        }
    }

    public EntityLivingBase findEntity(int distance, float scale) {

        double x = this.motionX;
        double y = this.motionY;
        double z = this.motionZ;
        double l = Math.sqrt(x * x + y * y + z * z);
        if (l != 0) {
            x = x / l;
            y = y / l;
            z = z / l;
        }

        EntityLivingBase target1 = null;

        for (int i = 1; i <= distance; i++) {

            List<Entity> entities = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().offset(x * i * (i + 1) / 2, y * i * (i + 1) / 2, z * i * (i + 1) / 2).grow(i));
            if (!entities.isEmpty()) {

                for (Entity entity : entities
                ) {
                    if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && entity.isEntityAlive()) {

                        EntityLivingBase target2 = (EntityLivingBase) entity;

                        if (target1 == null) {
                            target1 = target2;
                        }

                        Vec3d vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
                        Vec3d vec3d2 = new Vec3d(target1.posX, target1.posY, target1.posZ);
                        Vec3d vec3d3 = new Vec3d(target2.posX, target2.posY, target2.posZ);

                        if (vec3d1.distanceTo(vec3d3) < vec3d1.distanceTo(vec3d2)) {
                            target1 = target2;
                        }
                    }
                }

                if (target1 != null) return target1;

            }

        }

        return null;
    }

    public int getTargetEntityId() {
        return this.dataManager.get(TARGET_ENTITY_ID);
    }

    public void setTargetEntityId(int id) {
        this.dataManager.set(TARGET_ENTITY_ID, id);
    }


    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        this.dataManager.set(TARGET_ENTITY_ID, compound.getInteger("TargetEntityId"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("TargetEntityId", this.dataManager.get(TARGET_ENTITY_ID));
    }
}
