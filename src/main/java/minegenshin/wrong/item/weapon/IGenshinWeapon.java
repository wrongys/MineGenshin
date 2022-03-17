package minegenshin.wrong.item.weapon;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IGenshinWeapon {

    public  void skill(EntityPlayer player, ItemStack stack);

    public  void burst(EntityPlayer player, ItemStack stack);


    public void skillClient(EntityPlayer player, ItemStack stack);

    public void burstClient(EntityPlayer player, ItemStack stack);

}
