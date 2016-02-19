package org.academiadecodigo.bootcamp.spaceinvaders.utils;

import org.academiadecodigo.bootcamp.spaceinvaders.Board;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Alien;

/**
 * Created by Sérgio Gouveia on 16/02/16.
 */
public class AliensArray {

    private Alien[] aliens;
    private int nextIndex;

    /**
     * Constructor. Creates array of given size;
     *
     * @param maxSize
     */
    public AliensArray(int maxSize) {
        aliens = new Alien[maxSize];
    }

    /**
     * push method for the primary array, placing new alien in the first null position of the array.
     *
     * @param object
     */
    public void push(Alien object) {

        if (nextIndex == aliens.length) {
            return;
        }
        aliens[nextIndex] = object;
        nextIndex++;

    }

    /**
     * not implemented; pop method for the primary array; will delete last object before null;
     *
     * @return last available alien in the array
     */
    public Alien pop() {
        return aliens[nextIndex--];
    }

    /**
     * Will create a new smaller array from the first one, which only considers alive aliens,
     * using the dead property from the Alien class;
     *
     * @return array of alive aliens
     */
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

    /**
     * Will create a new smaller array from the first one, which only considers dead aliens,
     * using the dead property from the Alien class; it will be mostly used to draw explosions
     * when aliens die.
     *
     * @return array of dead aliens
     */
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


    /**
     * finds which object in the array has the most left x value;
     *
     * @return integer value for x
     */
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

    /**
     * finds which object in the array has the most right x value;
     *
     * @return integer value for x
     */
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

    /**
     * move all alive aliens in the array in the set direction
     *
     * @param direction
     */
    public void moveAliveAliens(Direction direction) {

        for (Alien a : getAliveAliens()) {
            a.move(direction);
        }
    }

    /**
     * gets number of alive aliens, in order to create array of it
     *
     * @return number of alive aliens;
     */
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
