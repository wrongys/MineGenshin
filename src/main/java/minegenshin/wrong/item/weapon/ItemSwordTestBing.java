package minegenshin.wrong.item.weapon;

import minegenshin.wrong.elemental.attack.Elemental;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import static minegenshin.wrong.MineGenshin.MOD_ID;
import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;
import static minegenshin.wrong.elemental.ElementalDamageType.Elemental_CRYO;

public class ItemSwordTestBing extends ItemSword {
    public ItemSwordTestBing(ToolMaterial material) {
        super(material);
        this.setRegistryName("bing");
        this.setUnlocalizedName(MOD_ID + "Bing");

        this.addPropertyOverride(new ResourceLocation("test"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return 0.4F;
            }
        });
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (!target.world.isRemote) {

            Elemental.elementalAttack(attacker, target, Elemental_CRYO);

        }

        return super.hitEntity(stack, target, attacker);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


        if (worldIn.isRemote) {

            worldIn.spawnParticle(EnumParticleTypes.CRIT_MAGIC, true,
                    playerIn.posX, playerIn.posY + 2, playerIn.posZ, 0, 5, 0);
        }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
