package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;


import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentation;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.Direction;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public abstract class GameObject {

    Representable representation;

    /**
     * Constructor
     *
     * @param representation use factory method and object type for getting the right shape;
     */
    public GameObject(Representable representation) {
        this.representation = representation;
    }

    /**
     * getters and setters
     *
     * @return graphical representation of game object
     */
    public Representable getRepresentation() {
        return representation;
    }

    /**
     * moves object in
     *
     * @param direction set by the objects; and
     * @param speed
     */
    public void move(Direction direction, int speed) {

        SimpleGfxRepresentation unit = (SimpleGfxRepresentation) representation;
        switch (direction) {
            case UP:
                unit.move(0, -speed);
                break;
            case DOWN:
                unit.move(0, speed);
                break;
            case LEFT:
                unit.move(-speed, 0);
                break;
            case RIGHT:
                unit.move(speed, 0);
                break;
        }
    }
}
