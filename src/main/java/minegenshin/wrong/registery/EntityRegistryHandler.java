package minegenshin.wrong.registery;


import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import minegenshin.wrong.entity.skill.wendy.EntityWendyAttack;
import minegenshin.wrong.entity.skill.wendy.EntityWendyBurst;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
public class EntityRegistryHandler {

    public static EntityEntry WENDY_EXPLOSION = EntityEntryBuilder.create().entity(EntityWendyBurst.class).id("wendy_explosion", 0).name(MineGenshin.MOD_ID + "wendy_explosion").tracker(80, 3, true).build();
    public static EntityEntry WENDY_ATTACK = EntityEntryBuilder.create().entity(EntityWendyAttack.class).id("wendy_attack", 1).name(MineGenshin.MOD_ID + "wendy_attack").tracker(80, 3, true).build();
    public static EntityEntry DILUC = EntityEntryBuilder.create().entity(EntityDilucBurst.class).id("diluc",2).name(MineGenshin.MOD_ID + "diluc").tracker(80,3,true).build();

    public static EntityEntry[] Entities = {

            WENDY_EXPLOSION,
            WENDY_ATTACK,
            DILUC
    };


    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<EntityEntry> event) {

        IForgeRegistry<EntityEntry> registry = event.getRegistry();

        for (EntityEntry entity : Entities
        ) {

            registry.register(entity);
        }

    }


}
