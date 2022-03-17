package minegenshin.wrong.network;

import minegenshin.wrong.MineGenshin;
import minegenshin.wrong.network.message.MessageSAB;
import minegenshin.wrong.network.message.MessageElemental;
import minegenshin.wrong.network.message.MessageSABClient;
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
        registerMessage(MessageSpawnParticle.Handler.class, MessageSpawnParticle.class, Side.CLIENT);
        registerMessage(MessageSAB.Handler.class, MessageSAB.class, Side.SERVER);//服务端技能
        registerMessage(MessageSABClient.Handler.class, MessageSABClient.class, Side.CLIENT);//客户端技能&特效
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
            Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side) {
        INSTANCE.registerMessage(messageHandler, requestMessageType, nextId++, side);
    }
}
