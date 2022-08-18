package minegenshin.wrong.client.renderer.skill.NoContentRender;

import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle3;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderDilucBurst3 extends Render<EntityDilucSkillParticle3> {

    public RenderDilucBurst3(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityDilucSkillParticle3 entity, double x, double y, double z, float entityYaw, float partialTicks) {

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDilucSkillParticle3 entity) {
        return null;
    }
}
