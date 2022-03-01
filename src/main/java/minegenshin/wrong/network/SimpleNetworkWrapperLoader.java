package minegenshin.wrong.network;

import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.item.weapon.ItemWendyMessageSkillExtra;
import minegenshin.wrong.network.message.MessageBurst;
import minegenshin.wrong.network.message.MessageElemental;
import minegenshin.wrong.network.message.MessageSkill;
import minegenshin.wrong.network.message.MessageSpawnParticle;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class SimpleNetworkWrapperLoader {

    public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MineGenshin.MOD_ID);
    private static int nextId = 0;

    public static void init() {
        registerMessage(MessageElemental.Handler.class, MessageElemental.class, Side.CLIENT);
        registerMessage(MessageBurst.Handler.class, MessageBurst.class, Side.SERVER);
        registerMessage(MessageSkill.Handler.class, MessageSkill.class, Side.SERVER);
        registerMessage(ItemWendyMessageSkillExtra.Handler.class, ItemWendyMessageSkillExtra.class, Side.CLIENT);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
            Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side) {
        INSTANCE.registerMessage(messageHandler, requestMessageType, nextId++, side);
    }
}
