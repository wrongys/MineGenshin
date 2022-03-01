package minegenshin.wrong.registery;


import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.item.weapon.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
public class ItemRegistryHandler {


    public static final Item ITEM_SWORD_TEST_HUO = new ItemSwordTestHuo(Item.ToolMaterial.DIAMOND);
    public static final Item ITEM_SWORD_TEST_SHUI = new ItemSwordTestShui(Item.ToolMaterial.DIAMOND);
    public static final Item ITEM_SWORD_TEST_Lei = new ItemSwordTestLei(Item.ToolMaterial.DIAMOND);
    public static final Item ITEM_SWORD_TEST_Bing = new ItemSwordTestBing(Item.ToolMaterial.DIAMOND);
    public static final Item WENDY_ELEGY_FOR_THE_END = new ItemWendy().setRegistryName("wendy_elegy_for_the_end").setUnlocalizedName(MineGenshin.MOD_ID + ".Wendy_ElegyForTheEnd");

    public static final Item[] ITEMS = new Item[]{

            ITEM_SWORD_TEST_HUO,
            ITEM_SWORD_TEST_SHUI,
            ITEM_SWORD_TEST_Bing,
            ITEM_SWORD_TEST_Lei,
            WENDY_ELEGY_FOR_THE_END
    };

    @SubscribeEvent
    public static void onRegistryItem(Register<Item> event) {


        IForgeRegistry<Item> registry = event.getRegistry();
        for (Item item : ITEMS
        ) {

            registry.register(item);
        }

    }

}
