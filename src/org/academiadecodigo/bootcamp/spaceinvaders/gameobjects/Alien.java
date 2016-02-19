package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.utils.Direction;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Sérgio Gouveia on 16/02/16.
 */
public class Alien extends GameObject {

    private int MOVE_WAIT = 40; //sets the rate by which the aliens make a move;

    private int speed;
    private boolean dead;
    private int cleanCounter = 4; //counter to delete explosion from screen;
    private int moveCounter = MOVE_WAIT; //counter to force alien to wait before making a move;

    /**
     * Constructor
     *
     * @param representation must use factory method;
     */
    public Alien(Representable representation) {

        super(representation);
        speed = 15;
    }

    public boolean isDead() {
        return dead;
    }

    /**
     * moves in direction; uses the counter so the aliens do not move in a "flowing" fashion;
     * @param direction
     */
    public void move(Direction direction) {
        moveCounter--;
        if (moveCounter == 0) {
            this.move(direction, speed);
            moveCounter = MOVE_WAIT;
        }
    }

    /**
     * Moves alien down by speed value; To be added to the game;
     */
    public void moveDown() {
        this.move(Direction.DOWN, speed);
    }

    /**
     * increase speed at each turn;
     * To be implemented, when the aliens change lines;
     *
     * @param speed
     */
    public void increaseSpeed(int speed) {
        speed += 5;
    }


    /**
     * kills aliens (mwahahaha!); sets dead to true and changes shape for an explosion;
     */
    public void die() {
        Shape newPic = new Picture(0, 0, "resources/explosion.jpg");
        getRepresentation().updateShape(newPic);
        dead = true;
    }

    /**
     * cleans the explosions from screen; the counter sets the time that an explosion stays on screen;
     */
    public void clean() {
        cleanCounter--;
        if (cleanCounter == 0) {
            getRepresentation().getShape().delete();
        }
    }
}
