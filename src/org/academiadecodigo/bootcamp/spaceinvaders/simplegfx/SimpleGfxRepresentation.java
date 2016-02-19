package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public class SimpleGfxRepresentation implements Representable {


    private Shape shape;


    /**
     * Getters and Setters;
     */

    @Override
    public int getX() {
        return shape.getX();
    }

    @Override
    public int getY() {
        return shape.getY();
    }

    @Override
    public int getHeight() {
        return shape.getHeight();
    }

    @Override
    public int getWidth() {
        return shape.getWidth();
    }

    private int getRightX() {
        return getX() + getWidth();
    }

    private int getBottomY() {
        return getY() + getHeight();
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    /**
     * to be used in the representation constructors.
     *
     * @param shape
     */
    public void setShape(Shape shape) {
        this.shape = shape;
        shape.draw();
    }

    public void setColor(Color color) {
        Colorable shape = (Colorable) this.shape;
        shape.setColor(color);
    }

    /**
     * will translate shape to the center of another shape;
     * used in explosions of aliens to update image;
     *
     * @param centerX
     * @param centerY
     */
    @Override
    public void setCenterXY(int centerX, int centerY) {
        int dX = (centerX - getWidth() / 2) - getX();
        int dY = (centerY - getHeight() / 2) - getY();

        move(dX, dY);
    }

    /**
     * receives delta values from object to translate to new position;
     *
     * @param x (delta values for x)
     * @param y (delta values for y)
     */
    public void move(int x, int y) {
        Movable shape = (Movable) this.shape;
        shape.translate(x, y);
    }

    /**
     * draws shape;
     */
    @Override
    public void draw() {
        shape.draw();
    }

    /**
     * checks if two given shapes are merging;
     *
     * @param centerX
     * @param centerY
     * @return
     */
    @Override
    public boolean contains(int centerX, int centerY) {
        return centerX > getX() && centerX < getRightX() &&
                centerY > getY() && centerY < getBottomY();
    }


    /**
     * Will update shape to new format placing it in the center of the old shape;
     *
     * @param shape new shape;
     */
    @Override
    public void updateShape(Shape shape) {
        int centerX = getX() + getWidth() / 2;
        int centerY = getY() + getHeight() / 2;

        this.shape.delete();
        this.shape = shape;
        draw();
        setCenterXY(centerX, centerY);

    }


}



