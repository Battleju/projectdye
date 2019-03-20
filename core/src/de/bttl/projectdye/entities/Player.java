package de.bttl.projectdye.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import de.bttl.projectdye.ProjectDye;
import de.bttl.projectdye.maps.TestMap;
import de.bttl.projectdye.states.PlayState;

public class Player extends Entity{

    private TestMap world;
    private boolean jumpActive;
    private Vector2 velocity, acceleration, friction, jumpAcceleration;

    public Player(TestMap world, int x, int y) {
        this.world = world;
        texture = new Texture("player.png");
        position = new Vector2(x, y);
        acceleration = new Vector2(2, 0);
        velocity = new Vector2(0,0);
        friction = new Vector2(0,0);
        jumpAcceleration = new Vector2(0, 20);
        mass = 1;
        bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
        jumpActive = false;
    }

    @Override
    public void update(float dt) {
        bounds.setPosition(position.x, position.y);
        if(gravityCheck()){
            jumpActive = false;
            velocity.y = 0;
        }else {
            velocity.add(0, -1 * ProjectDye.gravity);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            if(!jumpActive){
                jumpActive = true;
                velocity.add(0, jumpAcceleration.y);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(!Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                velocity.add(acceleration.x * -1, acceleration.y);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(!Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                velocity.add(acceleration.x, acceleration.y);
            }
        }
        friction = new Vector2(velocity.x * ProjectDye.frictionNumberGround * -1, velocity.y * ProjectDye.frictionNumberAir * -1);
        velocity.add(friction);
        position.add(velocity);
    }

    private boolean gravityCheck(){
        for (int i = 0; i < world.getGroundControl().getEntities().size(); i++){
            if(world.getGroundControl().getEntities().get(i).collides(new Rectangle(bounds.x, bounds.y, bounds.width, 10))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
