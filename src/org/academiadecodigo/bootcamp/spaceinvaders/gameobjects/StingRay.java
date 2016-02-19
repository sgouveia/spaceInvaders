package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.Game;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 15/02/16.
 */
public class StingRay extends GameObject {


    private int speed;

    public StingRay(Representable representation) {
        super(representation);

        speed = 10;
    }

    public void moveUp() {
        this.move(Direction.UP, speed);
    }

    public int getCenterY() {
        int y = getRepresentation().getY();
        int height = getRepresentation().getHeight();
        return y + height / 2;
    }

    public int getCenterX(){
        int x = getRepresentation().getX();
        int width = getRepresentation().getWidth();
        return x + width/2;
    }
}
