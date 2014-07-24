package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
	
	MyGdxGame game;
	SpriteBatch batch;
	World world;
	Boolean variable;
	private int CurFPS = Gdx.graphics.getFramesPerSecond();
	Texture heart;

	GameScreen(MyGdxGame game) {
		this.game = game;
		world = new World();
		batch = new SpriteBatch();
		heart = new Texture(Gdx.files.internal("heart.png"));
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (CurFPS != Gdx.graphics.getFramesPerSecond()) {
			Gdx.graphics.setTitle(String.valueOf(Gdx.graphics.getFramesPerSecond())); 
			CurFPS = Gdx.graphics.getFramesPerSecond();
		}
		if (Gdx.input.getX() > 0 && Gdx.input.getX() < 640 && Gdx.input.getY() > 0 && Gdx.input.getY() < 480) world.getBear().setPosition(Gdx.input.getX() - 38, 480 - Gdx.input.getY() - 26);
		if (Gdx.input.isKeyPressed(Keys.D) && !world.isZap()) world.fire();
		batch.begin();
		batch.draw(new Texture(Gdx.files.internal("arctic_background.png")), 0, 0);
		for (int i = 0; i < world.getBear().getHealth(); i++) batch.draw(heart, 20 + 90 * i, 400);
		world.getBear().draw(batch);
		if (world.isZap()) world.getZap().draw(batch);
		for (Barrel barrel: world.getBarrels()) barrel.draw(batch);
		for (Cloud cloud: world.getClouds()) cloud.draw(batch);
		for (Fish fish: world.getFishs()) fish.draw(batch);
		batch.end();
		world.checkBarrel();
		world.checkCloud();
		world.moveBarrels();
		world.moveCloud();
		world.checkCollision();
		world.moveZap();
		if (world.getBear().getHealth() <= 0) gameOver();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	void gameOver() {
		game.setScreen(new GameOver(game, (TimeUtils.millis() - world.getPlayTime()) / 1000));
	}
	
}
