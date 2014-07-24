package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bear extends Sprite {

	int health = 1;
	
	Bear(int x,int y, int width, int height) {
		super(new Texture(Gdx.files.internal("bear.png")), width, height);
		this.setCenter(38, 26);
		this.setPosition(x,y);
	}
	
	int getHealth() {
		return health;
	}

	void eatFish() {
		health += 1;
	}
	
	void decHealth() {
		health -= 1;
	}
}
