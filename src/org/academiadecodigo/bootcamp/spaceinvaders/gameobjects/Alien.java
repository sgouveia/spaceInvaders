package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.Board;
import org.academiadecodigo.bootcamp.spaceinvaders.Game;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/16.
 */
public class Alien extends GameObject {

    private int MOVE_WAIT = 50;

    private int speed;
    private boolean dead;
    private int cleanCounter = 4;
    private int moveCounter = MOVE_WAIT;

    /**
     * Constructor
     *
     * @param representation
     */
    public Alien(Representable representation) {

        super(representation);
        speed = 10;
    }

    public int getTopY() {
        return getRepresentation().getY();
    }

    public int getBottomY() {
        return getTopY() + getRepresentation().getHeight();
    }

    public int getLeftX() {
        return getRepresentation().getX();
    }

    public int getRightX() {
        return getLeftX() + getRepresentation().getWidth();
    }

    public void move(Direction direction) {
        moveCounter--;
        if (moveCounter == 0) {
            this.move(direction, speed);
            moveCounter = MOVE_WAIT;
        }
    }

    /**
     * Moves alien down by speed value;
     */
    public void moveDown() {
        this.move(Direction.DOWN, speed);
    }

    /**
     * increase speed at each turn;
     *
     * @param speed
     */
    public void increaseSpeed(int speed) {
        speed += 5;
    }


    public boolean isDead() {
        return dead;
    }

    public void die() {
        Shape newPic = new Picture(0, 0, "explosion.jpg");
        getRepresentation().updateShape(newPic);
        dead = true;
    }

    public void clean() {
        cleanCounter--;
        if (cleanCounter == 0) {
            getRepresentation().getShape().delete();
        }
    }
}
