package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageSpawnParticle implements IMessage {
    float x;
    float y;
    float z;

    public MessageSpawnParticle() {
    }

    public MessageSpawnParticle(EntityLivingBase entity) {

        this.x = (float) entity.posX;
        this.y = (float) entity.posY;
        this.z = (float) entity.posZ;

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readFloat();
        this.y = buf.readFloat();
        this.z = buf.readFloat();

    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeFloat(x);
        buf.writeFloat(y);
        buf.writeFloat(z);

    }

    public static class Handler implements IMessageHandler<MessageSpawnParticle, IMessage> {
        @Override
        public IMessage onMessage(MessageSpawnParticle message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                World world = Minecraft.getMinecraft().world;
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {

                   Minecraft.getMinecraft().world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, message.x, message.y, message.z, 1.0D, 0.0D, 0.0D);

                    }
                });

            }
            return null;
        }
    }
}
