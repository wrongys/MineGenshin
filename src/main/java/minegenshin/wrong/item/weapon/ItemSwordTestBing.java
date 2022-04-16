package minegenshin.wrong.item.weapon;

import minegenshin.wrong.elemental.attack.Elemental;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import static minegenshin.wrong.MineGenshin.MOD_ID;
import static minegenshin.wrong.elemental.ElementalDamageType.Elemental_CRYO;

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



        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
