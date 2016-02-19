package org.academiadecodigo.bootcamp.spaceinvaders.utils;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Alien;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.EarthShip;

/**
 * Created by codecadet on 15/02/16.
 */
public class HitChecker {

    private Alien[] aliveAliens;
    private EarthShip earthShip;

    public HitChecker(Alien[] aliveAliens, EarthShip earthShip) {
        this.aliveAliens = aliveAliens;
        this.earthShip = earthShip;
    }


    public boolean stingRayCollision() {

        if (!earthShip.hasShot()) {
            return false;
        }

        if(earthShip.getStingRay().getCenterY() < 0){
            return true;
        }

        for (Alien a : aliveAliens) {
            if (a.getRepresentation().contains(earthShip.getStingRay().getCenterX(), earthShip.getStingRay().getCenterY())) {
                a.die();
                return true;
            }
        }
        return false;
    }

    public void updateAliveAliens(Alien[] aliveAliens) {
        this.aliveAliens = aliveAliens;
    }
}
