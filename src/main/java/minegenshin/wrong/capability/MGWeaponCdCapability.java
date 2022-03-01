package minegenshin.wrong.capability;

import com.google.common.collect.Maps;
import minegenshin.wrong.item.weapon.ItemMineGenshinWeapon;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Map;
import java.util.Set;

public class MGWeaponCdCapability implements INBTSerializable<NBTTagCompound> {

    private final Map<ItemMineGenshinWeapon, Integer> cooldowns_skill = Maps.<ItemMineGenshinWeapon, Integer>newHashMap();
    private final Map<ItemMineGenshinWeapon, Integer> cooldowns_burst = Maps.<ItemMineGenshinWeapon, Integer>newHashMap();

    public int getSkillCd(ItemMineGenshinWeapon item) {
        return cooldowns_skill.get(item);
    }

    public int getBurstCd(ItemMineGenshinWeapon item) {
        return cooldowns_burst.get(item);
    }

    public void setSkillCd(ItemMineGenshinWeapon item, int cd) {
        cooldowns_skill.put(item, cd);
    }

    public void setBurstCd(ItemMineGenshinWeapon item, int cd) {
        cooldowns_burst.put(item, cd);
    }

    public void removeSkillCd(ItemMineGenshinWeapon item) {
        cooldowns_skill.remove(item);
    }

    public void removeBurstCd(ItemMineGenshinWeapon item) {
        cooldowns_burst.remove(item);
    }

    public boolean hasSkillKey(ItemMineGenshinWeapon item) {
        return cooldowns_skill.containsKey(item);
    }

    public boolean hasBurstKey(ItemMineGenshinWeapon item) {
        return cooldowns_burst.containsKey(item);
    }

    public void tick() {
        Set<ItemMineGenshinWeapon> sets_skill = cooldowns_skill.keySet();
        if (!sets_skill.isEmpty()) {
            for (ItemMineGenshinWeapon item : sets_skill
            ) {
                int cd = this.getSkillCd(item);

                if (cd >= 1) {
                    this.setSkillCd(item, cd - 1);
                }

                if (this.getSkillCd(item) == 0) {
                    this.removeSkillCd(item);
                }
            }

        }


        Set<ItemMineGenshinWeapon> sets_burst = cooldowns_burst.keySet();

        if (!sets_burst.isEmpty()) {
            for (ItemMineGenshinWeapon item : sets_burst
            ) {
                int cd = this.getBurstCd(item);

                if (cd >= 1) {
                    this.setBurstCd(item, cd - 1);
                }

                if (this.getBurstCd(item) == 0) {
                    this.removeBurstCd(item);
                }
            }

        }

    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        Set<ItemMineGenshinWeapon> sets_skill = cooldowns_skill.keySet();
        for (ItemMineGenshinWeapon set : sets_skill
        ) {
            nbt.setInteger(set.toString(), cooldowns_skill.get(set));
        }

        Set<ItemMineGenshinWeapon> sets_burst = cooldowns_burst.keySet();
        for (ItemMineGenshinWeapon set : sets_burst
        ) {
            nbt.setInteger(set.toString(), cooldowns_burst.get(set));
        }


        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        Set<ItemMineGenshinWeapon> sets_skill = cooldowns_skill.keySet();
        for (ItemMineGenshinWeapon set : sets_skill
        ) {
            cooldowns_skill.put(set, nbt.getInteger(set.toString()));
        }

        Set<ItemMineGenshinWeapon> sets_burst = cooldowns_burst.keySet();
        for (ItemMineGenshinWeapon set : sets_burst
        ) {
            cooldowns_burst.put(set, nbt.getInteger(set.toString()));
        }
    }
}
