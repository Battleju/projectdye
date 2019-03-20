package de.bttl.projectdye.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import de.bttl.projectdye.ProjectDye;

public class MenuState extends State{

    private Texture background;
    private Stage stage;
    private final GameStateControl gsc;

    public MenuState(GameStateControl gsc){
        super(gsc);
        this.gsc = gsc;
        cam.setToOrtho(false, ProjectDye.WIDTH, ProjectDye.HEIGHT);
        background = new Texture("bg.png");
        stage = new Stage(new FitViewport(ProjectDye.WIDTH, ProjectDye.HEIGHT));

        //Play Button
        Texture txtBtnPause = new Texture("playbtn.png");
        Drawable drawablePause = new TextureRegionDrawable(new TextureRegion(txtBtnPause));
        ImageButton playBtn = new ImageButton(drawablePause);
        playBtn.setPosition((stage.getWidth()/2) - (txtBtnPause.getWidth() / 2), (stage.getHeight() / 4) - (txtBtnPause.getHeight() / 2));
        playBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsc.set(new CenterState(gsc));
                dispose();
            }
        });
        stage.addActor(playBtn);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        Gdx.input.setInputProcessor(stage);
        stage.act(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0, ProjectDye.WIDTH, ProjectDye.HEIGHT);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        stage.dispose();
    }
}
