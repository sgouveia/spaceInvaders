package org.academiadecodigo.bootcamp.spaceinvaders.utils;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;

/**
 * Created by codecadet on 16/02/16.
 */
public class RepresentablesArray {

    private Representable[] representables;
    private int nextIndex;


    public RepresentablesArray(int maxSize) {

        representables = new Representable[maxSize];
    }

    public void push(Representable object) {

        if(nextIndex == representables.length){
            return;
        }

        representables[nextIndex] = object;
        nextIndex++;

    }
}
