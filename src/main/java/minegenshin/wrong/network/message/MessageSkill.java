package minegenshin.wrong.network.message;

import io.netty.buffer.ByteBuf;
import minegenshin.wrong.capability.MGWeaponCdCapability;
import minegenshin.wrong.init.CapabilityInit;
import minegenshin.wrong.item.weapon.ItemMineGenshinWeapon;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageSkill implements IMessage {


    int id;
    String userName;
    public MessageSkill() {

    }

    public MessageSkill(int id, String userName) {
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

    public static class Handler implements IMessageHandler<MessageSkill, IMessage> {
        @Override
        public IMessage onMessage(MessageSkill message, MessageContext ctx) {
            if (ctx.side == Side.SERVER) {
                MinecraftServer mc = FMLCommonHandler.instance().getMinecraftServerInstance();

                mc.addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        EntityPlayerMP player = ctx.getServerHandler().player;
                        ItemStack stack = player.getHeldItemMainhand();
                        if (stack != null && stack.getItem() instanceof ItemMineGenshinWeapon) {
                            ItemMineGenshinWeapon item = (ItemMineGenshinWeapon) stack.getItem();
                            MGWeaponCdCapability capability = player.getCapability(CapabilityInit.MGWEAPON, null);
                            item.skill(player, stack);
                        }
                    }
                });
            }
            return null;
        }
    }


}

