package magicsquared.interfaces;


public interface IGem {

	public GEM_TYPE getType();
	
	public enum GEM_TYPE {

		AMETHYST("amethyst", 7F),
		AZURITE("azurite", 3.5F),
		PERIDOT("peridot", 6.5F),
		PHOSPHOPHYLLITE("phosphophyllite", 3.5F),
		RUBY("ruby", 9F),
		SAPPHIRE("sapphire", 9F),;

		private String name;
		private float hardness;
		
		GEM_TYPE(String name, float hardness) {
			this.name = name;
			this.hardness = hardness;
		}
		
		public String getName() { return name; } 
		public float getHardness() { return hardness; }
	}
}
