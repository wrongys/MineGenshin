package minegenshin.wrong.render.entity.skill;


import minegenshin.wrong.entity.skill.wendy.EntityWendyBurst;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderWendyBurst extends Render<EntityWendyBurst> {
    public static final ResourceLocation WENDY_BURST_TEXTURE = new ResourceLocation("minegenshin:textures/skill/wendy_burst.png");


    public RenderWendyBurst(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityWendyBurst entity, double x, double y, double z, float entityYaw, float partialTicks) {


        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();


        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.translate(0, 0.4, 0);
        GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-90, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.ticksExisted * 360 / 5, 1.0F, 0.0F, 0.0F);

        GlStateManager.scale(2, 2, 2);

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
        GlStateManager.disableLighting();
        Minecraft.getMinecraft().renderEngine.bindTexture(WENDY_BURST_TEXTURE);

        Tessellator tes = Tessellator.getInstance();

        tes.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        tes.getBuffer().pos(0, 1, -1).tex(0, 0).endVertex();
        tes.getBuffer().pos(0, -1, -1).tex(0, 1).endVertex();
        tes.getBuffer().pos(0, -1, 1).tex(1, 1).endVertex();
        tes.getBuffer().pos(0, 1, 1).tex(1, 0).endVertex();
        tes.draw();


        GlStateManager.enableLighting();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWendyBurst entity) {
        return WENDY_BURST_TEXTURE;
    }
}
