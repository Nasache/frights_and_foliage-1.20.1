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
import net.nathan.frights_and_foliage.world.tree.MarnorSaplingGenerator;
import net.nathan.frights_and_foliage.world.tree.OrangeAseriaSaplingGenerator;
import net.nathan.frights_and_foliage.world.tree.RedAseriaSaplingGenerator;
import net.nathan.frights_and_foliage.world.tree.YellowAseriaSaplingGenerator;

import static net.minecraft.block.Blocks.*;
import static net.minecraft.block.Blocks.JACK_O_LANTERN;

public class ModBlocks {

    public static final Block ASERIA_PLANKS = registerBlock("aseria_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ASERIA_STAIRS = registerBlock("aseria_stairs",
            new StairsBlock(ModBlocks.ASERIA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block ASERIA_SLAB = registerBlock("aseria_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block ASERIA_BUTTON = registerBlock("aseria_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final Block ASERIA_PRESSURE_PLATE = registerBlock("aseria_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block ASERIA_FENCE = registerBlock("aseria_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block ASERIA_FENCE_GATE = registerBlock("aseria_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block ASERIA_DOOR = registerBlock("aseria_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block ASERIA_TRAPDOOR = registerBlock("aseria_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block ASERIA_LOG = registerBlock("aseria_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ASERIA_WOOD = registerBlock("aseria_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ASERIA_LOG = registerBlock("stripped_aseria_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ASERIA_WOOD = registerBlock("stripped_aseria_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block RED_ASERIA_LEAVES = registerBlock("red_aseria_leaves",
            new RedAseriaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.BRIGHT_RED)));
    public static final Block ORANGE_ASERIA_LEAVES = registerBlock("orange_aseria_leaves",
            new OrangeAseriaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.ORANGE)));
    public static final Block YELLOW_ASERIA_LEAVES = registerBlock("yellow_aseria_leaves",
            new YellowAseriaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.YELLOW)));

    public static final Block RED_ASERIA_SAPLING = registerBlock("red_aseria_sapling",
            new SaplingBlock(new RedAseriaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.BRIGHT_RED)));
    public static final Block POTTED_RED_ASERIA_SAPLING = registerBlockWithoutBlockItem("potted_red_aseria_sapling",
            new FlowerPotBlock(RED_ASERIA_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.BRIGHT_RED)));

    public static final Block ORANGE_ASERIA_SAPLING = registerBlock("orange_aseria_sapling",
            new SaplingBlock(new OrangeAseriaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.ORANGE)));
    public static final Block POTTED_ORANGE_ASERIA_SAPLING = registerBlockWithoutBlockItem("potted_orange_aseria_sapling",
            new FlowerPotBlock(ORANGE_ASERIA_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.ORANGE)));

    public static final Block YELLOW_ASERIA_SAPLING = registerBlock("yellow_aseria_sapling",
            new SaplingBlock(new YellowAseriaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.YELLOW)));
    public static final Block POTTED_YELLOW_ASERIA_SAPLING = registerBlockWithoutBlockItem("potted_yellow_aseria_sapling",
            new FlowerPotBlock(YELLOW_ASERIA_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.YELLOW)));

    public static final Block FALLEN_LEAVES = registerBlock("fallen_leaves",
            new FallenLeavesBlock(FabricBlockSettings.copyOf(Blocks.PINK_PETALS).mapColor(MapColor.ORANGE)));

    public static final Block ASERIA_SIGN = registerBlockWithoutBlockItem("aseria_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), ModWoodTypes.ASERIA));
    public static final Block ASERIA_WALL_SIGN = registerBlockWithoutBlockItem("aseria_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN), ModWoodTypes.ASERIA));
    public static final Block ASERIA_HANGING_SIGN = registerBlockWithoutBlockItem("aseria_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN), ModWoodTypes.ASERIA));
    public static final Block ASERIA_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("aseria_wall_hanging_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.ASERIA));

    public static final Block ASERIA_SYRUP_LOG = registerBlock("aseria_syrup_log",
            new SyrupLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));

    public static final Block MARNOR_PLANKS = registerBlock("marnor_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MARNOR_STAIRS = registerBlock("marnor_stairs",
            new StairsBlock(ModBlocks.ASERIA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MARNOR_SLAB = registerBlock("marnor_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MARNOR_BUTTON = registerBlock("marnor_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.TERRACOTTA_PURPLE), BlockSetType.OAK, 30, true));
    public static final Block MARNOR_PRESSURE_PLATE = registerBlock("marnor_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_PURPLE), BlockSetType.OAK));
    public static final Block MARNOR_FENCE = registerBlock("marnor_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MARNOR_FENCE_GATE = registerBlock("marnor_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.TERRACOTTA_PURPLE), WoodType.OAK));
    //public static final Block MARNOR_DOOR = registerBlock("marnor_door",
    //        new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).mapColor(MapColor.TERRACOTTA_PURPLE), BlockSetType.OAK));
    //public static final Block MARNOR_TRAPDOOR = registerBlock("marnor_trapdoor",
    //        new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).mapColor(MapColor.TERRACOTTA_PURPLE), BlockSetType.OAK));
    public static final Block MARNOR_LOG = registerBlock("marnor_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MARNOR_WOOD = registerBlock("marnor_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block STRIPPED_MARNOR_LOG = registerBlock("stripped_marnor_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block STRIPPED_MARNOR_WOOD = registerBlock("stripped_marnor_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block MARNOR_SIGN = registerBlockWithoutBlockItem("marnor_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN).mapColor(MapColor.TERRACOTTA_PURPLE), ModWoodTypes.MARNOR));
    public static final Block MARNOR_WALL_SIGN = registerBlockWithoutBlockItem("marnor_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).mapColor(MapColor.TERRACOTTA_PURPLE), ModWoodTypes.MARNOR));
    public static final Block MARNOR_HANGING_SIGN = registerBlockWithoutBlockItem("marnor_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_PURPLE), ModWoodTypes.MARNOR));
    public static final Block MARNOR_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("marnor_wall_hanging_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_PURPLE), ModWoodTypes.MARNOR));

    public static final Block MARNOR_LEAVES = registerBlock("marnor_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block MARNOR_SAPLING = registerBlock("marnor_sapling",
            new MarnorSaplingBlock(new MarnorSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POTTED_MARNOR_SAPLING = registerBlockWithoutBlockItem("potted_marnor_sapling",
            new FlowerPotBlock(MARNOR_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.TERRACOTTA_PURPLE)));


    public static final Block INFESTED_MARNOR_LEAVES = registerBlock("infested_marnor_leaves",
            new InfestedLeafBlock(FabricBlockSettings.copyOf(OAK_LEAVES).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block MARNOR_VINES_PLANT = registerBlockWithoutBlockItem("marnor_vines_plant",
            new MarnorVinesPlantBlock(FabricBlockSettings.copyOf(WEEPING_VINES_PLANT).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MARNOR_VINES = registerBlock("marnor_vines",
            new MarnorVinesBlock(FabricBlockSettings.copyOf(WEEPING_VINES).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block WARPED_PUMPKIN = registerBlock("warped_pumpkin",
            new WarpedPumpkinBlock(FabricBlockSettings.copyOf(PUMPKIN).mapColor(MapColor.CYAN).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CARVED_WARPED_PUMPKIN = registerBlock("carved_warped_pumpkin",
            new WearableCarvedPumpkinBlock(FabricBlockSettings.copyOf(CARVED_PUMPKIN).mapColor(MapColor.CYAN).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block WARPED_JACK_O_LANTERN = registerBlock("warped_jack_o_lantern",
            new CarvedPumpkinBlock(FabricBlockSettings.copyOf(JACK_O_LANTERN).mapColor(MapColor.CYAN).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block WARPED_PUMPKIN_STEM = registerBlockWithoutBlockItem("warped_pumpkin_stem",
            (Block)new WarpedPumpkinStemBlock((WarpedGourdBlock) WARPED_PUMPKIN, () -> ModItems.WARPED_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.CYAN)
                            .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ATTACHED_WARPED_PUMPKIN_STEM = registerBlockWithoutBlockItem("attached_warped_pumpkin_stem",
            (Block)new AttachedWarpedPumpkinStemBlock((WarpedGourdBlock) WARPED_PUMPKIN, () -> ModItems.WARPED_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.CYAN)
                            .noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD)
                            .pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block CRIMSON_PUMPKIN = registerBlock("crimson_pumpkin",
            new CrimsonPumpkinBlock(FabricBlockSettings.copyOf(PUMPKIN).mapColor(MapColor.DARK_RED).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CARVED_CRIMSON_PUMPKIN = registerBlock("carved_crimson_pumpkin",
            new WearableCarvedPumpkinBlock(FabricBlockSettings.copyOf(CARVED_PUMPKIN).mapColor(MapColor.DARK_RED).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CRIMSON_JACK_O_LANTERN = registerBlock("crimson_jack_o_lantern",
            new CarvedPumpkinBlock(FabricBlockSettings.copyOf(JACK_O_LANTERN).mapColor(MapColor.DARK_RED).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CRIMSON_PUMPKIN_STEM = registerBlockWithoutBlockItem("crimson_pumpkin_stem",
            (Block)new CrimsonPumpkinStemBlock((CrimsonGourdBlock) CRIMSON_PUMPKIN, () -> ModItems.CRIMSON_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
                            .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ATTACHED_CRIMSON_PUMPKIN_STEM = registerBlockWithoutBlockItem("attached_crimson_pumpkin_stem",
            (Block)new AttachedCrimsonPumpkinStemBlock((CrimsonGourdBlock) CRIMSON_PUMPKIN, () -> ModItems.CRIMSON_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
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
