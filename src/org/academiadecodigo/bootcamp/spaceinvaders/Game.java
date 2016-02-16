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
    public static final int NUMBER_OF_ALIENS = 10;
    public static final int DELAY = 200;

    Board board = new Board(672, 768);
    EarthShip earthShip;
    RepresentablesArray aliensRow1;
    RepresentablesArray aliensRow2;
    RepresentablesArray aliensRow3;
    RepresentablesArray aliensRow4;
    RepresentablesArray aliensRow5;


    public void init() {

        board.init();

        RepresentationFactory factory = new SimpleGfxRepresentationFactory();
        earthShip = new EarthShip(factory.getGameObject(GameObjectType.EARTHSHIP, 344, 710));



        aliensRow1 = new RepresentablesArray(NUMBER_OF_ALIENS);
        aliensRow2 = new RepresentablesArray(NUMBER_OF_ALIENS);
        aliensRow3 = new RepresentablesArray(NUMBER_OF_ALIENS);
        aliensRow4 = new RepresentablesArray(NUMBER_OF_ALIENS);
        aliensRow5 = new RepresentablesArray(NUMBER_OF_ALIENS);


        //TODO For dentro do for
        int positioner = 50;
        for (int i = 0; i < NUMBER_OF_ALIENS; i++) {
            aliensRow1.push(factory.getGameObject(GameObjectType.ALIEN, positioner, 100));
            positioner += 60;
        }

        positioner = 50;
        for (int i = 0; i < NUMBER_OF_ALIENS; i++) {
            aliensRow2.push(factory.getGameObject(GameObjectType.ALIEN, positioner, 150));
            positioner += 60;
        }

        positioner = 50;
        for (int i = 0; i < NUMBER_OF_ALIENS; i++) {
            aliensRow3.push(factory.getGameObject(GameObjectType.ALIEN, positioner, 200));
            positioner += 60;
        }

        positioner = 50;
        for (int i = 0; i < NUMBER_OF_ALIENS; i++) {
            aliensRow4.push(factory.getGameObject(GameObjectType.ALIEN, positioner, 250));
            positioner += 60;
        }

        positioner = 50;
        for (int i = 0; i < NUMBER_OF_ALIENS; i++) {
            aliensRow5.push(factory.getGameObject(GameObjectType.ALIEN, positioner, 300));
            positioner += 60;
        }


    }

    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(DELAY);
            //TODO Move all aliens;
            //TODO Check Collider


            if (earthShip.hasShot()) {
                earthShip.shoot();
            }



            // quando o tiro acerta em algum inimigo, ou sai do mapa -- earthship.doneShooting();
        }
    }


}



