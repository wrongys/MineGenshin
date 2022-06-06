package minegenshin.wrong.init;

import minegenshin.wrong.event.ElementalUpdate;
import minegenshin.wrong.event.MGUpdate;
import minegenshin.wrong.event.MGWeaponSweeping;
import net.minecraftforge.common.MinecraftForge;

public class EventInit {

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new ElementalUpdate());
        MinecraftForge.EVENT_BUS.register(new MGUpdate());
        MinecraftForge.EVENT_BUS.register(new MGWeaponSweeping());
    }
}
