package de.bttl.projectdye.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import de.bttl.projectdye.ProjectDye;

public class CenterState extends State{

    private Stage stage;

    protected CenterState(GameStateControl gsc) {
        super(gsc);
        cam.setToOrtho(false, ProjectDye.WIDTH, ProjectDye.HEIGHT);
        stage = new Stage(new FitViewport(ProjectDye.WIDTH, ProjectDye.HEIGHT));

        //lvl1 Button
        Texture txtBtnlvl1 = new Texture("lvl1btn.png");
        Drawable drawableBtnLvl1 = new TextureRegionDrawable(new TextureRegion(txtBtnlvl1));
        ImageButton lvl1Btn = new ImageButton(drawableBtnLvl1);
        lvl1Btn.setPosition((stage.getWidth()/2) - (txtBtnlvl1.getWidth() / 2), ((stage.getHeight() / 4) * 3) - (txtBtnlvl1.getHeight() / 2));
        lvl1Btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsc.set(new PlayState(gsc));
                dispose();
            }
        });
        stage.addActor(lvl1Btn);

        //lvl1 Button
        Texture txtBtnlvl2 = new Texture("lvl2btn.png");
        Drawable drawableBtnLvl2 = new TextureRegionDrawable(new TextureRegion(txtBtnlvl2));
        ImageButton lvl2Btn = new ImageButton(drawableBtnLvl2);
        lvl2Btn.setPosition((stage.getWidth()/2) - (txtBtnlvl2.getWidth() / 2), ((stage.getHeight() / 4) * 2) - (txtBtnlvl2.getHeight() / 2));
        lvl2Btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsc.set(new PlayState(gsc));
                dispose();
            }
        });
        stage.addActor(lvl2Btn);

        //lvl1 Button
        Texture txtBtnlvl3 = new Texture("lvl3btn.png");
        Drawable drawableBtnLvl3 = new TextureRegionDrawable(new TextureRegion(txtBtnlvl3));
        ImageButton lvl3Btn = new ImageButton(drawableBtnLvl3);
        lvl3Btn.setPosition((stage.getWidth()/2) - (txtBtnlvl3.getWidth() / 2), ((stage.getHeight() / 4) * 1) - (txtBtnlvl3.getHeight() / 2));
        lvl3Btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsc.set(new PlayState(gsc));
                dispose();
            }
        });
        stage.addActor(lvl3Btn);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    protected void handleInput() {

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
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
