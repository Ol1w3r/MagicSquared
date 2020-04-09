package magicsquared.init.ToolMaterials;

import magicsquared.init.items.RegisterItems;
import magicsquared.interfaces.IGem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialGem implements ToolMaterial, IGem {

	private GEM_TYPES type;
	
	public MaterialGem(GEM_TYPES type) {
		this.type = type;
	}

	@Override
	public int getDurability() {

		switch(type) {
		
		case AZURITE:
		case PHOSPHOPHYLLITE:
			return 546;
		case AMETHYST:
			return 1092;
		case PERIDOT:
			return 1014;
		case RUBY:
		case SAPPHIRE:
			return 1404;
		default:
			return 1561;
		}
	}

	@Override
	public float getMiningSpeed() {

		switch(type) {
		
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

		switch(type) {
		
		case AZURITE:
		case PHOSPHOPHYLLITE:
			return 1;
		case RUBY:
		case SAPPHIRE:
			return 3;
		case AMETHYST:
		case PERIDOT:
		default:
			return 2;
		}
	}

	@Override
	public int getEnchantability() {

		switch(type) {
		
		case AZURITE:
		case AMETHYST:
		case PERIDOT:
		case PHOSPHOPHYLLITE:
		case RUBY:
		case SAPPHIRE:
			return 30;
		default:
			return 10;
		}
	}

	@Override
	public Ingredient getRepairIngredient() {
		switch(type) {
		
		case AZURITE:
			return Ingredient.ofItems(RegisterItems.ITEM_AZURITE);
		case AMETHYST:
			return Ingredient.ofItems(RegisterItems.ITEM_AMETHYST);
		case PERIDOT:
			return Ingredient.ofItems(RegisterItems.ITEM_PERIDOT);
		case PHOSPHOPHYLLITE:
			return Ingredient.ofItems(RegisterItems.ITEM_PHOSPHOPHYLLITE);
		case RUBY:
			return Ingredient.ofItems(RegisterItems.ITEM_RUBY);
		case SAPPHIRE:
			return Ingredient.ofItems(RegisterItems.ITEM_SAPPHIRE);
		default:
			return null;
		}
	}

	@Override
	public GEM_TYPES getType() {
		return type;
	}

	
}
