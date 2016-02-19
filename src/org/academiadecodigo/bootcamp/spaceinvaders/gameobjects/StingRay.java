package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.utils.Direction;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public class StingRay extends GameObject {


    private int speed;

    /**
     * Constructor
     * @param representation shape to be drawn as; will return a line shape;
     */
    public StingRay(Representable representation) {
        super(representation);
        speed = 10;
    }

    /**
     * Get Centers so it can test for hits;
     * @return
     */
    public int getCenterY() {
        int y = getRepresentation().getY();
        int height = getRepresentation().getHeight();
        return y + height / 2;
    }

    public int getCenterX(){
        int x = getRepresentation().getX();
        int width = getRepresentation().getWidth();
        return x + width / 2;
    }

    /**
     * Moves the stingray after been shot; this object can only move up.
     */
    public void moveUp() {
        this.move(Direction.UP, speed);
    }


}
