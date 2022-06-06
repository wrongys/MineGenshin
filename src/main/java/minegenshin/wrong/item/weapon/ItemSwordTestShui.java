package minegenshin.wrong.item.weapon;

import minegenshin.wrong.init.ParticleInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static minegenshin.wrong.MineGenshin.MOD_ID;

public class ItemSwordTestShui extends ItemSword {


    public ItemSwordTestShui(ToolMaterial material) {
        super(material);
        this.setRegistryName("shui");
        this.setUnlocalizedName(MOD_ID + "Shui");
        this.setCreativeTab(null);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        if (worldIn.isRemote) {
            worldIn.spawnParticle(ParticleInit.XIAO_BURST, playerIn.posX + 2, playerIn.posY, playerIn.posZ + 2, 0, 0, 0);
        }

        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));

    }
}
