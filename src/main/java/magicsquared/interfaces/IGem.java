package magicsquared.interfaces;


public interface IGem {

	public GEM_TYPES getType();
	
	public enum GEM_TYPES {

		AMETHYST("amethyst"),
		AZURITE("azurite"),
		PERIDOT("peridot"),
		PHOSPHOPHYLLITE("phosphophyllite"),
		RUBY("ruby"),
		SAPPHIRE("sapphire"),;

		private String name;
		
		GEM_TYPES(String string) {
			name = string;
		}
		
		public String getName() { return name; } 
	}
}
