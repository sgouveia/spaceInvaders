package org.academiadecodigo.bootcamp.spaceinvaders.utils;

import org.academiadecodigo.bootcamp.spaceinvaders.Board;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Alien;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Direction;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;

/**
 * Created by codecadet on 16/02/16.
 */
public class AliensArray {

    private Alien[] aliens;
    private int nextIndex;


    public AliensArray(int maxSize) {

        aliens = new Alien[maxSize];
    }

    public Alien[] getAliveAliens() {

        Alien[] aliveAliens = new Alien[getAliveNr()];
        int aliveCounter = 0;

        for (Alien a : aliens) {
            if (a == null) {
                continue;
            }

            if (!a.isDead()) {
                aliveAliens[aliveCounter++] = a;
            }
        }

        return aliveAliens;
    }

    public Alien[] getDeadAliens() {

        Alien[] deadAliens = new Alien[aliens.length - getAliveAliens().length];
        int deadCounter = 0;

        for (Alien a : aliens) {
            if (a == null) {
                continue;
            }
            if (a.isDead()) {
                deadAliens[deadCounter++] = a;
            }
        }
        return deadAliens;
    }

    public void push(Alien object) {

        if (nextIndex == aliens.length) {
            return;
        }

        aliens[nextIndex] = object;
        nextIndex++;

    }

    public Alien pop() {
        return aliens[nextIndex--];
    }

    public int getLeftX() {
        int leftX = Board.width;

        for (Alien a : getAliveAliens()) {
            if (a == null) {
                continue;
            }

            int x = a.getRepresentation().getX();

            if (x < leftX) {
                leftX = x;
            }

        }

        return leftX;
    }

    public int getRightX() {
        int rightX = 0;

        for (Alien a : getAliveAliens()) {
            if (a == null) {
                continue;
            }

            int x = a.getRepresentation().getX();

            if (x > rightX) {
                rightX = x;
            }
        }

        return rightX;
    }

    public void moveAliveAliens(Direction direction) {

        for (Alien a : getAliveAliens()) {
            a.move(direction);
        }
    }

    private int getAliveNr() {
        int aliveAliens = 0;

        for (Alien a : aliens) {
            if (a == null) {
                continue;
            }

            if (!a.isDead()) {
                aliveAliens++;
            }
        }
        return aliveAliens;
    }
}
