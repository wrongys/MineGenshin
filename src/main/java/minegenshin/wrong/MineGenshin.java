package minegenshin.wrong;

import minegenshin.wrong.entity.skill.wendy.EntityWendyAttack;
import minegenshin.wrong.entity.skill.wendy.EntityWendyBurst;
import minegenshin.wrong.event.PlayerRender;
import minegenshin.wrong.init.*;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.client.render.skill.RenderWendyAttack;
import minegenshin.wrong.client.render.skill.RenderWendyBurst;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = MineGenshin.MOD_ID, name = MineGenshin.NAME, version = MineGenshin.VERSION)
public class MineGenshin {
    public static final String MOD_ID = "minegenshin";
    public static final String NAME = "MineGenshin";
    public static final String VERSION = "1.0";

    private static Logger logger;


    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        EventInit.init();
        CapabilityInit.init();
        SimpleNetworkWrapperLoader.init();
    }

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void preInitClient(FMLPreInitializationEvent event) {
        ClientEventInit.init();
        KeyBindingInit.init();
    }

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void posInit(FMLPostInitializationEvent event) {
        ParticleInit.init();
        RenderInit.init();

    }
}
