package minegenshin.wrong.item.weapon;

import minegenshin.wrong.elemental.attack.Elemental;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static minegenshin.wrong.MineGenshin.MOD_ID;
import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;
import static minegenshin.wrong.elemental.ElementalDamageType.Elemental_HYDRO;

public class ItemSwordTestShui extends ItemSword {


    public ItemSwordTestShui(ToolMaterial material) {
        super(material);
        this.setRegistryName("shui");
        this.setUnlocalizedName(MOD_ID + "Shui");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (!target.world.isRemote) {

            Elemental.elementalAttack(attacker, target, Elemental_HYDRO);
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));

    }
}
