package org.academiadecodigo.bootcamp.spaceinvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public class Board {

    private static final double MARGIN_TOP = 10; // Game border
    private static final double MARGIN_LEFT = 10; // Game border

    public static final int GAME_BORDER = 25; // border inside board

    public static int width; //in pixels
    public static int heigth; // in pixels


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
