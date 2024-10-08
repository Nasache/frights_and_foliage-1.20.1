package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.EnumSet;

public class StalkBrain extends Goal {
    private final MobEntity mob;
    private PlayerEntity targetPlayer;
    private final double speed;
    private final World world;

    public StalkBrain(MobEntity mob) {
        this.mob = mob;
        this.speed = 1.0;
        this.world = mob.getWorld();
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        this.targetPlayer = this.world.getClosestPlayer(this.mob, 16);
        return this.targetPlayer != null && !this.targetPlayer.isCreative();
    }

    @Override
    public void tick() {
        if (this.targetPlayer == null) {
            return;
        }

        Vec3d playerPos = this.targetPlayer.getPos();
        Vec3d mobPos = this.mob.getPos();

        if (!isRayBlocked(mobPos, playerPos)) {
            Vec3d hidingSpot = findHidingSpot(playerPos);
            if (hidingSpot != null) {
                this.mob.getNavigation().startMovingTo(hidingSpot.x, hidingSpot.y, hidingSpot.z, this.speed);
            }
        } else {
            this.mob.getNavigation().stop();
        }
    }

    private boolean isRayBlocked(Vec3d mobPos, Vec3d playerPos) {
        RaycastContext context = new RaycastContext(
                mobPos,
                playerPos,
                RaycastContext.ShapeType.COLLIDER,
                RaycastContext.FluidHandling.NONE,
                this.mob
        );

        BlockHitResult hitResult = this.world.raycast(context);
        return hitResult.getType() != HitResult.Type.MISS;
    }

    private Vec3d findHidingSpot(Vec3d playerPos) {
        Vec3d mobPos = this.mob.getPos();

        Vec3d directionAwayFromPlayer = mobPos.subtract(playerPos).normalize().multiply(5);
        Vec3d targetPos = mobPos.add(directionAwayFromPlayer);

        if (isRayBlocked(targetPos, playerPos)) {
            return targetPos;
        }

        for (int i = 0; i < 10; i++) {
            Vec3d randomPos = mobPos.add(
                    this.world.random.nextInt(10) - 5,
                    0,
                    this.world.random.nextInt(10) - 5
            );

            if (isRayBlocked(randomPos, playerPos)) {
                return randomPos;
            }
        }
        return null;
    }

    @Override
    public boolean shouldContinue() {
        return this.targetPlayer != null && this.targetPlayer.isAlive() && !this.targetPlayer.isCreative();
    }
}
