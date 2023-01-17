package minegenshin.wrong.entity.skill.ningguang;

import minegenshin.wrong.MineGenshin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;


public class EntityNingGuangSkill extends EntityLiving implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    public EntityNingGuangSkill(World worldIn) {
        super(worldIn);
        this.setSize(0.5F, 1F);
    }


    @Override
    public void onUpdate() {
//        super.onUpdate();

        AxisAlignedBB aabb = new AxisAlignedBB(this.posX - 2, this.posY - 2, this.posZ - 2, this.posX + 2, this.posY + 2, this.posZ + 2);
        List<Entity> entities = this.world.getEntitiesWithinAABB(Entity.class, aabb);


        if (this.ticksExisted >= 10 * 20) {
            this.setDead();
        }


    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!net.minecraftforge.common.ForgeHooks.onLivingAttack(this, source, amount)) return false;
        return false;
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation((new AnimationBuilder()).addAnimation("animation.ning_guang_skill.spawn", false));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}


@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
class RemoveThrowable {

    @SubscribeEvent
    public void onAttack(LivingAttackEvent event) {

    }
}
