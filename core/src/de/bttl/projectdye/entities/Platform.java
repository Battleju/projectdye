package de.bttl.projectdye.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Platform extends Ground{

    public Platform(int x, int y) {
        texture = new Texture("platform.png");
        position = new Vector2(x, y);
        bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {

    }
}
