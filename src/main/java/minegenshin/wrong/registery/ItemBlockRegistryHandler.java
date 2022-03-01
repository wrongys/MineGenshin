package minegenshin.wrong.registery;

import minegenshin.wrong.MineGenshin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;


@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
public class ItemBlockRegistryHandler {

    public static final ItemBlock[] ITEM_BLOCKS = {


    };

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> registry = event.getRegistry();

        for (ItemBlock itemBlock : ITEM_BLOCKS
        ) {

            registry.register(itemBlock);
        }

    }
}
