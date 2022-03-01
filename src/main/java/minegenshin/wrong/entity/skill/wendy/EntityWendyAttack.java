package minegenshin.wrong.entity.skill.wendy;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EntityWendyAttack extends EntityThrowable {

    private static final Predicate<Entity> ARROW_TARGETS = Predicates.and(EntitySelectors.NOT_SPECTATING, EntitySelectors.IS_ALIVE, new Predicate<Entity>() {
        public boolean apply(@Nullable Entity p_apply_1_) {
            return p_apply_1_.canBeCollidedWith();
        }
    });
    private static final DataParameter<Byte> CRITICAL = EntityDataManager.<Byte>createKey(EntityWendyAttack.class, DataSerializers.BYTE);
    private static final DataParameter<Byte> CHARGE = EntityDataManager.<Byte>createKey(EntityWendyAttack.class, DataSerializers.BYTE);
    private static final DataParameter<Byte> BURST = EntityDataManager.<Byte>createKey(EntityWendyAttack.class, DataSerializers.BYTE);
    private EntityLivingBase thrower;
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;


    protected boolean inGround;
    protected int timeInGround;
    public EntityArrow.PickupStatus pickupStatus;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage;
    private int knockbackStrength;


    public EntityWendyAttack(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 0.5f);
        this.damage = 3;
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
    }

    public EntityWendyAttack(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    public EntityWendyAttack(World worldIn, EntityLivingBase throwerIn) {
        this(worldIn);
        this.setPosition(throwerIn.posX, throwerIn.posY + (double) throwerIn.getEyeHeight() - 0.1, throwerIn.posZ);
        this.thrower = throwerIn;
        this.knockbackStrength = 1;

        if (throwerIn instanceof EntityPlayer) {
            this.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {

        Entity entity = result.entityHit;

        if (entity != null) {
            if (!(entity instanceof EntityPlayer)) {
                float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                int i = MathHelper.ceil((double) f * this.damage);
                i += this.rand.nextInt(i / 2 + 2);

                DamageSource damagesource = DamageSource.ANVIL;
                entity.attackEntityFrom(damagesource, (float) i);

                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;

                    if (this.knockbackStrength > 0) {
                        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

                        if (f1 > 0.0F) {
                            entitylivingbase.addVelocity(this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1, 0.1D, this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
                        }
                    }

//                    if (this.shootingEntity instanceof EntityLivingBase) {
//                        EnchantmentHelper.applyThornEnchantments(entitylivingbase, this.shootingEntity);
//                        EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase) this.shootingEntity, entitylivingbase);
//                    }

                    if (this.shootingEntity != null && entitylivingbase != this.shootingEntity && entitylivingbase instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                        ((EntityPlayerMP) this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                    }
                }

                this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

                if (this.getIsBurst()) {
                    spawnBurstEntity(entity);
                } else if (this.getIsCharge()) {

                    AxisAlignedBB aabb = new AxisAlignedBB(entity.posX + 3, entity.posY + 2, entity.posZ + 3, entity.posX - 3, entity.posY - 2, entity.posZ - 3);
                    List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, aabb);

                    for (Entity targetEntity : entityList
                    ) {
                        if (targetEntity instanceof EntityLivingBase && !(targetEntity instanceof EntityPlayer)) {
                            double vectorX = entity.posX - targetEntity.posX;
                            double vectorY = entity.posY - targetEntity.posY;
                            double vectorZ = entity.posZ - targetEntity.posZ;
                            double l = Math.sqrt(vectorX * vectorX + vectorY * vectorY + vectorZ * vectorZ);
                            if (l <= 6 && l != 0) {
                                targetEntity.addVelocity(vectorX / l * 0.5, 0.1, vectorZ / l * 0.5);
                            }
                        }

                    }
                }
                this.setDead();
            }
        } else {
            BlockPos block = result.getBlockPos();
            if (this.getIsBurst()) {
                spawnBurstEntity(this, block);
            } else if (this.getIsCharge()) {

                AxisAlignedBB aabb = new AxisAlignedBB(block.getX() + 3, block.getY() + 2, block.getZ() + 3, block.getX() - 3, block.getY() - 2, block.getZ() - 3);
                List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, aabb);

                for (Entity targetEntity : entityList
                ) {
                    if (targetEntity instanceof EntityLivingBase && !(targetEntity instanceof EntityPlayer)) {
                        double vectorX = block.getX() - targetEntity.posX;
                        double vectorY = block.getY() - targetEntity.posY;
                        double vectorZ = block.getZ() - targetEntity.posZ;
                        double l = Math.sqrt(vectorX * vectorX + vectorY * vectorY + vectorZ * vectorZ);
                        if (l <= 6 && l != 0) {
                            targetEntity.addVelocity(vectorX / l * 0.5, 0.1, vectorZ / l * 0.5);
                        }
                    }
                }

            }
            this.setDead();
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.world.isRemote && this.getIsBurst()) {
            for (int k = 0; k < 4; ++k) {
                this.world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX + this.motionX * (double) k / 4.0D, this.posY + this.motionY * (double) k / 4.0D, this.posZ + this.motionZ * (double) k / 4.0D, 0.01, 0.35, 0.27);
            }
        }

        if (this.ticksExisted >= 15 * 20) {
            if (this.getIsBurst()) {
                spawnBurstEntity(this);
            }
            this.setDead();
        }
    }

    @Override
    protected float getGravityVelocity() {
        return 0.03F;
    }

    public void setCharge(boolean charge) {
        byte b0 = ((Byte) this.dataManager.get(CHARGE)).byteValue();

        if (charge) {
            this.dataManager.set(CHARGE, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataManager.set(CHARGE, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    public boolean getIsCharge() {
        byte b0 = ((Byte) this.dataManager.get(CHARGE)).byteValue();
        return (b0 & 1) != 0;
    }

    public void setBurst(boolean burst) {
        byte b0 = ((Byte) this.dataManager.get(BURST)).byteValue();

        if (burst) {
            this.dataManager.set(BURST, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataManager.set(BURST, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    public boolean getIsBurst() {
        byte b0 = ((Byte) this.dataManager.get(BURST)).byteValue();
        return (b0 & 1) != 0;
    }


    @Override
    protected void entityInit() {
        this.dataManager.register(CHARGE, Byte.valueOf((byte) 0));
        this.dataManager.register(BURST, Byte.valueOf((byte) 0));
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("xTile", this.xTile);
        compound.setInteger("yTile", this.yTile);
        compound.setInteger("zTile", this.zTile);
        compound.setShort("life", (short) this.ticksInGround);
        ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(this.inTile);
        compound.setString("inTile", resourcelocation == null ? "" : resourcelocation.toString());
        compound.setByte("inData", (byte) this.inData);
        compound.setByte("shake", (byte) this.arrowShake);
        compound.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        compound.setByte("pickup", (byte) this.pickupStatus.ordinal());
        compound.setDouble("damage", this.damage);
        compound.setBoolean("charge", this.getIsCharge());
        compound.setBoolean("burst", this.getIsBurst());
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        this.xTile = compound.getInteger("xTile");
        this.yTile = compound.getInteger("yTile");
        this.zTile = compound.getInteger("zTile");
        this.ticksInGround = compound.getShort("life");

        if (compound.hasKey("inTile", 8)) {
            this.inTile = Block.getBlockFromName(compound.getString("inTile"));
        } else {
            this.inTile = Block.getBlockById(compound.getByte("inTile") & 255);
        }

        this.inData = compound.getByte("inData") & 255;
        this.arrowShake = compound.getByte("shake") & 255;
        this.inGround = compound.getByte("inGround") == 1;

        if (compound.hasKey("damage", 99)) {
            this.damage = compound.getDouble("damage");
        }

        if (compound.hasKey("pickup", 99)) {
            this.pickupStatus = EntityArrow.PickupStatus.getByOrdinal(compound.getByte("pickup"));
        } else if (compound.hasKey("player", 99)) {
            this.pickupStatus = compound.getBoolean("player") ? EntityArrow.PickupStatus.ALLOWED : EntityArrow.PickupStatus.DISALLOWED;
        }

        this.setCharge(compound.getBoolean("charge"));
        this.setBurst(compound.getBoolean("burst"));

    }

    public static void spawnBurstEntity(Entity entity) {
        if (!entity.world.isRemote) {
            EntityWendyBurst entityWendyBurst = new EntityWendyBurst(entity.world, new BlockPos(entity.posX, entity.posY + 3, entity.posZ));
            entity.world.spawnEntity(entityWendyBurst);
        }
    }

    public static void spawnBurstEntity(Entity entity, BlockPos block) {
        if (!entity.world.isRemote) {
            EntityWendyBurst entityWendyBurst = new EntityWendyBurst(entity.world, block.add(0, 3, 0));
            entity.world.spawnEntity(entityWendyBurst);
        }
    }

}

