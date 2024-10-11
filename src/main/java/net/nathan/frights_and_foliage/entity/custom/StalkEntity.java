package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.util.ModEventHandler;
import org.jetbrains.annotations.Nullable;

public class StalkEntity extends HostileEntity {

    private boolean isAlerted = false;
    private boolean isHostile = false;
    private int followPlayerTicks = 0;
    private long lastWarningTime = 0; // To store the last time the warning scream was played
    private static final long WARNING_COOLDOWN_TICKS = 100; // Cooldown duration in ticks (5 seconds, as 20 ticks = 1 second)

    public StalkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.5));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();

        PlayerEntity closestPlayer = this.getWorld().getClosestPlayer(this, 30);

        if (closestPlayer != null) {
            double distanceToPlayer = this.squaredDistanceTo(closestPlayer);
            long currentTime = this.getWorld().getTime();

            if (closestPlayer.isCreative() || closestPlayer.isDead()) {
                this.resetHostility();
                return;
            }

            if (distanceToPlayer >= 25 && distanceToPlayer <= 900) {
                if (ModEventHandler.recentBlockBreaks.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentBlockBreaks.get(closestPlayer) < 2) {
                    if (canPlayWarningScream(currentTime)) {
                        this.playAlertSound();
                        this.isAlerted = true;
                        this.followPlayerTicks = 200;
                    }
                } else if (ModEventHandler.recentMobDamage.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentMobDamage.get(closestPlayer) < 2) {
                    if (canPlayWarningScream(currentTime)) {
                        this.playAlertSound();
                        this.isAlerted = true;
                        this.followPlayerTicks = 200;
                    }
                }

                if (this.isAlerted && this.followPlayerTicks > 0) {
                    if (this.squaredDistanceTo(closestPlayer) < 6.25) {
                        this.getNavigation().stop();
                    } else {
                        this.getNavigation().startMovingTo(closestPlayer, 1.0);
                    }
                    this.followPlayerTicks--;
                } else {
                    this.isAlerted = false;
                }
            }

            if (distanceToPlayer < 25 && closestPlayer.canSee(this)) {
                if (ModEventHandler.recentBlockBreaks.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentBlockBreaks.get(closestPlayer) < 2) {
                    this.playHostileSound();
                    this.isHostile = true;
                    this.isAlerted = false;
                    this.getNavigation().stop();
                    this.setTarget(closestPlayer);
                } else if (ModEventHandler.recentMobDamage.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentMobDamage.get(closestPlayer) < 2) {
                    this.playHostileSound();
                    this.isHostile = true;
                    this.isAlerted = false;
                    this.getNavigation().stop();
                    this.setTarget(closestPlayer);
                }
            }

            if (distanceToPlayer > 900) {
                this.resetHostility();
            }
        } else {
            this.resetHostility();
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity && !isHostile) {
            PlayerEntity attacker = (PlayerEntity) source.getAttacker();
            if (!attacker.isCreative()) {
                this.playHostileSound();
                this.isHostile = true;
                this.setTarget(attacker);
            }
        }
        return super.damage(source, amount);
    }

    @Override
    public void onDeath(DamageSource source) {
        this.resetHostility();
        super.onDeath(source);
    }

    private void resetHostility() {
        this.isHostile = false;
        this.isAlerted = false;
        this.followPlayerTicks = 0;
        this.setTarget(null);
    }

    public static DefaultAttributeContainer.Builder createStalkAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20);
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

    protected SoundEvent getAlertSound() {
        return SoundEvents.ENTITY_GHAST_WARN;
    }

    protected SoundEvent getHostileSound() {
        return SoundEvents.ENTITY_PHANTOM_BITE;
    }

    public void playAlertSound() {
        this.playSound(this.getAlertSound(), 2.0F, 1.0F);
        this.lastWarningTime = this.getWorld().getTime(); // Update last warning time
    }

    public void playHostileSound() {
        this.playSound(this.getHostileSound(), 1.0F, 1.0F);
    }

    private boolean canPlayWarningScream(long currentTime) {
        return currentTime - lastWarningTime >= WARNING_COOLDOWN_TICKS;
    }
}
