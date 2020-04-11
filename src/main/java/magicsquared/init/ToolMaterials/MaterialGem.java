package magicsquared.init.ToolMaterials;

import magicsquared.init.items.RegisterItems;
import magicsquared.interfaces.IGem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialGem implements ToolMaterial, IGem {

	private GEM_TYPE type;
	
	public MaterialGem(GEM_TYPE type) {
		this.type = type;
	}

	@Override
	public int getDurability() {

		return (int)(type.getHardness() * 156F);
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
	public GEM_TYPE getType() {
		return type;
	}

	
}
