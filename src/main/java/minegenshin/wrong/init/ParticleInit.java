package minegenshin.wrong.init;

import minegenshin.wrong.client.particle.ParticleXiaoBurst;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ParticleInit {
    public static final Map<Integer, EnumParticleTypes> MGParticleHelper = new HashMap<Integer, EnumParticleTypes>();
    public static EnumParticleTypes XIAO_BURST;

    public static void init() {
        addEnumParticle();
        registerParticle();
        addMapHelper();
    }

    private static void addEnumParticle() {
        Class<?>[] particleEnum = {String.class, int.class, boolean.class, int.class};

        XIAO_BURST = EnumHelper.addEnum(EnumParticleTypes.class, "XIAO_BURST", particleEnum, "xiao_burst", EnumParticleTypes.values().length, true, 0);
    }

    public static void registerParticle() {
        Minecraft.getMinecraft().effectRenderer.registerParticle(XIAO_BURST.getParticleID(), new ParticleXiaoBurst.Factory());
    }

    public static void addMapHelper() {

    }

    public static EnumParticleTypes getMGParticle(Integer integer) {
        return MGParticleHelper.get(integer);
    }

}
