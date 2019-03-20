package de.bttl.projectdye.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import de.bttl.projectdye.ProjectDye;
import de.bttl.projectdye.entities.EntityControl;
import de.bttl.projectdye.entities.Platform;
import de.bttl.projectdye.entities.Player;
import de.bttl.projectdye.maps.TestMap;

public class PlayState extends State{

    private final GameStateControl gsc;
    private TestMap testMap;

    public PlayState(final GameStateControl gsc) {
        super(gsc);
        this.gsc = gsc;
        cam.setToOrtho(false, ProjectDye.WIDTH, ProjectDye.HEIGHT);
        testMap = new TestMap(this);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        setCam(dt);
        testMap.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        testMap.render(sb);
    }

    @Override
    public void dispose() {
        testMap.dispose();
    }

    private void setCam(float dt) {
        float camViewportHalfX = cam.viewportWidth * .5f;
        float camViewportHalfY = cam.viewportHeight * .5f;
        float lerp = 5.00f;
        Vector3 position = cam.position;
        position.x += (testMap.getPlayer().getPosition().x - position.x) * lerp * dt;
        position.y += (testMap.getPlayer().getPosition().y - position.y) * lerp * dt;
        cam.position.set(position);
        cam.position.x = MathUtils.clamp(cam.position.x, camViewportHalfX, TestMap.FIELD_SIZE_WIDTH - camViewportHalfX);
        cam.position.y = MathUtils.clamp(cam.position.y, camViewportHalfY, TestMap.FIELD_SIZE_HEIGHT - camViewportHalfY);
        cam.update();
    }
}
