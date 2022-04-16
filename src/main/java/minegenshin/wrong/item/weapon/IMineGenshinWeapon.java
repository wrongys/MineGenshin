package minegenshin.wrong.item.weapon;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public interface IMineGenshinWeapon {

    public static final DamageSource SKILL = new DamageSource("skill");
    public static final DamageSource BURST = new DamageSource("burst");

    public  void skill(EntityPlayer player, ItemStack stack);

    public  void burst(EntityPlayer player, ItemStack stack);


    public void skillClient(EntityPlayer player);

    public void burstClient(EntityPlayer player);

}
