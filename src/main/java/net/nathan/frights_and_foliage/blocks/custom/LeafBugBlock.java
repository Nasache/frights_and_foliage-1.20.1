package net.nathan.frights_and_foliage.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.entity.custom.LeafBugEntity;

import java.util.List;

public class LeafBugBlock extends Block {

    public LeafBugBlock(Settings settings) {
        super(settings);
    }

    private void spawnLeafBug(ServerWorld world, BlockPos pos) {
        BlockPos spawnPos = pos.down();

        if (world.getBlockState(spawnPos).isAir()) {
            LeafBugEntity leafBugEntity = (LeafBugEntity) ModEntities.LEAFBUG.create(world);
            if (leafBugEntity != null) {
                leafBugEntity.refreshPositionAndAngles((double)spawnPos.getX() + 0.5, (double)spawnPos.getY() + 0.5, (double)spawnPos.getZ() + 0.5, 0.0F, 0.0F);
                world.spawnEntity(leafBugEntity);
                leafBugEntity.playSpawnEffects();
            }

            world.setBlockState(pos, Blocks.AZALEA_LEAVES.getDefaultState(), 3);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        if (!world.isClient) {
            Box detectionBox = new Box(pos).expand(0, -1, 0).stretch(0, -5, 0);

            List<PlayerEntity> players = world.getEntitiesByClass(PlayerEntity.class, detectionBox, player -> true);

            if (!players.isEmpty() && world.getBlockState(pos.down()).isAir()) {
                this.spawnLeafBug(world, pos);
            }
        }

        world.scheduleBlockTick(pos, this, 5);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, net.minecraft.entity.LivingEntity placer, net.minecraft.item.ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            ((ServerWorld) world).scheduleBlockTick(pos, this, 5);
        }
    }
}
