package minegenshin.wrong.client.render.skill;

import minegenshin.wrong.client.model.ModelDilucBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDilucBurst extends RenderLiving<EntityDilucBurst> {

    private static ResourceLocation DILUC_TEXTURE = new ResourceLocation("minegenshin:textures/skill/diluc.png");

    public RenderDilucBurst(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDilucBurst(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDilucBurst entity) {
        return DILUC_TEXTURE;
    }
}
