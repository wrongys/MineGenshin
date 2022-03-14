package minegenshin.wrong.item.weapon;

import minegenshin.wrong.elemental.attack.Elemental;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import static minegenshin.wrong.MineGenshin.MOD_ID;
import static minegenshin.wrong.elemental.ElementalDamageType.Elemental_ELECTRO;
import static minegenshin.wrong.init.ParticleInit.ParticleMGRedstone;
import static minegenshin.wrong.init.ParticleInit.myParticle1;

public class ItemSwordTestLei extends ItemSword {
    public ItemSwordTestLei(ToolMaterial material) {
        super(material);
        this.setRegistryName("lei");
        this.setUnlocalizedName(MOD_ID + "Lei");

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


        if (worldIn.isRemote) {

            worldIn.spawnParticle(myParticle1, playerIn.posX + 3, playerIn.posY, playerIn.posZ, 0, 0, 0);

        }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (!target.world.isRemote) {


            Elemental.elementalAttack(attacker, target, Elemental_ELECTRO);

        }

        return super.hitEntity(stack, target, attacker);
    }
}
