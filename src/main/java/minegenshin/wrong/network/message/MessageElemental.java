package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import minegenshin.wrong.capability.ElementalCapability;
import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageElemental implements IMessage {

    int id;
    String elementalType;

    public MessageElemental() {

    }

    public MessageElemental(EntityLivingBase entity) {
        ElementalCapability capability = entity.getCapability(CapabilityInit.ELEMENTAL, null);
        this.id = entity.getEntityId();
        this.elementalType = capability.getElementalType();

    }

    @Override
    public void fromBytes(ByteBuf buf) {

        this.elementalType = ByteBufUtils.readUTF8String(buf);
        this.id = buf.readInt();

    }

    @Override
    public void toBytes(ByteBuf buf) {

        ByteBufUtils.writeUTF8String(buf, elementalType);
        buf.writeInt(id);

    }

    public static class Handler implements IMessageHandler<MessageElemental, IMessage> {
        @Override
        public IMessage onMessage(MessageElemental message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {

                        World world = Minecraft.getMinecraft().world;
                        EntityLivingBase entity = (EntityLivingBase) world.getEntityByID(message.id);
                        if (entity != null) {
                            ElementalCapability capability = entity.getCapability(CapabilityInit.ELEMENTAL, null);
                            capability.setElementalType(message.elementalType);
                        }
                    }
                });

            }

            return null;
        }
    }
}
