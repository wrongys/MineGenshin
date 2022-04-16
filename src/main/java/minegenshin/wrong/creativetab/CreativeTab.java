package minegenshin.wrong.creativetab;

import minegenshin.wrong.registery.ItemRegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

    public static final CreativeTab wrongCreativeTab = new CreativeTab();

    public CreativeTab() {
        super("minegenshin");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistryHandler.ELEGY_FOR_THE_END);
    }


    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public int getSearchbarWidth() {
        return 45;
    }

    @Override
    public String getBackgroundImageName() {
        return super.getBackgroundImageName();
    }
}

