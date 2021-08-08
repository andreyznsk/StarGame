package ru.gb.screen;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;
import ru.gb.math.Rect;
import ru.gb.sprite.Background;
import ru.gb.sprite.Sheep;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture sheepTx;
    private Background background;
    private Sheep sheep;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        sheepTx = new Texture("G03.jpg");
        sheep = new Sheep(sheepTx);
        background = new Background(bg);

    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        sheep.resize(worldBounds);
        sheep.setHeightProportion(0.1f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        sheep.update();
        sheep.draw(batch);
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        sheepTx.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        sheep.touchDown(touch,pointer,button);
        return false;
    }

}