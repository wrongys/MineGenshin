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
    public static final Item ELEGY_FOR_THE_END = new ItemVenti().setRegistryName("elegy_for_the_end").setUnlocalizedName(MineGenshin.MOD_ID + ".Venti_ElegyForTheEnd");
    public static final Item WOLF_GRAVESTONE = new ItemDiluc().setRegistryName("wolf_gravestone").setUnlocalizedName(MineGenshin.MOD_ID + ".Diluc_WolfGravestone");
    public static final Item PRIMORDIAL_JADE_WINGED_SPEAR = new ItemXiao().setRegistryName("primordial_jade_winged_spear").setUnlocalizedName(MineGenshin.MOD_ID+".Xiao_PrimordialJadeWingedSpear");

    public static final Item[] ITEMS = new Item[]{
            ITEM_SWORD_TEST_HUO,
            ITEM_SWORD_TEST_SHUI,
            ITEM_SWORD_TEST_Bing,
            ITEM_SWORD_TEST_Lei,
            ELEGY_FOR_THE_END,
            WOLF_GRAVESTONE,
            PRIMORDIAL_JADE_WINGED_SPEAR
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
