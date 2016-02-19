package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 15/02/16.
 */
public class SimpleGfxRepresentation implements Representable {


    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
        shape.draw();
    }

    @Override
    public int getX() {
        return shape.getX();
    }

    @Override
    public int getY() {
        return shape.getY();
    }

    public void move(int x, int y) {
        Movable shape = (Movable) this.shape;
        shape.translate(x, y);
    }

    @Override
    public void draw() {
        shape.draw();
    }

    @Override
    public int getHeight() {
        return shape.getHeight();
    }

    @Override
    public int getWidth() {
        return shape.getWidth();
    }

    @Override
    public boolean contains(int x, int y) {
        return  x > getX() && x < getRightX() &&
                y > getY() && y < getBottomY();
    }

    public void setColor(Color color) {
        Colorable shape = (Colorable) this.shape;
        shape.setColor(color);
    }

    private int getRightX() {
        return getX() + getWidth();
    }

    private int getBottomY() {
        return getY() + getHeight();
    }

    @Override
    public void setCenterXY(int x, int y){
        int dX = (x-getWidth()/2)-getX();
        int dY = (y-getHeight()/2)-getY();

        move(dX, dY);
    }

    @Override
    public void updateShape(Shape shape) {
        int centerX = getX() + getWidth()/2;
        int centerY = getY() + getHeight()/2;

        this.shape.delete();
        this.shape = shape;
        draw();
        setCenterXY(centerX, centerY);

    }

    @Override
    public Shape getShape() {
        return shape;
    }


}



