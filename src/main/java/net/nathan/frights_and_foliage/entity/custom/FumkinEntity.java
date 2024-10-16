package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class FumkinEntity extends AnimalEntity {
    private static final TrackedData<Boolean> ANTLERS_INTACT;
    private int eatGrassTimer;
    private EatGrassGoal eatGrassGoal;

    public FumkinEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.WHEAT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, this.eatGrassGoal);
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANTLERS_INTACT, true);
    }

    public static DefaultAttributeContainer.Builder createFumkinAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    public void tickMovement() {
        if (this.getWorld().isClient) {
            this.eatGrassTimer = Math.max(0, this.eatGrassTimer - 1);
        }
        super.tickMovement();
    }

    public boolean hasAntlers() {
        return this.dataTracker.get(ANTLERS_INTACT);
    }

    public void setAntlers(boolean intact) {
        this.dataTracker.set(ANTLERS_INTACT, intact);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.IRON_AXE)) {
            if (this.hasAntlers() && !this.getWorld().isClient) {
                this.dropAntlers(SoundCategory.PLAYERS);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
                return ActionResult.SUCCESS;
            }
        }
        return super.interactMob(player, hand);
    }

    private void dropAntlers(SoundCategory soundCategory) {
        //this.getWorld().playSound(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, soundCategory, 1.0F, 1.0F);
        this.setAntlers(false);
        this.dropItem(Items.BONE);
    }

    public void onEatingGrass() {
        super.onEatingGrass();
        this.setAntlers(true);
    }

    @Nullable
    @Override
    public FumkinEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    static {
        ANTLERS_INTACT = DataTracker.registerData(FumkinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
