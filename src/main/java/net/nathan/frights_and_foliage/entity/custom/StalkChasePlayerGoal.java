package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.EnumSet;
import java.util.List;

import static net.nathan.frights_and_foliage.util.ModEventHandler.recentBlockBreaks;
import static net.nathan.frights_and_foliage.util.ModEventHandler.recentMobDamage;

public class StalkChasePlayerGoal extends Goal {
    private final StalkEntity stalk;
    private PlayerEntity targetPlayer;
    private int stareCooldown;
    private final int STARE_DURATION = 100; // Time to stare before rechecking player's action

    public StalkChasePlayerGoal(StalkEntity stalk) {
        this.stalk = stalk;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        // Only consider actions that happen after the mob was spawned
        List<PlayerEntity> players = stalk.getWorld().getEntitiesByClass(PlayerEntity.class, stalk.getBoundingBox().expand(20.0D),
                player -> player.isAlive() && !player.isCreative() && (didPlayerBreakBlock(player) || didPlayerDamageMob(player)));

        if (!players.isEmpty()) {
            this.targetPlayer = players.get(0); // Set the closest player
            return true;
        }
        return false;
    }

    @Override
    public void start() {
        this.stareCooldown = STARE_DURATION; // Time to stare at the player
        stalk.startWarningPhase(targetPlayer); // Start warning phase when triggered
    }

    @Override
    public void tick() {
        if (stareCooldown > 0) {
            stareCooldown--; // Countdown for staring phase
            return;
        }

        // If the mob is staring and the player repeats the triggering action, instantly attack
        if (didPlayerBreakBlock(this.targetPlayer) || didPlayerDamageMob(this.targetPlayer)) {
            stalk.handleWarningCompletion(this.targetPlayer); // Attack if player repeats the action
        }

        // Ensure the Stalk continues moving towards the player if not yet near during the warning phase
        if (!stalk.isAttacking() && stalk.squaredDistanceTo(this.targetPlayer) >= 4.0D) {
            stalk.getNavigation().startMovingTo(this.targetPlayer, 1.5D);
        }
    }

    @Override
    public boolean shouldContinue() {
        return this.targetPlayer != null && this.targetPlayer.isAlive() && (!stalk.isAttacking() || stalk.getTarget() == targetPlayer);
    }

    private boolean didPlayerBreakBlock(PlayerEntity player) {
        if (stalk.getWorld() instanceof ServerWorld) {
            Long lastBreak = recentBlockBreaks.get(player);
            return lastBreak != null && stalk.getWorld().getTime() - lastBreak < 100L && lastBreak > stalk.age; // Ignore events before the mob existed
        }
        return false;
    }

    private boolean didPlayerDamageMob(PlayerEntity player) {
        if (stalk.getWorld() instanceof ServerWorld) {
            Long lastDamage = recentMobDamage.get(player);
            return lastDamage != null && stalk.getWorld().getTime() - lastDamage < 100L && lastDamage > stalk.age; // Ignore events before the mob existed
        }
        return false;
    }
}
