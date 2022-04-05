package minegenshin.wrong.capability;

import com.google.common.collect.Maps;
import minegenshin.wrong.item.weapon.IMineGenshinWeapon;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Map;
import java.util.Set;

public class MGWeaponCdCapability implements INBTSerializable<NBTTagCompound> {

    private final Map<IMineGenshinWeapon, Integer> cooldowns_skill = Maps.<IMineGenshinWeapon, Integer>newHashMap();
    private final Map<IMineGenshinWeapon, Integer> cooldowns_burst = Maps.<IMineGenshinWeapon, Integer>newHashMap();

    public int getSkillCd(IMineGenshinWeapon item) {
        return cooldowns_skill.get(item);
    }

    public int getBurstCd(IMineGenshinWeapon item) {
        return cooldowns_burst.get(item);
    }

    public void setSkillCd(IMineGenshinWeapon item, int cd) {
        cooldowns_skill.put(item, cd);
    }

    public void setBurstCd(IMineGenshinWeapon item, int cd) {
        cooldowns_burst.put(item, cd);
    }

    public void removeSkillCd(IMineGenshinWeapon item) {
        cooldowns_skill.remove(item);
    }

    public void removeBurstCd(IMineGenshinWeapon item) {
        cooldowns_burst.remove(item);
    }

    public boolean hasSkillKey(IMineGenshinWeapon item) {
        return cooldowns_skill.containsKey(item);
    }

    public boolean hasBurstKey(IMineGenshinWeapon item) {
        return cooldowns_burst.containsKey(item);
    }

    public void tick() {
        Set<IMineGenshinWeapon> sets_skill = cooldowns_skill.keySet();
        if (!sets_skill.isEmpty()) {
            for (IMineGenshinWeapon item : sets_skill
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


        Set<IMineGenshinWeapon> sets_burst = cooldowns_burst.keySet();

        if (!sets_burst.isEmpty()) {
            for (IMineGenshinWeapon item : sets_burst
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
        Set<IMineGenshinWeapon> sets_skill = cooldowns_skill.keySet();
        for (IMineGenshinWeapon set : sets_skill
        ) {
            nbt.setInteger(set.toString(), cooldowns_skill.get(set));
        }

        Set<IMineGenshinWeapon> sets_burst = cooldowns_burst.keySet();
        for (IMineGenshinWeapon set : sets_burst
        ) {
            nbt.setInteger(set.toString(), cooldowns_burst.get(set));
        }


        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        Set<IMineGenshinWeapon> sets_skill = cooldowns_skill.keySet();
        for (IMineGenshinWeapon set : sets_skill
        ) {
            cooldowns_skill.put(set, nbt.getInteger(set.toString()));
        }

        Set<IMineGenshinWeapon> sets_burst = cooldowns_burst.keySet();
        for (IMineGenshinWeapon set : sets_burst
        ) {
            cooldowns_burst.put(set, nbt.getInteger(set.toString()));
        }
    }
}
