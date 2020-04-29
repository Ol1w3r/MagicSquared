package magicsquared.interfaces;


public interface IGem {

	public GemType getGemType();
	
	public enum GemType {

		AMBER("amber", 2.2F, 0xffab02, 0x916100),
		AMETHYST("amethyst", 7F, 0xb54fed, 0x8709cd),
		AZURITE("azurite", 3.5F, 0x043681, 0x021c43),
		PERIDOT("peridot", 6.5F, 0x089f00, 0x045200),
		PETALITE("petalite", 6.0F, 0xf1e7ec, 0xe9a3c8),
		PHOSPHOPHYLLITE("phosphophyllite", 3.5F, 0x21c773, 0x008340),
		RUBY("ruby", 9F, 0xff0000, 0xff0000),
		SAPPHIRE("sapphire", 9F, 0x1700ff, 0x1700ff),;

		private String name;
		private float hardness;
		private int primarycolour;
		private int secondarycolour;
		
		
		GemType(String name, float hardness, int primarycolour, int secondarycolour) {
			this.name = name;
			this.hardness = hardness;
			this.primarycolour = primarycolour;
			this.secondarycolour = secondarycolour;
		}
		
		public String getName() { return name; } 
		public float getHardness() { return hardness; }
		public int colour1() { return primarycolour; }
		public int colour2() { return secondarycolour; }
	}
}
