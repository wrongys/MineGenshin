package minegenshin.wrong.item.weapon;

import minegenshin.wrong.elemental.attack.Elemental;
import minegenshin.wrong.entity.skill.wendy.EntityWendyAttack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static minegenshin.wrong.MineGenshin.MOD_ID;
import static minegenshin.wrong.creativetab.CreativeTab.wrongCreativeTab;
import static minegenshin.wrong.elemental.ElementalDamageType.Elemental_PYRO;


public class ItemSwordTestHuo extends ItemSword {


    public ItemSwordTestHuo(ToolMaterial material) {
        super(material);
        this.setRegistryName("huo");
        this.setUnlocalizedName(MOD_ID + "Huo");

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


        if (!worldIn.isRemote) {
            EntityWendyAttack wendyAttack = new EntityWendyAttack(worldIn,playerIn);
            wendyAttack.shoot(playerIn,playerIn.rotationPitch,playerIn.rotationYaw,0,0.5F,0);
            worldIn.spawnEntity(wendyAttack);
//            worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, playerIn.posX + 3, playerIn.posY, playerIn.posZ, 0, 0, 0);
        }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {


        Elemental.elementalAttack(attacker, target, Elemental_PYRO);


        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

//        CapabilityItemCd capability = stack.getCapability(CapabilityRegistryHandler.ITEM_CD, null);
//
//        if (capability.getCd() > 0) {
//
//            capability.setCd(capability.getCd() - 1);
//
//        }

        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }


}
