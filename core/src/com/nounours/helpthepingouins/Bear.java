package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bear extends Sprite {

	int health = 1;
	Texture normal, fish;
	Boolean fished = false;
	
	Bear(int x,int y, int width, int height) {
		super(new Texture(Gdx.files.internal("bear.png")), width, height);
		this.setCenter(38, 26);
		this.setPosition(x,y);
		normal = new Texture(Gdx.files.internal("bear.png"));
		fish = new Texture(Gdx.files.internal("bear_shield.png"));
	}
	
	int getHealth() {
		return health;
	}

	void eatFish() {
		setTexture(fish);
		setSize(91,63);
		fished = true;
	}
	
	void getNormal() {
		setTexture(normal);
		setSize(76,52);
		fished = false;
	}
	
	void decHealth() {
		health -= 1;
	}
	
	Boolean isFished() {
		return fished;
	}
}
