package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Line;

/**
 * Created by codecadet on 16/02/16.
 */
public class StingRay extends SimpleGfxRepresentation {


    public StingRay(int x1, int y1, int x2, int y2) {

        super.setShape(new Line(x1, y1, x2, y2));
        this.setColor(Color.WHITE);
    }

}




