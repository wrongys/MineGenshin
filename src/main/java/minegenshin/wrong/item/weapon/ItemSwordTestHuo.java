package minegenshin.wrong.item.weapon;

import minegenshin.wrong.elemental.attack.Elemental;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle2;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static minegenshin.wrong.MineGenshin.MOD_ID;
import static minegenshin.wrong.elemental.ElementalDamageType.Elemental_PYRO;


public class ItemSwordTestHuo extends ItemSword {


    public ItemSwordTestHuo(ToolMaterial material) {
        super(material);
        this.setRegistryName("huo");
        this.setUnlocalizedName(MOD_ID + "Huo");
        this.setCreativeTab(null);


    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {


        return super.hitEntity(stack, target, attacker);
    }




}
