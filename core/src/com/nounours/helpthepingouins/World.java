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
	private Array<Fish> fishs;
	Iterator<Barrel> iter_barrels;
	Iterator<Cloud> iter_clouds;
	Iterator<Fish> iter_fishs;
	private Boolean dead = false;
	private Zap zap;
	private long playTime = TimeUtils.millis();
	private Texture texture_barrel, texture_cloud, texture_fish;

	
	World() {
		bear = new Bear(0,0, 76, 52);
		barrels = new Array<Barrel>();
		clouds = new Array<Cloud>();
		fishs = new Array<Fish>();
		texture_barrel = new Texture(Gdx.files.internal("barrel.png"));
		texture_cloud = new Texture(Gdx.files.internal("cloud.png"));
		texture_fish = new Texture(Gdx.files.internal("fish.png"));
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
				bear.decHealth();
			}
			if (isZap()) { 
				if (barrel.getBoundingRectangle().overlaps(zap.getBoundingRectangle())) {
				zap = null;
				checkFish((int)barrel.getX(), (int)barrel.getY());
				iter_barrels.remove();
				}
			}
			if (barrel.getX() < 0) iter_barrels.remove();
		}
		iter_clouds = clouds.iterator();
		while (iter_clouds.hasNext()) {
			Cloud cloud = iter_clouds.next();
			if (cloud.getBoundingRectangle().overlaps(bear.getBoundingRectangle())) {
				iter_clouds.remove();
				bear.decHealth();
			}
			if (cloud.getX() < 0) iter_clouds.remove();
		}
		iter_fishs = fishs.iterator();
		while (iter_fishs.hasNext()) {
			Fish fish = iter_fishs.next();
			if (fish.getBoundingRectangle().overlaps(bear.getBoundingRectangle())) {
				bear.eatFish();
				iter_fishs.remove();
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
			cloud.translateX(-200 * Gdx.graphics.getDeltaTime());
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
		if (isZap()) {
			zap.translateX(300 * Gdx.graphics.getDeltaTime());
			if (zap.getX() > 640) zap = null;
		}
	}
	
	long getPlayTime() {
		return playTime;
	}
	
	void checkFish(int x, int y) {
		if (MathUtils.random(100) > 66) {
			Fish fish = new Fish(texture_fish, x, y);
			fishs.add(fish);
		}
	}
	
	Array<Fish> getFishs() {
		return fishs;
	}
}
