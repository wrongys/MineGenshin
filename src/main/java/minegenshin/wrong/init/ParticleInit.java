package minegenshin.wrong.init;

import net.minecraft.util.EnumParticleTypes;

import java.util.HashMap;
import java.util.Map;

public class ParticleInit {
    public static Map<Integer, EnumParticleTypes> MGParticleHelper = new HashMap<Integer, EnumParticleTypes>();

    public static void init() {
        addEnumParticle();
        registerParticle();
        addMapHelper();
    }

    private static void addEnumParticle() {
        Class<?>[] particleEnum = {String.class, int.class, boolean.class, int.class};

    }

    public static void registerParticle() {
    }

    public static void addMapHelper() {

    }

    public static EnumParticleTypes getMGParticle(Integer integer) {
        return MGParticleHelper.get(integer);
    }

}
