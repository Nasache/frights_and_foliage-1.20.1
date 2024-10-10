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
    private int chaseCooldown;

    public StalkChasePlayerGoal(StalkEntity stalk) {
        this.stalk = stalk;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        // Check if there is a player nearby who recently broke a block or damaged a mob
        List<PlayerEntity> players = stalk.getWorld().getEntitiesByClass(PlayerEntity.class, stalk.getBoundingBox().expand(20.0D),
                player -> player.isAlive() && !player.isCreative() && (didPlayerBreakBlock(player) || didPlayerDamageMob(player) || playerAttackedStalk(player)));

        if (!players.isEmpty()) {
            this.targetPlayer = players.get(0);
            return true;
        }
        return false;
    }

    @Override
    public void start() {
        this.chaseCooldown = 0;
        this.stalk.setTarget(this.targetPlayer);
        this.stalk.chooseRandomAngerTime();
        this.stalk.playAlertSound();
    }

    @Override
    public void tick() {
        if (this.targetPlayer != null && stalk.squaredDistanceTo(this.targetPlayer) < 4.0D) {
            // Cooldown to chase after waiting period
            if (chaseCooldown <= 0) {
                this.stalk.getNavigation().startMovingTo(this.targetPlayer, 1.5D);
                chaseCooldown = 100; // Wait for 5 seconds before chasing
            }
            chaseCooldown--;
        }
    }

    private boolean didPlayerBreakBlock(PlayerEntity player) {
        if (stalk.getWorld() instanceof ServerWorld) {
            Long lastBreak = recentBlockBreaks.get(player);
            return lastBreak != null && stalk.getWorld().getTime() - lastBreak < 100L;
        }
        return false;
    }

    private boolean didPlayerDamageMob(PlayerEntity player) {
        if (stalk.getWorld() instanceof ServerWorld) {
            Long lastDamage = recentMobDamage.get(player);
            return lastDamage != null && stalk.getWorld().getTime() - lastDamage < 100L;
        }
        return false;
    }

    private boolean playerAttackedStalk(PlayerEntity player) {
        // Check if player directly attacked the Stalk
        return stalk.getAttacker() == player;
    }
}
