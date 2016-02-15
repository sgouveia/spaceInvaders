import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 15/02/16.
 */
public class Board {

    private static final double MARGIN_TOP = 10;
    private static final double MARGIN_LEFT = 10;

    private int width;
    private int heigth;

    public Board(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
    }

    public void init(){
        Rectangle board = new Rectangle(MARGIN_LEFT, MARGIN_TOP, MARGIN_LEFT + width, MARGIN_TOP + heigth);
        board.setColor(Color.BLACK);
        board.fill();
    }
}
