package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

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
}
