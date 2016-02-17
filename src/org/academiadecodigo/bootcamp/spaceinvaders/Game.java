package org.academiadecodigo.bootcamp.spaceinvaders;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.*;
import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentationFactory;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.RepresentablesArray;

/**
 * Created by codecadet on 15/02/16.
 */
public class Game {

    //TODO Método para devolver a representação mais à direita e mais à esquerda (getMostRightX)

    public static final int GAME_SPEED = 20;
    public static final int NUMBER_OF_ALIENS = 50;
    public static final int DELAY = 200;

    Board board = new Board(672, 768);
    EarthShip earthShip;
    RepresentablesArray aliens;


    /**
     * Initializes the board and positions game objects on it;
     */
    public void init() {

        board.init();

        RepresentationFactory factory = new SimpleGfxRepresentationFactory();
        earthShip = new EarthShip(factory.getGameObject(GameObjectType.EARTHSHIP, 344, 710));

        aliens = new RepresentablesArray(NUMBER_OF_ALIENS);

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
    }

    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(DELAY);
            //TODO Move all aliens;
            //TODO Check Collider

            for (int i = 0; i < aliens.getAliens().length; i++) {
                aliens.getAliens()[i].moveRight();
            }

            if (earthShip.hasShot()) {
                earthShip.shoot();
            }


            // quando o tiro acerta em algum inimigo, ou sai do mapa -- earthship.doneShooting();
        }
    }

    private void getMostRightX(){

    }

}



