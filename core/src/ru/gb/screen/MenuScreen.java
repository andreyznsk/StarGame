package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 0.05f;

    private Texture img;
    private Texture backGround;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 targetPos;

    @Override
    public void show() {
        super.show();
        img = new Texture("G03.jpg");
        backGround = new Texture("Logo.jpg");
        pos = new Vector2();
        v = new Vector2();
        targetPos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(backGround, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (targetPos.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(targetPos);
        }

    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        targetPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(targetPos.cpy().sub(pos)).scl(V_LEN);
        System.out.println(v);
        return false;
    }

}