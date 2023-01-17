package minegenshin.wrong.client.layer;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class LayerPlungeAttack<T extends EntityPlayerSP> implements LayerRenderer<T> {

    private static final ResourceLocation PLUNGE_ATTACK = new ResourceLocation("minegenshin:textures/layer/layer_plunge_attack.png");


    @Override
    public void doRenderLayer(T entityPlayer, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
