package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Sérgio Gouveia on 16/02/16.
 */
public class Alien extends SimpleGfxRepresentation {

    /**
     * Constructor
     * @param x of the image;
     * @param y of the image;
     * @param s location of picture
     */
    public Alien(int x, int y, String s){
        super.setShape(new Picture(x, y, s));
    }


}
