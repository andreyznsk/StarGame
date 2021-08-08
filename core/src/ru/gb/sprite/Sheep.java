package ru.gb.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class Sheep extends Sprite {

    private static final float V_LEN = 0.05f;
    private Vector2 targetPos;
    private Vector2 v;

    public Sheep(Texture region) {
        super(new TextureRegion(region));
        targetPos = new Vector2();
        v = new Vector2();
    }

    public void update(){
        if (targetPos.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(targetPos);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.targetPos.set(touch);
        v.set(touch.cpy().sub(pos)).scl(V_LEN);
        System.out.println("Vector pos is: " + pos);
        System.out.println("Vector v is: " + v);
        System.out.println("--------------------------------");
        return false;
    }
}
