package minegenshin.wrong.item.weapon;

import minegenshin.wrong.api.IMineGenshinWeapon;
import minegenshin.wrong.entity.skill.ningguang.EntityNingGuangSkill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;

public class ItemNingGuang extends Item implements IMineGenshinWeapon {

    public ItemNingGuang() {
        this.setMaxStackSize(1);
        this.setCreativeTab(wrongCreativeTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

//
//        if (!worldIn.isRemote) {
//            double x = playerIn.posX;
//            double y = playerIn.posY + 1;
//            double z = playerIn.posZ;
//            EntityNingGuangA entity1 = new EntityNingGuangA(worldIn, x - Math.sin((playerIn.rotationYaw - 90) * 0.017453292F), y, z + Math.cos((playerIn.rotationYaw - 90) * 0.017453292F), playerIn);
//            EntityNingGuangA entity2 = new EntityNingGuangA(worldIn, x - Math.sin((playerIn.rotationYaw + 90) * 0.017453292F), y, z + Math.cos((playerIn.rotationYaw + 90) * 0.017453292F), playerIn);
//            entity1.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, 1.5F, 0);
//            entity2.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, 1.5F, 0);
//            worldIn.spawnEntity(entity1);
//            worldIn.spawnEntity(entity2);
//        }

        if (!worldIn.isRemote) {
            EntityNingGuangSkill entity = new EntityNingGuangSkill(worldIn);
            entity.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
            worldIn.spawnEntity(entity);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void skill(EntityPlayer player, ItemStack stack) {

    }

    @Override
    public void burst(EntityPlayer player, ItemStack stack) {

    }

    @Override
    public void skillClient(EntityPlayer player) {

    }

    @Override
    public void burstClient(EntityPlayer player) {

    }
}
