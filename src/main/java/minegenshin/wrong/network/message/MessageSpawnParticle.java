package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import minegenshin.wrong.init.ParticleInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageSpawnParticle implements IMessage {

    int particleId;
    float x;
    float y;
    float z;
    float xSpeed;
    float ySpeed;
    float zSpeed;

    public MessageSpawnParticle() {
    }

    public MessageSpawnParticle(int particleId, float x, float y, float z) {

        this.particleId = particleId;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public MessageSpawnParticle speed(float xSpeed, float ySpeed, float zSpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;
        return this;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.particleId = buf.readInt();
        this.x = buf.readFloat();
        this.y = buf.readFloat();
        this.z = buf.readFloat();
        this.xSpeed = buf.readFloat();
        this.ySpeed = buf.readFloat();
        this.zSpeed = buf.readFloat();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(particleId);
        buf.writeFloat(x);
        buf.writeFloat(y);
        buf.writeFloat(z);
        buf.writeFloat(xSpeed);
        buf.writeFloat(ySpeed);
        buf.writeFloat(zSpeed);

    }

    public static class Handler implements IMessageHandler<MessageSpawnParticle, IMessage> {
        @Override
        public IMessage onMessage(MessageSpawnParticle message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        Minecraft.getMinecraft().world.spawnParticle(ParticleInit.getMGParticle(message.particleId), message.x, message.y, message.z, message.xSpeed, message.ySpeed, message.zSpeed);
                    }
                });
            }
            return null;
        }
    }
}
