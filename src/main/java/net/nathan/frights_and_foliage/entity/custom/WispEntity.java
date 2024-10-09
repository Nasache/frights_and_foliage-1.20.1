package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.nathan.frights_and_foliage.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class WispEntity extends PassiveEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public WispEntity(EntityType<? extends WispEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 10, true);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new WispWanderGoal());
        this.goalSelector.add(1, new SwimGoal(this));
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    }

    public boolean hurtByWater() {
        return true;
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
    }

    public void tickMovement() {
        if (this.getWorld().isClient) {
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.SMOKE, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5), 0.0, 0.0, 0.0);
            }
        }

        super.tickMovement();
    }

    // New interact method to handle right-clicking with an empty bottle
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        // Check if the player is holding an empty bottle
        if (itemStack.isOf(Items.GLASS_BOTTLE)) {
            if (!this.getWorld().isClient()) {
                // Replace the empty bottle with the Bottle o' Wisp
                ItemStack bottleOWisp = new ItemStack(ModItems.BOTTLE_O_WISP);
                player.setStackInHand(hand, bottleOWisp);

                // Play a sound when the Wisp is captured
                this.playSound(SoundEvents.ITEM_BOTTLE_FILL, 1.0F, 1.0F);

                // Remove the Wisp entity
                this.discard();

                return ActionResult.SUCCESS;
            } else {
                return ActionResult.CONSUME;  // Ensure it does the action on both client and server
            }
        }

        return super.interactMob(player, hand);
    }

    public static DefaultAttributeContainer.Builder createWispAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    class WispWanderGoal extends Goal {

        WispWanderGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return WispEntity.this.navigation.isIdle() && WispEntity.this.random.nextInt(10) == 0;
        }

        @Override
        public boolean shouldContinue() {
            return WispEntity.this.navigation.isFollowingPath();
        }

        @Override
        public void start() {
            Vec3d target = this.getRandomLocation();
            if (target != null) {
                WispEntity.this.navigation.startMovingAlong(
                        WispEntity.this.navigation.findPathTo(BlockPos.ofFloored(target), 1), 1.0
                );
            }
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d direction = WispEntity.this.getRotationVec(0.0F);
            return AboveGroundTargeting.find(WispEntity.this, 8, 7, direction.x, direction.z, 1.5707964F, 3, 1);
        }
    }
}
