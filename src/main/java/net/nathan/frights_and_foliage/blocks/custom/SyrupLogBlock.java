package net.nathan.frights_and_foliage.blocks.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import net.nathan.frights_and_foliage.item.ModItems;

public class SyrupLogBlock extends PillarBlock {
    public static final IntProperty AGE;
    private static final int MAX_AGE = 3;

    public SyrupLogBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(AGE, 0)
                .with(Properties.AXIS, Direction.Axis.Y));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, Properties.AXIS);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);
        if (age < MAX_AGE && random.nextInt(5) == 0) {
            world.setBlockState(pos, state.with(AGE, age + 1), 2);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        int age = state.get(AGE);

        if (age == MAX_AGE && itemStack.isOf(Items.GLASS_BOTTLE)) {
            itemStack.decrement(1);
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

            ItemStack syrupBottle = new ItemStack(ModItems.ASERIA_SYRUP_BOTTLE);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, syrupBottle);
            } else if (!player.getInventory().insertStack(syrupBottle)) {
                player.dropItem(syrupBottle, false);
            }

            world.setBlockState(pos, state.with(AGE, 0), 2);
            world.emitGameEvent(GameEvent.FLUID_PICKUP, pos, Emitter.of(player, state.with(AGE, 0)));

            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }

    static {
        AGE = Properties.AGE_3;
    }
}
