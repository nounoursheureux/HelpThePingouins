package com.nounours.helpthepingouins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen {

	private MyGdxGame game;
	private BitmapFont font;
	private SpriteBatch batch;
	private long playTime;

	GameOver(MyGdxGame game, long playTime) {
		this.game = game;
		this.playTime = playTime;
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "GAME OVER", 280, 270);
		font.draw(batch, "Vous avez tenu " + playTime + " secondes", 280, 240);
		font.draw(batch, "Appuyez sur Espace pour rejouer", 280, 210);
		batch.end();
		if (Gdx.input.isKeyPressed(Keys.SPACE)) game.setScreen(new GameScreen(game));
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}

