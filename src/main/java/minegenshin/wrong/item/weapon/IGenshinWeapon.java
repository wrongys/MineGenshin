package minegenshin.wrong.item.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IGenshinWeapon {

    public  void burst(EntityPlayer entityPlayer, ItemStack stack);

    public  void skill(EntityPlayer entityPlayer, ItemStack stack);

    public  void setNBTTagCompound(ItemStack itemStack, String key, Boolean value);

    public boolean hasNBTTagCompoundValue(ItemStack itemStack, String key);


}
