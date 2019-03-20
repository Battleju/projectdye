package de.bttl.projectdye;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.bttl.projectdye.states.GameStateControl;
import de.bttl.projectdye.states.MenuState;

public class ProjectDye extends ApplicationAdapter {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "ProjectDye";
	public static final int FPS = 60;

	//Physical Constants
	public static final float frictionNumberGround = 0.2f;
	public static final float frictionNumberAir = 0.01f;
	public static final float gravity = 2.00f;

	private SpriteBatch batch;
	private Texture img;
	private GameStateControl gsc;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gsc = new GameStateControl();
		//music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		//music.setLooping(true);
		//music.setVolume(0.1f);
		//music.play();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsc.push(new MenuState(gsc));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsc.update(Gdx.graphics.getDeltaTime());
		gsc.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		super.dispose();
		music.dispose();
		gsc.dispose();
	}
}
