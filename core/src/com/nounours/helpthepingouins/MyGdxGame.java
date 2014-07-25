package com.nounours.helpthepingouins;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MyGdxGame extends Game {
	
	Music music;
	
	@Override
	public void create () {
		music = Gdx.audio.newMusic(Gdx.files.internal("Peanuts_groove.mp3"));
		music.play();
		music.setVolume(0.2f);
		music.setLooping(true);
		setScreen(new GameScreen(this));
		
 	}
	
	public void dispose() {
		music.dispose();
	}
}
