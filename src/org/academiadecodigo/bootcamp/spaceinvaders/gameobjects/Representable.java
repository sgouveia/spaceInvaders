package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 15/02/16.
 */
public interface Representable {

    public int getX();

    public int getY();

    public void move(int x, int y);

    public void draw();

    public int getHeight();

    public int getWidth();

    public boolean contains(int x, int y);

    public void setCenterXY(int x, int y);

    public void updateShape(Shape shape);

    public Shape getShape();

}



