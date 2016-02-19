package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public interface Representable {

    /**
     * Getters and Setters;
     *
     * @return
     */
    int getX();

    int getY();

    int getHeight();

    int getWidth();

    //TODO: this getter turns some of the methods in this interface obsolete. Refactor the whole project :(
    Shape getShape();

    /**
     * Moves representation as set by the game objects
     *
     * @param x (delta values for x)
     * @param y (delta values for y)
     */
    void move(int x, int y);

    /**
     * draws shape as set in game objects;
     */
    void draw();

    /**
     * Checks if this shape is merged by another
     *
     * @param centerX
     * @param centerY
     * @return
     */
    boolean contains(int centerX, int centerY);

    /**
     * Sets new center for representation; used when updating shape,
     * so shapes of different sizes may be updated
     *
     * @param centerX
     * @param centerY
     */
    void setCenterXY(int centerX, int centerY);

    /**
     * Replaces shape for a new one;
     *
     * @param shape new shape;
     */
    void updateShape(Shape shape);


}



