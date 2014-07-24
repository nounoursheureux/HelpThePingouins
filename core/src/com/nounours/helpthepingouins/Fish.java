package com.nounours.helpthepingouins;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Fish extends Sprite {
	
	Fish(Texture texture,int x,int y) {
		super(texture, 55, 47);
		setPosition(x,y);
	}
}
