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
    }


    public void moveRight() {

        for (int i = 0; i < speed; i++) {


            this.move(Direction.RIGHT);
        }
    }

    public void moveLeft() {

            this.move(Direction.LEFT);

    }

    public void moveDown() {

            this.move(Direction.DOWN);

    }


    public void increaseSpeed(int speed) {
        speed += 5;
    }


}