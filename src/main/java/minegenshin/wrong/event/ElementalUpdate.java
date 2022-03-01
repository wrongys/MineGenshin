package minegenshin.wrong.event;

import minegenshin.wrong.capability.ElementalCapability;
import minegenshin.wrong.network.message.MessageElemental;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static minegenshin.wrong.elemental.ElementalType.NULL;


public class ElementalUpdate {

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {

        EntityLivingBase entity = event.getEntityLiving();
        if (!entity.world.isRemote) {

            ElementalCapability elementalCapability = entity.getCapability(CapabilityInit.ELEMENTAL, null);
            int elementalAmount = elementalCapability.getElementalAmount();

            if (elementalAmount > 0) {

                elementalCapability.setElementalAmount(elementalAmount - 1);

            } else if (elementalAmount == 0 && !elementalCapability.getElementalType().equals(NULL)) {

                elementalCapability.setElementalType(NULL);
                SimpleNetworkWrapperLoader.INSTANCE.sendToAll(new MessageElemental(entity));

            }
        }
    }



}

