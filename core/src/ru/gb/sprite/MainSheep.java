package ru.gb.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class MainSheep extends Sprite {


    private static final float V_LEN = 0.005f;
    private static final float PADDING = 0.03f;
    private Rect worldBounds;
    private final Game game;

    private Vector2 targetPos;
    private Vector2 v;

    public MainSheep(TextureRegion atlas, Game game ) {
        super(atlas);
        targetPos = new Vector2();
        v = new Vector2();
        this.game = game;
    }

    public void update() {
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() >  worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        pos.add(v);
       /* if (targetPos.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(targetPos);
        }*/
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.15f);
        pos.set(worldBounds.pos);
        setBottom(worldBounds.getBottom() + PADDING);
        this.worldBounds = worldBounds;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.targetPos.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        v.y = 0;
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        v.set(0,0);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 22) {
            v.set(V_LEN,0);
        }
        if (keycode == 21) {
            v.set(-V_LEN,0);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == 22 || keycode == 21) {
            v.set(0,0);
        }
        return false;
    }
}
