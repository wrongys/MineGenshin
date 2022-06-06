package minegenshin.wrong.capability;

import minegenshin.wrong.init.CapabilityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static minegenshin.wrong.MineGenshin.MOD_ID;

public class MGProvider implements ICapabilitySerializable<NBTTagCompound> {

    private final MGCapability instance;
    private final Capability<MGCapability> capability;

    public MGProvider() {
        this.instance = new MGCapability();
        this.capability = CapabilityInit.MGWEAPON;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return this.capability.equals(capability);
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return this.capability.equals(capability) ? this.capability.cast(this.instance) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return this.instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.instance.deserializeNBT(nbt);
    }

}

@Mod.EventBusSubscriber(modid = MOD_ID)
class OnAttachCapabilitiesMGWeaponCd {
    @SubscribeEvent
    public static void onAttachCapabilitiesMGWeaponCd(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            MGProvider mgweapon = new MGProvider();
            event.addCapability(new ResourceLocation(MOD_ID + ":mgweapon"), mgweapon);
        }
    }
}
