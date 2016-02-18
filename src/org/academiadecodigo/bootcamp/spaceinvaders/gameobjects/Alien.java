package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.Board;
import org.academiadecodigo.bootcamp.spaceinvaders.Game;

/**
 * Created by codecadet on 16/02/16.
 */
public class Alien extends GameObject {

    private int speed;

    /**
     * Constructor
     * @param representation
     */
    public Alien(Representable representation) {

        super(representation);
        speed = Game.GAME_SPEED;
        setDirection(Direction.RIGHT);
    }


    /**
     * Moves alien to the right by speed value
     */
    public void moveRight() {

        for (int i = 0; i < speed; i++) {
            this.move(Direction.RIGHT);
        }
    }

    /**
     * Moves alien to the left by speed value;
     */
    public void moveLeft() {

        for (int i = 0; i < speed ; i++) {
            this.move(Direction.LEFT);
        }
    }

    /**
     * Moves alien down by speed value;
     */
    public void moveDown() {
            this.move(Direction.DOWN);
    }

    /**
     * increase speed at each turn;
     * @param speed
     */
    public void increaseSpeed(int speed) {
        speed += 5;
    }


}
