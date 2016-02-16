package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 15/02/16.
 */
public class SimpleGfxRepresentation implements Representable {



    private Shape shape;

    public void setShape(Shape shape){
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

    public void move(int x, int y){
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

}

