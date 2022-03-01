package minegenshin.wrong.event;

import minegenshin.wrong.elemental.ElementalType;
import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.Set;

//渲染血条和元素显示
@SideOnly(Side.CLIENT)
public class RenderHAE {

    private static final ResourceLocation HEALTH_BAR = new ResourceLocation("minegenshin:textures/entitybasic/health_bar.png");//血条

    private static final ResourceLocation PYRO = new ResourceLocation("minegenshin:textures/elemental/pyro.png");//火
    private static final ResourceLocation HYDRO = new ResourceLocation("minegenshin:textures/elemental/hydro.png");//水
    private static final ResourceLocation ELECTRO = new ResourceLocation("minegenshin:textures/elemental/electro.png");//雷
    private static final ResourceLocation CYRO = new ResourceLocation("minegenshin:textures/elemental/cyro.png");//冰


    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        Entity cameraEntity = mc.getRenderViewEntity();
        BlockPos renderingVector = cameraEntity.getPosition();

        Frustum frustum = new Frustum();
        float partialTicks = event.getPartialTicks();
        double viewX = cameraEntity.lastTickPosX + (cameraEntity.posX - cameraEntity.lastTickPosX) * partialTicks;
        double viewY = cameraEntity.lastTickPosY + (cameraEntity.posY - cameraEntity.lastTickPosY) * partialTicks;
        double viewZ = cameraEntity.lastTickPosZ + (cameraEntity.posZ - cameraEntity.lastTickPosZ) * partialTicks;
        frustum.setPosition(viewX, viewY, viewZ);

        WorldClient client = mc.world;
        Set<Entity> entities = ObfuscationReflectionHelper.getPrivateValue(WorldClient.class, client, "entityList");

        for (Entity entity : entities) {

            if (entity != null && entity instanceof EntityLivingBase && (!(entity instanceof EntityPlayer)) && entity.isEntityAlive() && entity.isInRangeToRender3d(renderingVector.getX(), renderingVector.getY(), renderingVector.getZ()) && entity.isNonBoss()) {
                renderHealthBar((EntityLivingBase) entity, partialTicks, mc.player);
                renderElemental((EntityLivingBase) entity, partialTicks, mc.player);
            }

        }


    }

    public static void renderHealthBar(EntityLivingBase entityLivingBase, float partialTicks, EntityPlayer player) {

//        Stack<EntityLivingBase> ridingStack = new Stack<>();

//        EntityLivingBase entity = passedEntity;
//        ridingStack.push(entity);

//        while (!ridingStack.isEmpty()) {
//            entity = ridingStack.pop();
        if (entityLivingBase.getHealth() != entityLivingBase.getMaxHealth()) {

            RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

            double x = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * partialTicks;
            double y = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * partialTicks;
            double z = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * partialTicks;

            GlStateManager.pushMatrix();
            GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


            GlStateManager.translate((float) (x - renderManager.viewerPosX), (float) (y - renderManager.viewerPosY + entityLivingBase.height), (float) (z - renderManager.viewerPosZ));
            GlStateManager.translate(0, 0.4, 0);
            GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(-90, 0.0F, 1.0F, 0.0F);

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
            GlStateManager.disableLighting();
            Minecraft.getMinecraft().renderEngine.bindTexture(HEALTH_BAR);

            Tessellator tes = Tessellator.getInstance();

            //背景
            tes.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
            tes.getBuffer().pos(0, 0.05, -0.32).tex(0, 0).endVertex();
            tes.getBuffer().pos(0, 0, -0.32).tex(0, 0.5).endVertex();
            tes.getBuffer().pos(0, 0, 0.32).tex(1, 0.5).endVertex();
            tes.getBuffer().pos(0, 0.05, 0.32).tex(1, 0).endVertex();
            tes.draw();

            //血条
            float p = entityLivingBase.getHealth() / entityLivingBase.getMaxHealth();
            tes.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
            tes.getBuffer().pos(0, 0.05, -0.32).tex(0, 0.5).endVertex();
            tes.getBuffer().pos(0, 0, -0.32).tex(0, 1).endVertex();
            tes.getBuffer().pos(0, 0, -0.29 + 0.62 * p).tex(p, 1).endVertex();
            tes.getBuffer().pos(0, 0.05, -0.29 + 0.62 * p).tex(p, 0.5).endVertex();
            tes.draw();


            GlStateManager.enableLighting();
            GlStateManager.shadeModel(GL11.GL_FLAT);
            GlStateManager.enableCull();
            GlStateManager.popMatrix();

        }
    }

    public static void renderElemental(EntityLivingBase entityLivingBase, float partialTicks, EntityPlayer player) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

        double x = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * partialTicks;
        double y = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * partialTicks;
        double z = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * partialTicks;

        GlStateManager.pushMatrix();

        String elemental = entityLivingBase.getCapability(CapabilityInit.ELEMENTAL, null).getElementalType();
        if (elemental.equals(ElementalType.NULL)) {

            GlStateManager.popMatrix();
            return;
        } else if (elemental.equals(ElementalType.PYRO)) {

            Minecraft.getMinecraft().renderEngine.bindTexture(PYRO);

        } else if (elemental.equals(ElementalType.ELECTRO)) {

            Minecraft.getMinecraft().renderEngine.bindTexture(ELECTRO);

        } else if (elemental.equals(ElementalType.CRYO)) {

            Minecraft.getMinecraft().renderEngine.bindTexture(CYRO);

        } else if (elemental.equals(ElementalType.HYDRO)) {

            Minecraft.getMinecraft().renderEngine.bindTexture(HYDRO);

        } else {
        }
        GlStateManager.translate((float) (x - renderManager.viewerPosX), (float) (y - renderManager.viewerPosY + entityLivingBase.height), (float) (z - renderManager.viewerPosZ));
        GlStateManager.translate(0, 0.6, 0);
        GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-90, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.1, 0.1, 0.1);

        GlStateManager.disableLighting();

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
    }
}