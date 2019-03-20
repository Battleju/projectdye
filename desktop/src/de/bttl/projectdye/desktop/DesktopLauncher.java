package de.bttl.projectdye.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.bttl.projectdye.ProjectDye;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ProjectDye.WIDTH;
		config.height = ProjectDye.HEIGHT;
		config.title = ProjectDye.TITLE;
		new LwjglApplication(new ProjectDye(), config);
	}
}
