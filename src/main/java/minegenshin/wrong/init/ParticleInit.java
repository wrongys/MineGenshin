package minegenshin.wrong.init;

import minegenshin.wrong.render.particle.ParticleExplosionLargeCopy;
import minegenshin.wrong.render.particle.ParticleSweepAttackCopy;
import minegenshin.wrong.render.particle.ParticleWendyExplosion;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.util.EnumHelper;

public class ParticleInit {
    public static EnumParticleTypes myParticle1;
    public static EnumParticleTypes myParticle2;
    public static EnumParticleTypes myParticle3;

    public static void init() {
        Class<?>[] particleEnum = {String.class, int.class, boolean.class,int.class};
         myParticle1 =  EnumHelper.addEnum(EnumParticleTypes.class, "explosion_copy", particleEnum,
                "explosion_copy", 50, false,0);
        myParticle2  =  EnumHelper.addEnum(EnumParticleTypes.class, "sweep_copy", particleEnum,
                "sweep_copy", 51, false,0);
        myParticle3  =  EnumHelper.addEnum(EnumParticleTypes.class, "wendy_explosion", particleEnum,
                "wendy_explosion", 52, false,0);


        Minecraft.getMinecraft().effectRenderer.registerParticle(50, new ParticleExplosionLargeCopy.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(51, new ParticleSweepAttackCopy.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(52, new ParticleWendyExplosion.Factory());

    }


    public static void addParticleEnum() {


    }


}
