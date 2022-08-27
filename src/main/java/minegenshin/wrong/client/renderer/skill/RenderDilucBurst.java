package minegenshin.wrong.client.renderer.skill;

import minegenshin.wrong.client.model.ModelDilucBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderDilucBurst extends RenderLiving<EntityDilucBurst> {

    private static ResourceLocation TEXTURE = new ResourceLocation("minegenshin:textures/skill/diluc_burst.png");

    public RenderDilucBurst(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDilucBurst(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDilucBurst entity) {
        return TEXTURE;
    }
}
