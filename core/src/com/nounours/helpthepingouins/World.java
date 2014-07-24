package com.nounours.helpthepingouins;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class World {
	
	private Bear bear;
	private long lastBarrel = TimeUtils.millis();
	private Array<Barrel> barrels;
	Iterator<Barrel> iter_barrels;
	
	World() {
		bear = new Bear(0,0, 76, 52);
		barrels = new Array<Barrel>();
	}
	
	Bear getBear() {
		return bear;
	}
	
	void checkBarrel() {
		if (TimeUtils.millis() - lastBarrel > 500) {
			Barrel barrel = new Barrel (640, MathUtils.random(480));
			barrels.add(barrel);
			lastBarrel = TimeUtils.millis();
			System.out.println("Spawn");
		}
	}
	
	Array<Barrel> getBarrels() {
		return barrels;
	}
	
	void moveBarrels() {
		iter_barrels = barrels.iterator();
		while (iter_barrels.hasNext()) {
			Barrel barrel = iter_barrels.next();
			barrel.setX(barrel.getX() - 300 * Gdx.graphics.getDeltaTime());
		}
	}
}
