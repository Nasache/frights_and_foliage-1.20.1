package net.nathan.frights_and_foliage;

import net.fabricmc.api.ModInitializer;

import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.blocks.entity.ModBlockEntities;
import net.nathan.frights_and_foliage.entity.ModBoats;
import net.nathan.frights_and_foliage.item.ModItemGroup;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.particle.ModParticles;
import net.nathan.frights_and_foliage.world.biome.ModBiomes;
import net.nathan.frights_and_foliage.world.gen.ModWorldGeneration;
import net.nathan.frights_and_foliage.world.tree.ModFoliagePlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrightsAndFoliage implements ModInitializer {
	public static final String MOD_ID = "frights_and_foliage";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		//ModRegistries.registerModStuffs();

		//ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGeneration();
		ModFoliagePlacerTypes.register();

		//ModSounds.registerSounds();

		ModBlockEntities.registerBlockEntities();
		ModBoats.registerBoats();

		ModParticles.registerParticles();

		//ModPaintings.registerPaintings();
	}
}