package minegenshin.wrong.item.weapon;

import minegenshin.wrong.entity.EntityNingGuangA;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static minegenshin.wrong.MineGenshin.MOD_ID;

public class ItemSwordTestBing extends ItemSword {
    public ItemSwordTestBing(ToolMaterial material) {
        super(material);
        this.setRegistryName("bing");
        this.setUnlocalizedName(MOD_ID + "Bing");
        this.setCreativeTab(null);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {


        return super.hitEntity(stack, target, attacker);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


        if (!worldIn.isRemote) {
            EntityNingGuangA entity = new EntityNingGuangA(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, playerIn);
            entity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, 2, 0);
            worldIn.spawnEntity(entity);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
