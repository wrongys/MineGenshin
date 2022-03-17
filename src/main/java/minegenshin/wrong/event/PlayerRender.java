package minegenshin.wrong.event;

import com.mrcrayfish.obfuscate.client.event.ModelPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerRender {

    @SubscribeEvent
    public void OnPlayerRender(ModelPlayerEvent.SetupAngles.Post event) {
        event.getModelPlayer().bipedLeftLeg.rotateAngleX = (float) (60 * Math.PI / 180);
    }
}
