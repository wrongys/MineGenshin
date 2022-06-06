package minegenshin.wrong.client.model;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelGeoTest extends AnimatedGeoModel {

    public ModelGeoTest() {

    }

    @Override
    public void setLivingAnimations(IAnimatable entity, Integer integer, AnimationEvent animationEvent) {
        super.setLivingAnimations(entity, integer, animationEvent);
    }

    @Override
    public ResourceLocation getModelLocation(Object o) {
        return new ResourceLocation("minegenshin:geo/player.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object o) {
        return new ResourceLocation("minecraft:textures/entity/steve.png");
    }


    @Override
    public ResourceLocation getAnimationFileLocation(Object o) {
        return new ResourceLocation("minegenshin:animations/player.animation.json");
    }

}
