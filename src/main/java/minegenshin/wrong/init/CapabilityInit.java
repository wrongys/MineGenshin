package minegenshin.wrong.init;
import minegenshin.wrong.capability.ElementalCapability;
import minegenshin.wrong.capability.MGCapability;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityInit {

    @CapabilityInject(ElementalCapability.class)
    public static net.minecraftforge.common.capabilities.Capability<ElementalCapability> ELEMENTAL;

    @CapabilityInject(MGCapability.class)
    public static net.minecraftforge.common.capabilities.Capability<MGCapability> MGWEAPON;


    public static void init() {
        CapabilityManager.INSTANCE.register(ElementalCapability.class, new net.minecraftforge.common.capabilities.Capability.IStorage<ElementalCapability>() {
            @Override
            public NBTBase writeNBT(net.minecraftforge.common.capabilities.Capability<ElementalCapability> cap, ElementalCapability instance, EnumFacing side) {

                return instance.serializeNBT();

            }

            @Override
            public void readNBT(net.minecraftforge.common.capabilities.Capability<ElementalCapability> cap, ElementalCapability instance, EnumFacing side, NBTBase nbt) {
                if (nbt instanceof NBTTagCompound) {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }
            }
        }, ElementalCapability::new);


        CapabilityManager.INSTANCE.register(MGCapability.class, new net.minecraftforge.common.capabilities.Capability.IStorage<MGCapability>() {
            @Override
            public NBTBase writeNBT(net.minecraftforge.common.capabilities.Capability<MGCapability> cap, MGCapability instance, EnumFacing side) {

                return instance.serializeNBT();

            }

            @Override
            public void readNBT(net.minecraftforge.common.capabilities.Capability<MGCapability> cap, MGCapability instance, EnumFacing side, NBTBase nbt) {
                if (nbt instanceof NBTTagCompound) {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }
            }
        }, MGCapability::new);
    }
}
