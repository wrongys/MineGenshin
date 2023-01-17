package minegenshin.wrong.geo.model;

import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.entity.skill.ningguang.EntityNingGuangSkill;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import javax.annotation.Nullable;

public class GModelNingGuangSkill extends AnimatedGeoModel<EntityNingGuangSkill> {
    public GModelNingGuangSkill() {
    }

    @Override
    public void setLivingAnimations(EntityNingGuangSkill entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone main = this.getAnimationProcessor().getBone("main");
        main.setRotationY(-entity.rotationYaw * 0.017453292F);
    }

    @Override
    public ResourceLocation getModelLocation(EntityNingGuangSkill entityNingGuangSkill) {
        return new ResourceLocation(MineGenshin.MOD_ID, "geo/ning_guang_skill.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityNingGuangSkill entityNingGuangSkill) {
        return new ResourceLocation(MineGenshin.MOD_ID, "textures/skill/ning_guang_skill.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityNingGuangSkill entityNingGuangSkill) {
        return new ResourceLocation(MineGenshin.MOD_ID, "animations/ning_guang_skill.animation.json");
    }
}
