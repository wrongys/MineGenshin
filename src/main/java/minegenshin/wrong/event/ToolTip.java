package minegenshin.wrong.event;

import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.item.weapon.ItemVenti;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static minegenshin.wrong.Data.TOOLTIP_VENTI;

@Mod.EventBusSubscriber(modid = MineGenshin.MOD_ID)
public class ToolTip {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void toolTip(ItemTooltipEvent event) {
//        if (event.getItemStack().getItem() instanceof ItemVenti) {
//            event.getToolTip().add(TextFormatting.DARK_GREEN + I18n.format(TOOLTIP_VENTI));
//        }
    }
}
