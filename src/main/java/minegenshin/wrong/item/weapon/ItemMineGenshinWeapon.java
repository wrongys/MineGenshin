package minegenshin.wrong.item.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMineGenshinWeapon extends Item implements IGenshinWeapon {

    @Override
    public void burst(EntityPlayer entityPlayer, ItemStack itemStack) {

    }

    @Override
    public void skill(EntityPlayer entityPlayer, ItemStack stack) {

    }

    @Override
    public void setNBTTagCompound(ItemStack itemStack, String key, Boolean value) {

    }

    @Override
    public boolean hasNBTTagCompoundValue(ItemStack itemStack, String key) {
        return false;
    }
}


