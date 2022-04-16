package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import minegenshin.wrong.EnumSAB;
import minegenshin.wrong.item.weapon.IMineGenshinWeapon;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;

import static minegenshin.wrong.registery.ItemRegistryHandler.ELEGY_FOR_THE_END;
import static minegenshin.wrong.registery.ItemRegistryHandler.WOLF_GRAVESTONE;

public class MessageSABClient implements IMessage {

    public static final Map<String, Item> CLIENTSAB = new HashMap<String, net.minecraft.item.Item>();
    int playerId;
    String weaponName;
    EnumSAB sab;


    public MessageSABClient() {
    }


    public MessageSABClient(int playerId, String weaponName, EnumSAB sab) {
        this.playerId = playerId;
        this.weaponName = weaponName;
        this.sab = sab;
    }


    @Override
    public void fromBytes(ByteBuf buf) {
        this.playerId = buf.readInt();
        this.weaponName = ByteBufUtils.readUTF8String(buf);
        this.sab = EnumSAB.valueOf(ByteBufUtils.readUTF8String(buf));
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(playerId);
        ByteBufUtils.writeUTF8String(buf, weaponName);
        ByteBufUtils.writeUTF8String(buf, sab.toString());
    }


    //作用于自己 sentTo
    //作用于所有 sentToAll
    public static class Handler implements IMessageHandler<MessageSABClient, IMessage> {
        @Override
        public IMessage onMessage(MessageSABClient message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {

                        EntityPlayer targetPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerId);
                        IMineGenshinWeapon weapon = (IMineGenshinWeapon) CLIENTSAB.get(message.weaponName);
                        if (targetPlayer != null && weapon != null) {

                                switch (message.sab) {
                                    case SKILL:
                                        weapon.skillClient(targetPlayer);
                                        break;
                                    case BURST:
                                        weapon.burstClient(targetPlayer);
                                        break;
                                }
                        }
                    }
                });
            }
            return null;
        }
    }

    public static void Init() {
        CLIENTSAB.put(ELEGY_FOR_THE_END.getRegistryName().toString(), ELEGY_FOR_THE_END);
        CLIENTSAB.put(WOLF_GRAVESTONE.getRegistryName().toString(), WOLF_GRAVESTONE);
    }

}

