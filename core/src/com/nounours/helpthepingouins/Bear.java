package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bear extends Sprite {

	Bear(int x,int y, int width, int height) {
		super(new Texture(Gdx.files.internal("bear.png")),x,y, width, height);
		this.setCenter(38, 26);
	}
}
