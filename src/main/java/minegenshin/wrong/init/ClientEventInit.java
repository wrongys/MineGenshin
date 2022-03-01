package minegenshin.wrong.init;

import minegenshin.wrong.event.KeySAB;
import minegenshin.wrong.event.RenderHAE;
import net.minecraftforge.common.MinecraftForge;

public class ClientEventInit {

    public static void init(){
//        MinecraftForge.EVENT_BUS.register(new RenderHAE());
        MinecraftForge.EVENT_BUS.register(new KeySAB());
    }

}
