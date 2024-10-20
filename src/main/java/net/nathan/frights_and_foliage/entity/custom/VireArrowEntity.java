package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.item.ModItems;

public class VireArrowEntity extends PersistentProjectileEntity {
    private boolean velocityIncreased = false;

    public VireArrowEntity(EntityType<? extends VireArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public VireArrowEntity(World world, LivingEntity owner) {
        super(ModEntities.VIRE_FEATHER_ARROW, owner, world);
    }

    public VireArrowEntity(World world, double x, double y, double z) {
        super(ModEntities.VIRE_FEATHER_ARROW, x, y, z, world);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.velocityIncreased && !this.inGround) {
            this.setVelocity(this.getVelocity().multiply(2.0));
            this.velocityIncreased = true;
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.VIRE_FEATHER_ARROW);
    }
}
