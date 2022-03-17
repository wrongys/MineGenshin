package minegenshin.wrong.item.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemMineGenshinWeapon extends Item implements IGenshinWeapon {

    public static final DamageSource SKILL = new DamageSource("skill");
    public static final DamageSource BURST = new DamageSource("burst");

    @Override
    public void skill(EntityPlayer player, ItemStack stack) {

    }

    @Override
    public void burst(EntityPlayer player, ItemStack stack) {

    }

    @Override
    public void skillClient(EntityPlayer player, ItemStack stack) {

    }

    @Override
    public void burstClient(EntityPlayer player, ItemStack stack) {

    }


}


