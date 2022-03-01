package minegenshin.wrong.item.weapon;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ItemWendyMessageSkillExtra implements IMessage {

    int id;
    String userName;

    public ItemWendyMessageSkillExtra() {
    }

    public ItemWendyMessageSkillExtra(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.id = buf.readInt();
        this.userName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(id);
        ByteBufUtils.writeUTF8String(buf, userName);

    }

    public static class Handler implements IMessageHandler<ItemWendyMessageSkillExtra, IMessage> {
        @Override
        public IMessage onMessage(ItemWendyMessageSkillExtra message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                Minecraft mc = Minecraft.getMinecraft();

                mc.addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        EntityPlayer player = (EntityPlayer) mc.world.getEntityByID(message.id);
                        player.motionY = 1.2;
                    }
                });
            }
            return null;
        }
    }
}
