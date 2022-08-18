package minegenshin.wrong.item.food;

import minegenshin.wrong.api.IMineGenshinItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSweetMadame extends ItemFood implements IMineGenshinItem {

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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(I18n.format("minegenshin.tooltip.item.sweet_madame1"));
        tooltip.add(I18n.format("minegenshin.tooltip.item.sweet_madame2"));
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return itemUseDuration;
    }
}
