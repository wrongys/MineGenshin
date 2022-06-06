package minegenshin.wrong.event;

import minegenshin.wrong.capability.MGCapability;
import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HUDRender {

    public static final ResourceLocation MGBUFF_STATE = new ResourceLocation("minegenshin:textures/skill/state/state.png");

    @SubscribeEvent
    public void render(RenderGameOverlayEvent.Pre event) {

        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = mc.getRenderViewEntity();

        if (entity instanceof EntityPlayer) {
            MGCapability capability = entity.getCapability(CapabilityInit.MGWEAPON, null);

            ScaledResolution resolution = event.getResolution();
            GlStateManager.enableBlend();
            mc.getRenderManager().renderEngine.bindTexture(MGBUFF_STATE);

            if (capability.hasMGState(MGCapability.EnumSABState.XIAO_EXPLOSION)) {
                mc.ingameGUI.drawTexturedModalRect(resolution.getScaledWidth() - 28, 50, 225, 225, 32, 32);
                mc.ingameGUI.drawTexturedModalRect(resolution.getScaledWidth() - 28, 50, 1, 1, 32, 32);
            }
        }
    }
}
