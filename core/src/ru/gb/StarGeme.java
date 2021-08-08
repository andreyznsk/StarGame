package ru.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StarGeme extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("Logo.jpg");
		img = new Texture("G03.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.4f, 0.24f, 0.51f, 1);
		batch.begin();
		batch.draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(img,0,0,200,150);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		img.dispose();
	}
}
