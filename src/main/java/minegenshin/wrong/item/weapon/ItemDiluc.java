package minegenshin.wrong.item.weapon;

import minegenshin.wrong.EnumSAB;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import minegenshin.wrong.network.SimpleNetworkWrapperLoader;
import minegenshin.wrong.network.message.MessageSABClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.List;

import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;
import static minegenshin.wrong.init.ParticleInit.ParticleMGSweepPyro;

public class ItemDiluc extends ItemMineGenshinWeapon {

    public ItemDiluc() {
        this.setMaxStackSize(1);
        this.setCreativeTab(wrongCreativeTab);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        if (worldIn.isRemote) {
            RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
            Render<AbstractClientPlayer> render = renderManager.getEntityRenderObject(playerIn);
            RenderPlayer renderPlayer = (RenderPlayer) render;

            renderPlayer.getMainModel().bipedLeftLeg.rotateAngleX = 45 * 0.017453292F;
            renderPlayer.getMainModel().bipedBody.rotateAngleX = 30 * 0.017453292F;
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    @Override
    public void skill(EntityPlayer player, ItemStack stack) {

        SimpleNetworkWrapperLoader.INSTANCE.sendToAllAround(new MessageSABClient(player.getEntityId(), player.getName(), EnumSAB.SKILL), new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 128));

    }


    @Override
    public void burst(EntityPlayer player, ItemStack stack) {

        AxisAlignedBB aabb = new AxisAlignedBB(player.posX + 3, player.posY + 2, player.posZ + 3,
                player.posX + 3, player.posY + 2, player.posZ + 3);
        List<Entity> entityList = player.world.getEntitiesWithinAABB(Entity.class, aabb);

        for (Entity entity : entityList
        ) {
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityDilucBurst) && !(entity instanceof EntityPlayer)) {
                EntityLivingBase entityLiving = (EntityLivingBase) entity;
                entityLiving.attackEntityFrom(BURST, 10);
            }

        }


        EntityDilucBurst entity = new EntityDilucBurst(player.world, player.posX, player.posY + player.eyeHeight, player.posZ);
        entity.shoot(player, 0, player.rotationYaw, 0, 0.75F, 0);
        player.world.spawnEntity(entity);
    }


    @Override
    public void skillClient(EntityPlayer player, ItemStack stack) {
        float dx = -MathHelper.sin(player.rotationYaw * 0.017453292F);
        float dz = MathHelper.cos(player.rotationYaw * 0.017453292F);
        float x = (float) (player.posX + 3 * dx);
        float y = (float) (player.posY + 1);
        float z = (float) (player.posZ + 3 * dz);
        player.world.spawnParticle(ParticleMGSweepPyro, x, y, z, 0, 0, 0);
    }


    @Override
    public void burstClient(EntityPlayer player, ItemStack stack) {

        super.burstClient(player, stack);
    }


}
