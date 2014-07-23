package com.nounours.helpthepingouins;


public class World {
	
	private Bear bear;
	
	World() {
		bear = new Bear(0,0, 76, 52);
	}
	
	Bear getBear() {
		return bear;
	}
}
