package org.academiadecodigo.bootcamp.spaceinvaders;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.*;
import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentationFactory;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.AliensArray;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.Direction;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.HitChecker;

/**
 * Created by Sérgio Gouveia on 15/02/16.
 */
public class Game {

    public static final int NUMBER_OF_ALIENS = 50; // number of regular aliens;
    public static final int DELAY = 15; //miliseconds;

    Board board = new Board(672, 768);
    EarthShip earthShip;
    AliensArray aliens;
    HitChecker hitChecker;

    /**
     * Initializes the board and positions game objects on it;
     * Creates new object factory, new hitChecker and array of Aliens;
     */

    public void init() {

        board.init();

        RepresentationFactory factory = new SimpleGfxRepresentationFactory();

        earthShip = new EarthShip(factory.getGameObject(GameObjectType.EARTHSHIP, 344, 710));

        aliens = new AliensArray(NUMBER_OF_ALIENS);

        //places 10 aliens on each row, for 5 columns;
        int positionerX = 50;
        int positionerY = 100;
        for (int i = 0; i < NUMBER_OF_ALIENS / 10; i++) {
            for (int j = 0; j < NUMBER_OF_ALIENS / 5; j++) {

                aliens.push(new Alien(factory.getGameObject(GameObjectType.ALIEN, positionerX, positionerY)));
                positionerX += 55;
            }

            positionerX = 50;
            positionerY += 50;
        }

        hitChecker = new HitChecker(aliens.getAliveAliens(), earthShip);
    }

    /**
     * Starts the game loop with a thread sleep, performing a series of checks on each turn
     * - Sets aliens' direction to right. They always start going right.
     * - Makes the earthship move, waiting for keyboard events.
     * - Checks for the most left x of the aliens; when it gets to the border, changes direction.
     * - Does the same for the most right x.
     * - Move all aliens in the direction set in the two checks above.
     * - Checks for flags from the earthship to check if a shot has been activated; if so, launches the stingray.
     * - Checks for hits between stingray and alien ships; If hit, updates image of the alien, replacing it with
     * an image of an explosion;
     * - Cleans the explosion image from screen.
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        Direction alienDirection = Direction.RIGHT;

        while (true) {
            Thread.sleep(DELAY);

            earthShip.move();

            if (aliens.getLeftX() <= Board.GAME_BORDER) {
                alienDirection = Direction.RIGHT;
            } else if (aliens.getRightX() >= Board.width - Board.GAME_BORDER) {
                alienDirection = Direction.LEFT;
            }

            aliens.moveAliveAliens(alienDirection);

            if (earthShip.hasShot()) {
                earthShip.getStingRay().moveUp();
            }

            if (hitChecker.stingRayCollision()) {
                earthShip.doneShooting();
                hitChecker.updateAliveAliens(aliens.getAliveAliens());
            }

            for (Alien a : aliens.getDeadAliens()) {
                a.clean();
            }
        }
    }
}




