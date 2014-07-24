package com.nounours.helpthepingouins;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class World {
	
	private Bear bear;
	private long lastBarrel = TimeUtils.millis();
	private long lastCloud = TimeUtils.millis();
	private Array<Barrel> barrels;
	private Array<Cloud> clouds;
	Iterator<Barrel> iter_barrels;
	Iterator<Cloud> iter_clouds;
	private Boolean dead = false;
	private Zap zap;
	private long playTime = TimeUtils.millis();
	private Texture texture_barrel, texture_cloud;

	
	World() {
		bear = new Bear(0,0, 76, 52);
		barrels = new Array<Barrel>();
		clouds = new Array<Cloud>();
		texture_barrel = new Texture(Gdx.files.internal("barrel.png"));
		texture_cloud = new Texture(Gdx.files.internal("cloud.png"));
	}
	
	Bear getBear() {
		return bear;
	}
	
	void checkBarrel() {
		if (TimeUtils.millis() - lastBarrel > 500) {
			Barrel barrel = new Barrel (640, MathUtils.random(480), texture_barrel);
			barrels.add(barrel);
			lastBarrel = TimeUtils.millis();
		}
	}
	
	void checkCloud() {
		if (TimeUtils.millis() - lastCloud > 1000) {
			Cloud cloud = new Cloud(640, MathUtils.random(480), texture_cloud);
			clouds.add(cloud);
			lastCloud = TimeUtils.millis();
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
	
	void checkCollision() {
		iter_barrels = barrels.iterator();
		while (iter_barrels.hasNext()) {
			Barrel barrel = iter_barrels.next();
			if (barrel.getBoundingRectangle().overlaps(bear.getBoundingRectangle())) {
				iter_barrels.remove();
				dead = true;
			}
			if (isZap()) { 
				if (barrel.getBoundingRectangle().overlaps(zap.getBoundingRectangle())) {
				iter_barrels.remove();
				zap = null;
				}
			}
		}
		iter_clouds = clouds.iterator();
		while (iter_clouds.hasNext()) {
			Cloud cloud = iter_clouds.next();
			if (cloud.getBoundingRectangle().overlaps(bear.getBoundingRectangle())) {
				iter_clouds.remove();
				dead = true;
			}
		}
	}
	
	Boolean isDead() {
		return dead;
	}

	void moveCloud() {
		iter_clouds = clouds.iterator();
		while (iter_clouds.hasNext()) {
			Cloud cloud = iter_clouds.next();
			cloud.translateX(-500 * Gdx.graphics.getDeltaTime());
		}
	}
	
	Array<Cloud> getClouds() {
		return clouds;
	}
	
	void fire() {
		zap = new Zap(bear.getX(), bear.getY());
	}
	
	Boolean isZap() {
		if (zap != null) return true;
		return false;
	}
	
	Zap getZap() {
		return zap;
	}
	
	void moveZap() {
		if (isZap()) zap.translateX(300 * Gdx.graphics.getDeltaTime());
	}
	
	long getPlayTime() {
		return playTime;
	}
}
