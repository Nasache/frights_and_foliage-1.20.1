package net.nathan.frights_and_foliage.util;


import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {

    // Maps to store recent actions
    public static final Map<PlayerEntity, Long> recentBlockBreaks = new HashMap<>();
    public static final Map<PlayerEntity, Long> recentMobDamage = new HashMap<>();

    // Event registration method
    public static void registerEvents() {
        // Listen for block breaks
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
            if (!player.isCreative() && world instanceof ServerWorld) {
                recentBlockBreaks.put(player, world.getTime()); // Store the player and the time they broke a block
                FrightsAndFoliage.LOGGER.info("Player " + player.getName().getString() + " broke a block at " + pos);
            }
        });

        // Listen for mob damage
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, damageSource) -> {
            if (damageSource.getAttacker() instanceof PlayerEntity && world instanceof ServerWorld) {
                PlayerEntity player = (PlayerEntity) damageSource.getAttacker();
                if (!player.isCreative()) {
                    recentMobDamage.put(player, world.getTime()); // Store the player and the time they damaged a mob
                    FrightsAndFoliage.LOGGER.info("Player " + player.getName().getString() + " attacked a mob.");
                }
            }
        });
    }

    // Clean-up method (optional) to remove old entries after a certain time
    public static void cleanUpOldEntries(long currentTime, long expirationTime) {
        recentBlockBreaks.entrySet().removeIf(entry -> currentTime - entry.getValue() > expirationTime);
        recentMobDamage.entrySet().removeIf(entry -> currentTime - entry.getValue() > expirationTime);
    }
}

