package minegenshin.wrong.client.renderer.skill.NoContentRender;

import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle2;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderDilucBurst2 extends Render<EntityDilucSkillParticle2> {

    public RenderDilucBurst2(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityDilucSkillParticle2 entity, double x, double y, double z, float entityYaw, float partialTicks) {

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDilucSkillParticle2 entity) {
        return null;
    }
}
