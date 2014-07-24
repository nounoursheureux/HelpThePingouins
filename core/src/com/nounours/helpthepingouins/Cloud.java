package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cloud extends Sprite {
	
	Cloud(int x, int y) {
		super(new Texture(Gdx.files.internal("cloud_new.png")),75,55);
		this.setPosition(x,y);
	}
}
