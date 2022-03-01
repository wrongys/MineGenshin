package minegenshin.wrong.event;

import minegenshin.wrong.capability.MGWeaponCdCapability;
import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MGWeaponCdUpdate {

    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) entity;
            MGWeaponCdCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
            capability.tick();
        }

    }
}
