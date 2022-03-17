package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import minegenshin.wrong.EnumSAB;
import minegenshin.wrong.capability.MGWeaponCdCapability;
import minegenshin.wrong.init.CapabilityInit;
import minegenshin.wrong.item.weapon.ItemMineGenshinWeapon;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageSABClient implements IMessage {


    int id;
    String userName;
    EnumSAB sab;


    public MessageSABClient() {
    }

    public MessageSABClient(int id, String userName,EnumSAB sab) {
        this.id = id;
        this.userName = userName;
        this.sab = sab;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.id = buf.readInt();
        this.userName = ByteBufUtils.readUTF8String(buf);
        this.sab = EnumSAB.valueOf(ByteBufUtils.readUTF8String(buf));
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(id);
        ByteBufUtils.writeUTF8String(buf, userName);
        ByteBufUtils.writeUTF8String(buf, sab.toString());
    }


    public static class Handler implements IMessageHandler<MessageSABClient, IMessage> {
        @Override
        public IMessage onMessage(MessageSABClient message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        EntityPlayer player = Minecraft.getMinecraft().player;
                        ItemStack stack = player.getHeldItemMainhand();

                        if (stack != null && stack.getItem() instanceof ItemMineGenshinWeapon) {
                            ItemMineGenshinWeapon item = (ItemMineGenshinWeapon) stack.getItem();

                            switch (message.sab){
                                case SKILL:
                                    item.skillClient(player, stack);
                                    break;
                                case BURST:
                                    item.burstClient(player, stack);
                                    break;

                            }
                        }

                    }
                });
            }
            return null;
        }
    }


}

