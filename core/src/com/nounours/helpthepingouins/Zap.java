package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Zap extends Sprite {
	
	Zap(float x, float y) {
		super(new Texture(Gdx.files.internal("zap_ball.png")), 32, 32);
		setPosition(x,y);
	}
}
