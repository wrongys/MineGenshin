package minegenshin.wrong.capability;

import minegenshin.wrong.elemental.ElementalType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class ElementalCapability implements INBTSerializable<NBTTagCompound> {

    private int elementalAmount;    // 元素 量/时间
    private String elementalType;   // 元素类型
    private int elementalCd;        //元素附着cd

    public static final int ELEMENTAL_AMOUNT = 10 * 20;
    public static final int ELEMENTAL_CD = 1 * 20;

    public ElementalCapability() {

        this.elementalAmount = 0;
        this.elementalType = ElementalType.NULL;
        this.elementalCd = 0;
    }

    public int getElementalAmount() {
        return elementalAmount;
    }

    public void setElementalAmount(int elementalAmount) {
        this.elementalAmount = elementalAmount;
    }

    public String getElementalType() {
        return elementalType;
    }

    public void setElementalType(String elementalType) {
        this.elementalType = elementalType;
    }

    public int getElementalCd() {
        return elementalCd;
    }

    public void setElementalCd(int elementalCd) {
        this.elementalCd = elementalCd;
    }


    @Override
    public NBTTagCompound serializeNBT() {

        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("ElementalCd", this.elementalCd);
        nbt.setInteger("ElementalAmount", this.elementalAmount);
        nbt.setString("ElementalType", this.elementalType);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

        this.elementalCd = nbt.getInteger("ElementalCd");
        this.elementalAmount = nbt.getInteger("ElementalAmount");
        this.elementalType = nbt.getString("ElementalType");
    }


}
