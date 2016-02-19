package org.academiadecodigo.bootcamp.spaceinvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 15/02/16.
 */
public class Board {

    private static final double MARGIN_TOP = 10;
    private static final double MARGIN_LEFT = 10;

    public static final int GAME_BORDER = 20;

    public static int width;
    public static int heigth;


    /**
     * Constructor
     * @param width in pixels
     * @param heigth in pixels
     */
    public Board(int width, int heigth) {
        Board.width = width;
        Board.heigth = heigth;
    }

    /**
     * Initializes the game board
     */
    public void init(){
        Rectangle board = new Rectangle(MARGIN_LEFT, MARGIN_TOP, MARGIN_LEFT + width, MARGIN_TOP + heigth);
        board.setColor(Color.BLACK);
        board.fill();
    }
}
