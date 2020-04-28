package magicsquared.interfaces;


public interface IGem {

	public GemType getGemType();
	
	public enum GemType {

		AMBER("amber", 2.2F),
		AMETHYST("amethyst", 7F),
		AZURITE("azurite", 3.5F),
		PERIDOT("peridot", 6.5F),
		PETALITE("petalite", 6.0F),
		PHOSPHOPHYLLITE("phosphophyllite", 3.5F),
		RUBY("ruby", 9F),
		SAPPHIRE("sapphire", 9F),;

		private String name;
		private float hardness;
		
		GemType(String name, float hardness) {
			this.name = name;
			this.hardness = hardness;
		}
		
		public String getName() { return name; } 
		public float getHardness() { return hardness; }
	}
}
