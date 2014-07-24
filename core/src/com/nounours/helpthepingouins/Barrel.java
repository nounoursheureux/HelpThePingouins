package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Barrel extends Sprite {
	Barrel(int x, int y) {
		super(new Texture(Gdx.files.internal("barrel_new.png")), 50, 68);
		this.setPosition(x,y);
	}
}
