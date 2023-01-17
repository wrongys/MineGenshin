package minegenshin.wrong.client.renderer.skill;

import minegenshin.wrong.client.model.ModelNingGuangSkill;
import minegenshin.wrong.entity.skill.ningguang.EntityNingGuangSkill;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;


@SideOnly(Side.CLIENT)
public class RenderNingGuangSkill extends RenderLiving<EntityNingGuangSkill> {

    public static final ResourceLocation TEXTURE = new ResourceLocation("minegenshin:textures/skill/ning_guang_skill.png");

    public RenderNingGuangSkill(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelNingGuangSkill(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityNingGuangSkill entity) {
        return TEXTURE;
    }
}
