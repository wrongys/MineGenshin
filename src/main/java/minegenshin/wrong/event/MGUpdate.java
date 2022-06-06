package minegenshin.wrong.event;

import minegenshin.wrong.capability.MGCapability;
import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MGUpdate {

    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            MGCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
            capability.tick();
        }

    }
}
