package magicsquared.init.items;

import magicsquared.interfaces.IGem;

public class GemItem extends BasicItem implements IGem {

	private GEM_TYPE type;
	
	public GemItem(GEM_TYPE type) {
		
		super();
		
		this.type = type;
	}

	@Override
	public GEM_TYPE getType() {
		return type;
	}
}
