package net.nathan.frights_and_foliage.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.custom.*;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.util.ModWoodTypes;
import net.nathan.frights_and_foliage.world.tree.OrangeAcerSaplingGenerator;
import net.nathan.frights_and_foliage.world.tree.RedAcerSaplingGenerator;
import net.nathan.frights_and_foliage.world.tree.YellowAcerSaplingGenerator;

import static net.minecraft.block.Blocks.*;
import static net.minecraft.block.Blocks.JACK_O_LANTERN;

public class ModBlocks {

    public static final Block ACER_PLANKS = registerBlock("acer_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACER_STAIRS = registerBlock("acer_stairs",
            new StairsBlock(ModBlocks.ACER_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block ACER_SLAB = registerBlock("acer_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block ACER_BUTTON = registerBlock("acer_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final Block ACER_PRESSURE_PLATE = registerBlock("acer_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block ACER_FENCE = registerBlock("acer_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block ACER_FENCE_GATE = registerBlock("acer_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block ACER_DOOR = registerBlock("acer_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block ACER_TRAPDOOR = registerBlock("acer_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block ACER_LOG = registerBlock("acer_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ACER_WOOD = registerBlock("acer_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ACER_LOG = registerBlock("stripped_acer_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ACER_WOOD = registerBlock("stripped_acer_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block RED_ACER_LEAVES = registerBlock("red_acer_leaves",
            new RedAcerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.BRIGHT_RED)));
    public static final Block ORANGE_ACER_LEAVES = registerBlock("orange_acer_leaves",
            new OrangeAcerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.ORANGE)));
    public static final Block YELLOW_ACER_LEAVES = registerBlock("yellow_acer_leaves",
            new YellowAcerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.YELLOW)));

    public static final Block RED_ACER_SAPLING = registerBlock("red_acer_sapling",
            new SaplingBlock(new RedAcerSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.BRIGHT_RED)));
    public static final Block POTTED_RED_ACER_SAPLING = registerBlockWithoutBlockItem("potted_red_acer_sapling",
            new FlowerPotBlock(RED_ACER_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.BRIGHT_RED)));

    public static final Block ORANGE_ACER_SAPLING = registerBlock("orange_acer_sapling",
            new SaplingBlock(new OrangeAcerSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.ORANGE)));
    public static final Block POTTED_ORANGE_ACER_SAPLING = registerBlockWithoutBlockItem("potted_orange_acer_sapling",
            new FlowerPotBlock(ORANGE_ACER_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.ORANGE)));

    public static final Block YELLOW_ACER_SAPLING = registerBlock("yellow_acer_sapling",
            new SaplingBlock(new YellowAcerSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.YELLOW)));
    public static final Block POTTED_YELLOW_ACER_SAPLING = registerBlockWithoutBlockItem("potted_yellow_acer_sapling",
            new FlowerPotBlock(YELLOW_ACER_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.YELLOW)));

    public static final Block ACER_LEAVES = registerBlock("acer_leaves",
            new AcerLeavesBlock(FabricBlockSettings.copyOf(Blocks.PINK_PETALS).mapColor(MapColor.ORANGE)));

    public static final Block ACER_SIGN = registerBlockWithoutBlockItem("acer_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), ModWoodTypes.ACER));
    public static final Block ACER_WALL_SIGN = registerBlockWithoutBlockItem("acer_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN), ModWoodTypes.ACER));
    public static final Block ACER_HANGING_SIGN = registerBlockWithoutBlockItem("acer_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN), ModWoodTypes.ACER));
    public static final Block ACER_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("acer_wall_hanging_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.ACER));


    public static final Block WARPED_PUMPKIN = registerBlock("warped_pumpkin",
            new WarpedPumpkinBlock(FabricBlockSettings.copyOf(PUMPKIN)));

    public static final Block CARVED_WARPED_PUMPKIN = registerBlock("carved_warped_pumpkin",
            new WearableCarvedPumpkinBlock(FabricBlockSettings.copyOf(CARVED_PUMPKIN)));

    public static final Block WARPED_JACK_O_LANTERN = registerBlock("warped_jack_o_lantern",
            new CarvedPumpkinBlock(FabricBlockSettings.copyOf(JACK_O_LANTERN)));

    public static final Block WARPED_PUMPKIN_STEM = registerBlockWithoutBlockItem("warped_pumpkin_stem",
            (Block)new WarpedPumpkinStemBlock((WarpedGourdBlock) WARPED_PUMPKIN, () -> ModItems.WARPED_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN)
                            .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ATTACHED_WARPED_PUMPKIN_STEM = registerBlockWithoutBlockItem("attached_warped_pumpkin_stem",
            (Block)new AttachedWarpedPumpkinStemBlock((WarpedGourdBlock) WARPED_PUMPKIN, () -> ModItems.WARPED_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN)
                            .noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD)
                            .pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block CRIMSON_PUMPKIN = registerBlock("crimson_pumpkin",
            new CrimsonPumpkinBlock(FabricBlockSettings.copyOf(PUMPKIN)));

    public static final Block CARVED_CRIMSON_PUMPKIN = registerBlock("carved_crimson_pumpkin",
            new WearableCarvedPumpkinBlock(FabricBlockSettings.copyOf(CARVED_PUMPKIN)));

    public static final Block CRIMSON_JACK_O_LANTERN = registerBlock("crimson_jack_o_lantern",
            new CarvedPumpkinBlock(FabricBlockSettings.copyOf(JACK_O_LANTERN)));

    public static final Block CRIMSON_PUMPKIN_STEM = registerBlockWithoutBlockItem("crimson_pumpkin_stem",
            (Block)new CrimsonPumpkinStemBlock((CrimsonGourdBlock) CRIMSON_PUMPKIN, () -> ModItems.CRIMSON_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN)
                            .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ATTACHED_CRIMSON_PUMPKIN_STEM = registerBlockWithoutBlockItem("attached_crimson_pumpkin_stem",
            (Block)new AttachedCrimsonPumpkinStemBlock((CrimsonGourdBlock) CRIMSON_PUMPKIN, () -> ModItems.CRIMSON_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN)
                            .noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD)
                            .pistonBehavior(PistonBehavior.DESTROY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FrightsAndFoliage.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FrightsAndFoliage.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(FrightsAndFoliage.MOD_ID, name), block);
    }
    public static void registerModBlocks() {
        FrightsAndFoliage.LOGGER.info("Registering ModBlocks for " + FrightsAndFoliage.MOD_ID);
    }
}
