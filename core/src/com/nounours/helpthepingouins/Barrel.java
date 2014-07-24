package com.nounours.helpthepingouins;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Barrel extends Sprite {
	Barrel(int x, int y, Texture texture) {
		super(texture, 50, 68);
		this.setPosition(x,y);
	}
}
