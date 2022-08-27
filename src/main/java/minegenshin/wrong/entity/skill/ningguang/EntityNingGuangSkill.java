package minegenshin.wrong.entity.skill.ningguang;

import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;


public class EntityNingGuangSkill extends EntityLiving {
    public EntityNingGuangSkill(World worldIn) {
        super(worldIn);
        this.setSize(0.5F,0.5F);
    }



    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.ticksExisted >= 10 * 20) {
            this.setDead();
        }

    }

}
