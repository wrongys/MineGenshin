package minegenshin.wrong.event;


import minegenshin.wrong.init.KeyBindingInit;
import minegenshin.wrong.item.weapon.ItemMineGenshinWeapon;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.network.message.MessageBurst;
import minegenshin.wrong.network.message.MessageSkill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeySAB {

    @SubscribeEvent
    public void onKeyPressedSkill(InputEvent.KeyInputEvent event) {

        if (KeyBindingInit.SKILL.isPressed()) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayerSP player = mc.player;
            ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
            if (stack != null && stack.getItem() instanceof ItemMineGenshinWeapon) {
                SimpleNetworkWrapperLoader.INSTANCE.sendToServer(new MessageSkill(player.getEntityId(), player.getName()));
            }
        }
    }

    @SubscribeEvent
    public void onKeyPressedBurst(InputEvent.KeyInputEvent event) {

        if (KeyBindingInit.BURST.isPressed()) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayerSP player = mc.player;
            ItemStack stack = player.getHeldItemMainhand();
            if (stack != null && stack.getItem() instanceof ItemMineGenshinWeapon) {
                SimpleNetworkWrapperLoader.INSTANCE.sendToServer(new MessageBurst(player.getEntityId(), player.getName()));
            }
        }
    }

}
