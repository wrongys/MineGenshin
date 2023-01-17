package minegenshin.wrong.geo.renderer;

import com.sun.javafx.sg.prism.NodeEffectInput;
import minegenshin.wrong.entity.skill.ningguang.EntityNingGuangSkill;
import minegenshin.wrong.geo.model.GModelNingGuangSkill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.RenderTexture;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GRenderNingGuangSkill extends GeoEntityRenderer<EntityNingGuangSkill> {

    public static final ResourceLocation TEXTURE = new ResourceLocation("minegenshin:textures/skill/ning_guang_skill1.png");


    public GRenderNingGuangSkill(RenderManager renderManager) {
        super(renderManager, new GModelNingGuangSkill());
    }

    @Override
    public void doRender(EntityNingGuangSkill entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);


        AnimatedGeoModel model = (AnimatedGeoModel) this.getGeoModelProvider();
        IBone bone = model.getAnimationProcessor().getBone("zhuti1");
        float i = bone.getPositionX();

        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.translate(0F, 0.55F, 0F);

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.disableCull();
//        GlStateManager.disableAlpha();
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

        Tessellator tes = Tessellator.getInstance();

        GlStateManager.rotate(-entity.rotationYaw + 90, 0, 1F, 0);
        if (i > 0) {

            i = -i / 40 + 1;

            tes.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
            tes.getBuffer().pos(0, 2, -2.6 * i).tex(0.5 - 0.5 * i, 0).endVertex();
            tes.getBuffer().pos(0, 0, -2.6 * i).tex(0.5 - 0.5 * i, 1).endVertex();
            tes.getBuffer().pos(0, 0, 2.6 * i).tex(0.5 + 0.5 * i, 1).endVertex();
            tes.getBuffer().pos(0, 2, 2.6 * i).tex(0.5 + 0.5 * i, 0).endVertex();
            tes.draw();


        } else {

            tes.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
            tes.getBuffer().pos(0, 2, -2.6).tex(0, 0).endVertex();
            tes.getBuffer().pos(0, 0, -2.6).tex(0, 1).endVertex();
            tes.getBuffer().pos(0, 0, 2.6).tex(1, 1).endVertex();
            tes.getBuffer().pos(0, 2, 2.6).tex(1, 0).endVertex();
            tes.draw();

        }

        GlStateManager.enableLighting();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
//        GlStateManager.enableAlpha();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.popMatrix();

    }
}
