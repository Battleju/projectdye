package de.bttl.projectdye.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.bttl.projectdye.entities.EntityControl;
import de.bttl.projectdye.entities.Platform;
import de.bttl.projectdye.entities.Player;
import de.bttl.projectdye.states.PlayState;

public class TestMap extends Map{

    private EntityControl entityControl;
    private EntityControl groundControl;

    private Player player;
    private Texture background;

    public static final int FIELD_SIZE_HEIGHT = 2000;
    public static final int FIELD_SIZE_WIDTH = 2000;

    public TestMap(PlayState playState) {
        super(playState);
        entityControl = new EntityControl();
        groundControl = new EntityControl();
        groundControl.addEntity(new Platform(500, 500));
        groundControl.addEntity(new Platform(-100, 400));
        groundControl.addEntity(new Platform(1100, 400));
        player = new Player(this,600, 510);
        entityControl.addEntity(player);
        background = new Texture("bggame.png");
    }

    @Override
    public void update(float dt) {
        groundControl.updateEntities(dt);
        entityControl.updateEntities(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, 2000, 2000);
        groundControl.renderEntities(sb);
        entityControl.renderEntities(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        entityControl.disposeAll();
    }

    public Player getPlayer() {
        return player;
    }

    public EntityControl getGroundControl() {
        return groundControl;
    }

    public EntityControl getEntityControl() {
        return entityControl;
    }
}
