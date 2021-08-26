package ru.gb.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.gb.base.BaseButton;
import ru.gb.math.Rect;
import ru.gb.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private static final float HEIGHT = 0.08f;
    private static final float BOTTOM_MARGIN = 0.009f;
    private GameScreen gameScreen;


    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + BOTTOM_MARGIN);

    }

    @Override
    public void action() {
        gameScreen.startNewGame();
        //game.setScreen(new GameScreen());
    }
}
