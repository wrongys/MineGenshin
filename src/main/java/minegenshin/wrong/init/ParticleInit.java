package minegenshin.wrong.init;

import minegenshin.wrong.client.render.particle.ParticleMGSweepPyro;
import minegenshin.wrong.client.render.particle.ParticleRedstoneCopy;
import minegenshin.wrong.client.render.particle.ParticleSweepAttackCopy;
import minegenshin.wrong.client.render.particle.ParticleWendyExplosion;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ParticleInit {
    public static Map<Integer, EnumParticleTypes> MGParticleHelper = new HashMap<Integer, EnumParticleTypes>();
    public static EnumParticleTypes ParticleMGSweepPyro;
    public static EnumParticleTypes myParticle2;
    public static EnumParticleTypes myParticle3;
    public static EnumParticleTypes ParticleMGRedstone;

    public static void init() {
        addEnumParticle();
        registerParticle();
        addMapHelper();
    }

    private static void addEnumParticle() {
        Class<?>[] particleEnum = {String.class, int.class, boolean.class, int.class};

        ParticleMGSweepPyro = EnumHelper.addEnum(EnumParticleTypes.class, "ParticleMGSweepPyro", particleEnum,
                "ParticleMGSweepPyro_", EnumParticleTypes.values().length, false, 0);

        myParticle2 = EnumHelper.addEnum(EnumParticleTypes.class, "sweep_copy", particleEnum,
                "sweep_copy", EnumParticleTypes.values().length, false, 0);

        myParticle3 = EnumHelper.addEnum(EnumParticleTypes.class, "wendy_explosion", particleEnum,
                "wendy_explosion", EnumParticleTypes.values().length, false, 0);

        ParticleMGRedstone = EnumHelper.addEnum(EnumParticleTypes.class, "ParticleMGRedstone", particleEnum,
                "ParticleMGRedstone", EnumParticleTypes.values().length, false, 0);

    }

    public static void registerParticle() {
        Minecraft.getMinecraft().effectRenderer.registerParticle(ParticleMGSweepPyro.getParticleID(), new ParticleMGSweepPyro.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(myParticle2.getParticleID(), new ParticleSweepAttackCopy.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(myParticle3.getParticleID(), new ParticleWendyExplosion.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(ParticleMGRedstone.getParticleID(), new ParticleRedstoneCopy.Factory());
    }

    public static void addMapHelper() {
        MGParticleHelper.put(ParticleMGSweepPyro.getParticleID(), ParticleMGSweepPyro);
        MGParticleHelper.put(myParticle2.getParticleID(), myParticle2);
        MGParticleHelper.put(myParticle3.getParticleID(), myParticle3);
        MGParticleHelper.put(ParticleMGRedstone.getParticleID(), ParticleMGRedstone);
    }

    public static EnumParticleTypes getMGParticle(Integer integer) {
        return MGParticleHelper.get(integer);
    }

}
