package magicsquared.init;

import magicsquared.init.blocks.ModBlocks;
import magicsquared.interfaces.IGem.GemType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class BiomeHandler {

	public BiomeHandler() {
		
			Registry.BIOME.forEach(this::addGemOres);
	}
	
	private void addGemOres(Biome biome) {
		if(biome.getCategory() != Category.THEEND || biome.getCategory() != Category.NETHER)
		{
			for(GemType type: GemType.values()) {
				biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									ModBlocks.blockMap.get(type.getName() + "_ore").getDefaultState(),
									3))
					.createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									10,
									12,
									12,
									24
				))));
			}
		}
	}
}
