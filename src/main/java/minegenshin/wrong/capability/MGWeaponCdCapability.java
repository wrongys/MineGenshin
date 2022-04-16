package minegenshin.wrong.capability;

import com.google.common.collect.Maps;
import minegenshin.wrong.item.weapon.IMineGenshinWeapon;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MGWeaponCdCapability implements INBTSerializable<NBTTagCompound> {

    private final Map<IMineGenshinWeapon, Integer> cooldowns_skill = Maps.<IMineGenshinWeapon, Integer>newHashMap();
    private final Map<IMineGenshinWeapon, Integer> cooldowns_burst = Maps.<IMineGenshinWeapon, Integer>newHashMap();
    private final Map<IMineGenshinWeapon, Integer> cooldowns_extra = Maps.<IMineGenshinWeapon, Integer>newHashMap();

    public int getSkillCd(IMineGenshinWeapon item) {
        return cooldowns_skill.get(item);
    }

    public int getBurstCd(IMineGenshinWeapon item) {
        return cooldowns_burst.get(item);
    }

    public int getExtraCd(IMineGenshinWeapon item) {
        return cooldowns_extra.get(item);
    }


    public void setSkillCd(IMineGenshinWeapon item, int cd) {
        cooldowns_skill.put(item, cd);
    }

    public void setBurstCd(IMineGenshinWeapon item, int cd) {
        cooldowns_burst.put(item, cd);
    }

    public void setExtraCd(IMineGenshinWeapon item, int cd) {
        cooldowns_extra.put(item, cd);
    }


    public boolean hasSkillKey(IMineGenshinWeapon item) {
        return cooldowns_skill.containsKey(item);
    }

    public boolean hasBurstKey(IMineGenshinWeapon item) {
        return cooldowns_burst.containsKey(item);
    }

    public boolean hasExtraKey(IMineGenshinWeapon item) { return cooldowns_extra.containsKey(item); }

    public void tick() {

        Iterator it_skill = cooldowns_skill.keySet().iterator();

        while (it_skill.hasNext()) {

            IMineGenshinWeapon next = (IMineGenshinWeapon) it_skill.next();
            int cd = this.getSkillCd(next);

            if (cd >= 1) {
                this.setSkillCd(next, cd - 1);
            }

            if (this.getSkillCd(next) == 0) {
                it_skill.remove();
            }

        }

        Iterator it_burst = cooldowns_burst.keySet().iterator();

        while (it_burst.hasNext()) {

            IMineGenshinWeapon next = (IMineGenshinWeapon) it_burst.next();
            int cd = this.getBurstCd(next);

            if (cd >= 1) {
                this.setBurstCd(next, cd - 1);
            }

            if (this.getBurstCd(next) == 0) {
                it_burst.remove();
            }

        }

        Iterator it_extra = cooldowns_extra.keySet().iterator();

        while (it_extra.hasNext()) {

            IMineGenshinWeapon next = (IMineGenshinWeapon) it_extra.next();
            int cd = this.getExtraCd(next);

            if (cd >= 1) {
                this.setExtraCd(next, cd - 1);
            }

            if (this.getExtraCd(next) == 0) {
                it_extra.remove();
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

        Set<IMineGenshinWeapon> sets_extra = cooldowns_extra.keySet();
        for (IMineGenshinWeapon set : sets_extra
        ) {
            nbt.setInteger(set.toString(), cooldowns_extra.get(set));
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

        Set<IMineGenshinWeapon> sets_extra = cooldowns_extra.keySet();
        for (IMineGenshinWeapon set : sets_extra
        ) {
            cooldowns_extra.put(set, nbt.getInteger(set.toString()));
        }

    }
}
