package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class StalkEntity extends HostileEntity implements Angerable {

    public static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(StalkEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private int angerTime; // Time to track how long the Stalk is angry
    private UUID angryAtUUID; // Track the player's UUID
    private boolean isStaring; // To track if the mob is in the warning/staring phase
    private boolean isAttacking; // To track if the mob is already attacking

    public StalkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.isStaring = false;
        this.isAttacking = false;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StalkChasePlayerGoal(this)); // Custom behavior for anger
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        // Handle anger time countdown
        if (this.angerTime > 0) {
            this.angerTime--;
        } else if (this.angryAtUUID != null && !isAttacking) {
            // Reset if not attacking
            this.resetAnger();
        }
    }

    public static DefaultAttributeContainer.Builder createStalkAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.BLOCK_WOOD_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.10F, 2.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_BAMBOO_WOOD_BREAK;
    }

    // Custom sounds for the Stalk's alert and hostile states
    protected SoundEvent getAlertSound() {
        return SoundEvents.ENTITY_GHAST_WARN; // Use a spooky sound for alert
    }

    protected SoundEvent getHostileSound() {
        return SoundEvents.ENTITY_PHANTOM_BITE; // Use a more aggressive sound when hostile
    }

    public void playAlertSound() {
        this.playSound(this.getAlertSound(), 1.0F, 1.0F);
    }

    public void playHostileSound() {
        this.playSound(this.getHostileSound(), 1.0F, 1.0F);
    }

    // Anger behavior: Set and get methods for the anger time and tracking the player

    @Override
    public void setAngerTime(int ticks) {
        this.angerTime = ticks;
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAtUUID = angryAt;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAtUUID;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(600); // Set anger time to 600 ticks (30 seconds)
    }

    public void resetAnger() {
        this.angerTime = 0;
        this.angryAtUUID = null;
        this.isStaring = false;
        this.isAttacking = false;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        }

        // If the Stalk is already attacking, don't enter the warning phase again
        if (isAttacking) {
            return super.damage(source, amount);
        }

        // Automatically attack if the player attacks the Stalk directly
        if (source.getAttacker() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source.getAttacker();
            this.setAngryAt(player.getUuid()); // Store the player's UUID
            this.setAngerTime(600); // Stay angry for 600 ticks (30 seconds)
            this.isAttacking = true; // Start attacking
            this.playHostileSound(); // Play the hostile sound when angry
            this.setTarget(player); // Immediately set the player as target
        }

        return super.damage(source, amount);
    }

    public void startWarningPhase(PlayerEntity player) {
        if (!isAttacking) {
            this.setAngryAt(player.getUuid()); // Store the player's UUID
            this.setAngerTime(600); // Set anger time
            this.isStaring = true; // Enter staring phase
            this.playAlertSound(); // Play warning sound
            this.getNavigation().startMovingTo(player, 1.5D); // Move towards the player
        }
    }

    public void handleWarningCompletion(PlayerEntity player) {
        // Once the mob is staring, it will attack if the player repeats an action
        if (this.isStaring && !isAttacking) {
            // Stalk will attack if the player does something again
            this.setTarget(player);
            this.isAttacking = true; // Start attacking
            this.playHostileSound(); // Hostile sound when attacking
        }
    }
}
