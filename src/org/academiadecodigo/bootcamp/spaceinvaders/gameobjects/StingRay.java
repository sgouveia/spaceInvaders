package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.Game;

/**
 * Created by codecadet on 15/02/16.
 */
public class StingRay extends GameObject {


    private int speed;

    public StingRay(Representable representation) {
        super(representation);
        speed = Game.GAME_SPEED * 3;
    }

        public void moveUp(){
            for (int i = 0; i < speed ; i++) {
                this.move(Direction.UP);
            }
        }




}
