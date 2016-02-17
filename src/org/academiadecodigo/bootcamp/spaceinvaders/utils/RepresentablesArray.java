package org.academiadecodigo.bootcamp.spaceinvaders.utils;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Alien;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;

/**
 * Created by codecadet on 16/02/16.
 */
public class RepresentablesArray {

    private Alien[] aliens;
    private int nextIndex;


    public RepresentablesArray(int maxSize) {

        aliens = new Alien[maxSize];
    }

    public Alien[] getAliens() {
        return aliens;
    }

    public void push(Alien object) {

        if(nextIndex == aliens.length){
            return;
        }

        aliens[nextIndex] = object;
        nextIndex++;

    }
}
