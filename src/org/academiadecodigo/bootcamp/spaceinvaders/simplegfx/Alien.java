package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/16.
 */
public class Alien extends SimpleGfxRepresentation {

    Picture picture;

    public Alien(int x, int y, String s){
        super.setShape(new Picture(x, y, s));

    }


}
