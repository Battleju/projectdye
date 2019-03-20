package de.bttl.projectdye.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.bttl.projectdye.states.PlayState;

public abstract class Map {

    protected PlayState playState;

    public Map(PlayState playState) {
        this.playState = playState;
    }

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);

    public abstract void dispose();

}
