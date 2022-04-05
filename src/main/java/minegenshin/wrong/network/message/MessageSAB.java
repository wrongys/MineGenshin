package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import minegenshin.wrong.EnumSAB;
import minegenshin.wrong.item.weapon.IMineGenshinWeapon;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;


public class MessageSAB implements IMessage {

    int id;
    String userName;
    EnumSAB sab;

    public MessageSAB() {
    }

    public MessageSAB(int id, String userName, EnumSAB sab) {
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

    public static class Handler implements IMessageHandler<MessageSAB, IMessage> {
        @Override
        public IMessage onMessage(MessageSAB message, MessageContext ctx) {
            if (ctx.side == Side.SERVER) {
                FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        EntityPlayerMP player = ctx.getServerHandler().player;
                        ItemStack stack = player.getHeldItemMainhand();

                        if (stack != null && stack.getItem() instanceof IMineGenshinWeapon) {
                            IMineGenshinWeapon item = (IMineGenshinWeapon) stack.getItem();

                            switch (message.sab){
                                case SKILL:
                                    item.skill(player, stack);
                                    break;
                                case BURST:
                                    item.burst(player, stack);
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
