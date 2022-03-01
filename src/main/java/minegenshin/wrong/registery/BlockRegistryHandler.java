package minegenshin.wrong.registery;



import minegenshin.wrong.MineGenshin;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
public class BlockRegistryHandler {



    public static Block[] BLOCKS = new Block[]{

    };

    @SubscribeEvent
    public static void onRegistryBlock(Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        for (Block block : BLOCKS
        ) {

            registry.register(block);
        }

    }
}




