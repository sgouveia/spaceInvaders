package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Sérgio Gouveiaon 16/02/16.
 */
public class EarthShip extends SimpleGfxRepresentation {

    /**
     *
     * @param x of the picture
     * @param y of the picture
     * @param s location of the picture
     */
    public EarthShip(int x, int y, String s){
        super.setShape(new Picture(x,y,s));

    }


}
