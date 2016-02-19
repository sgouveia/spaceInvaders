package org.academiadecodigo.bootcamp.spaceinvaders;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.*;
import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentationFactory;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.AliensArray;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.HitChecker;

/**
 * Created by codecadet on 15/02/16.
 */
public class Game {

    //TODO Método para devolver a representação mais à direita e mais à esquerda (getMostRightX)

    public static final int NUMBER_OF_ALIENS = 50;
    public static final int DELAY = 15;

    Board board = new Board(672, 768);
    EarthShip earthShip;
    AliensArray aliens;
    HitChecker hitChecker;


    /**
     * Initializes the board and positions game objects on it;
     */
    public void init() {

        board.init();

        RepresentationFactory factory = new SimpleGfxRepresentationFactory();
        earthShip = new EarthShip(factory.getGameObject(GameObjectType.EARTHSHIP, 344, 710));

        aliens = new AliensArray(NUMBER_OF_ALIENS);

        int positionerX = 50;
        int positionerY = 100;
        for (int i = 0; i < NUMBER_OF_ALIENS / 10; i++) {
            for (int j = 0; j < NUMBER_OF_ALIENS / 5; j++) {

                aliens.push(new Alien(factory.getGameObject(GameObjectType.ALIEN, positionerX, positionerY)));
                positionerX += 60;
            }
            positionerX = 50;
            positionerY += 50;
        }
        hitChecker = new HitChecker(aliens.getAliveAliens(), earthShip);
    }

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

            if (earthShip.hasShot()){
                earthShip.getStingRay().moveUp();
            }

            if (hitChecker.stingRayCollision()) {
                earthShip.doneShooting();
                hitChecker.updateAliveAliens(aliens.getAliveAliens());
            }

            for (Alien a: aliens.getDeadAliens()){
                a.clean();
            }
        }


        // quando o tiro acerta em algum inimigo, ou sai do mapa -- earthship.doneShooting();
    }


}




