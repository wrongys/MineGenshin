package minegenshin.wrong.item.weapon;

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
//            EntityGeoTest geoTest = new EntityGeoTest(worldIn);
//            GeoExampleEntity x = new GeoExampleEntity(worldIn);
//
//            geoTest.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
//            x.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
//            worldIn.spawnEntity(geoTest);
//            worldIn.spawnEntity(x);
        }
        if (worldIn.isRemote) {


        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
