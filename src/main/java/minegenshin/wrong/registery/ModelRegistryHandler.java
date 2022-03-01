package minegenshin.wrong.registery;

import minegenshin.wrong.MineGenshin;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static minegenshin.wrong.registery.ItemBlockRegistryHandler.ITEM_BLOCKS;
import static minegenshin.wrong.registery.ItemRegistryHandler.ITEMS;

@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
public class ModelRegistryHandler {


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {

        for (Item item : ITEMS) {

            registerModel(item);
        }
        for (ItemBlock itemBlock:ITEM_BLOCKS){

            registerModel(itemBlock);
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item) {

        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }
}
