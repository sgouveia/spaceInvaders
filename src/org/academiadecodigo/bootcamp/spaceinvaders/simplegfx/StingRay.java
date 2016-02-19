package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Line;

/**
 * Created by Sérgio Gouveia on 16/02/16.
 */
public class StingRay extends SimpleGfxRepresentation {

    /**
     * Constructor for the stingray; will provide a line and color
     *
     * @param x1 start for x
     * @param y1 start for y
     * @param x2 end of x
     * @param y2 end of y
     */
    public StingRay(int x1, int y1, int x2, int y2) {

        super.setShape(new Line(x1, y1, x2, y2));
        this.setColor(Color.WHITE);
    }

}




