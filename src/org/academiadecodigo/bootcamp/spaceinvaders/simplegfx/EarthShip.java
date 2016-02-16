package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/16.
 */
public class EarthShip extends SimpleGfxRepresentation {

    public EarthShip(int x, int y, String s){
        super.setShape(new Picture(x,y,s));

    }


}
