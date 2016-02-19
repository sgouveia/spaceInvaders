package org.academiadecodigo.bootcamp.spaceinvaders.utils;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Alien;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.EarthShip;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public class HitChecker {

    private Alien[] aliveAliens;
    private EarthShip earthShip;

    /**
     * Constructor
     * @param aliveAliens to iterate and check for hits
     * @param earthShip to access the stingray and check for hits
     */
    public HitChecker(Alien[] aliveAliens, EarthShip earthShip) {
        this.aliveAliens = aliveAliens;
        this.earthShip = earthShip;
    }

    /**
     * checks the stingray for hits with enemies and with the border
     * @return
     */
    public boolean stingRayCollision() {

        if (!earthShip.hasShot()) {
            return false;
        } //needed as the value for stingray is null before the first shoot

        if (earthShip.getStingRay().getCenterY() < 0) {
            return true;
        } //checks if the stingray leaves the screen;

        for (Alien a : aliveAliens) {
            if (a.getRepresentation().contains(earthShip.getStingRay().getCenterX(), earthShip.getStingRay().getCenterY())) {
                a.die();
                return true;
            } // iterates thru aliens array and checks for hits
        }
        return false;
    }

    /**
     * creates new array of alive aliens
     * @param aliveAliens
     */
    public void updateAliveAliens(Alien[] aliveAliens) {
        this.aliveAliens = aliveAliens;
    }
}
