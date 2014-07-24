package com.nounours.helpthepingouins;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cloud extends Sprite {
	
	Cloud(int x, int y, Texture texture) {
		super(texture,75,55);
		this.setPosition(x,y);
	}
}
