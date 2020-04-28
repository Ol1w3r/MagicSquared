package magicsquared.init.toolmaterials;

import magicsquared.init.items.ModItems;
import magicsquared.interfaces.IGem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialGem implements ToolMaterial, IGem {

	private GemType type;
	
	public MaterialGem(GemType type) {
		this.type = type;
	}

	@Override
	public int getDurability() {

		return (int)(type.getHardness() * 156F);
	}

	@Override
	public float getMiningSpeed() {

		switch(type) {
		
		case AMBER:
			return 2.0F;
		case PETALITE:
			return 8.0F;
		case AZURITE:
		case PHOSPHOPHYLLITE:
			return 5F;
		case AMETHYST:
		case PERIDOT:
			return 8.5F;
		case RUBY:
		case SAPPHIRE:
			return 7.2F;
		default:
			return 8.0F;
		}
	}

	@Override
	public float getAttackDamage() {

		switch(type) {
		
		case AMBER:
			return 2.0F;
		case PETALITE:
			return 4.5F;
		case AZURITE:
		case PHOSPHOPHYLLITE:
			return 6.0F;
		case AMETHYST:
		case PERIDOT:
			return 2.1F; 
		case RUBY:
		case SAPPHIRE:
			return 2.7F;
		default:
			return 3.0F;
		}
	}

	@Override
	public int getMiningLevel() {

		float h = type.getHardness();

		return h >= 8 ? 3 : 
			   (h > 6 ? 2 : 
			   (h > 4 ? 1 : 
					    0));
	}

	@Override
	public int getEnchantability() {

		return 30;
	}

	@Override
	public Ingredient getRepairIngredient() {

		return Ingredient.ofItems(ModItems.gemItemMap.get(type.getName()));
	}

	@Override
	public GemType getGemType() {
		return type;
	}

	
}
