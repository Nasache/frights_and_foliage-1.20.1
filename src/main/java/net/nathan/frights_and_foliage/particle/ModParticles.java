package net.nathan.frights_and_foliage.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModParticles {
    public static final DefaultParticleType RED_ASERIA_PARTICLE =
            registerParticle("red_aseria_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType ORANGE_ASERIA_PARTICLE =
            registerParticle("orange_aseria_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType YELLOW_ASERIA_PARTICLE =
            registerParticle("yellow_aseria_leaves", FabricParticleTypes.simple());


    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(FrightsAndFoliage.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        FrightsAndFoliage.LOGGER.info("Registering Particles for " + FrightsAndFoliage.MOD_ID);
    }
}