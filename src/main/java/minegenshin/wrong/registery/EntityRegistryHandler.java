package minegenshin.wrong.registery;


import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.entity.EntityGeoTest;
import minegenshin.wrong.entity.EntityNingGuangA;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle1;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle2;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle3;
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

    public static int nextId = 0;
    public static EntityEntry WENDY_EXPLOSION = EntityEntryBuilder.create().entity(EntityWendyBurst.class).id("wendy_explosion", nextId++).name(MineGenshin.MOD_ID + "wendy_explosion").tracker(80, 3, true).build();
    public static EntityEntry WENDY_ATTACK = EntityEntryBuilder.create().entity(EntityWendyAttack.class).id("wendy_attack", nextId++).name(MineGenshin.MOD_ID + "wendy_attack").tracker(80, 1, true).build();
    public static EntityEntry DILUC = EntityEntryBuilder.create().entity(EntityDilucBurst.class).id("diluc", nextId++).name(MineGenshin.MOD_ID + "diluc").tracker(80, 1, true).build();
    public static EntityEntry DILUC_SKILL1 = EntityEntryBuilder.create().entity(EntityDilucSkillParticle1.class).id("diluc_skill1", nextId++).name(MineGenshin.MOD_ID + "diluc_skill1").tracker(80, 1, true).build();
    public static EntityEntry DILUC_SKILL2 = EntityEntryBuilder.create().entity(EntityDilucSkillParticle2.class).id("diluc_skill2", nextId++).name(MineGenshin.MOD_ID + "diluc_skill2").tracker(80, 1, true).build();
    public static EntityEntry DILUC_SKILL3 = EntityEntryBuilder.create().entity(EntityDilucSkillParticle3.class).id("diluc_skill3", nextId++).name(MineGenshin.MOD_ID + "diluc_skill3").tracker(80, 1, true).build();
    public static EntityEntry GEO_TEST = EntityEntryBuilder.create().entity(EntityGeoTest.class).id("get_test", nextId++).name(MineGenshin.MOD_ID + "geo_test").tracker(80, 3, true).build();
    public static EntityEntry NING_GUANG_A = EntityEntryBuilder.create().entity(EntityNingGuangA.class).id("ning_guang_a", nextId++).name(MineGenshin.MOD_ID + "ning_guang_a").tracker(80, 1, true).build();

    public static EntityEntry[] Entities = {

            WENDY_EXPLOSION,
            WENDY_ATTACK,
            DILUC,
            DILUC_SKILL1,
            DILUC_SKILL2,
            DILUC_SKILL3,
            GEO_TEST,
            NING_GUANG_A
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
