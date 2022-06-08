package minegenshin.wrong.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSweetMadame extends ItemFood {

    public final int itemUseDuration;
    public final float treatmentAmount;

    public ItemSweetMadame(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.itemUseDuration = 16;
        this.treatmentAmount = 6F;
    }


    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if (!worldIn.isRemote) {
            player.setHealth((float) (player.getHealth() + player.getHealth() * 0.2 + treatmentAmount));
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return itemUseDuration;
    }
}
