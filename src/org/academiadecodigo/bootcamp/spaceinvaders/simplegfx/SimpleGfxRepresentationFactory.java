package org.academiadecodigo.bootcamp.spaceinvaders.simplegfx;

import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.GameObjectType;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.Representable;
import org.academiadecodigo.bootcamp.spaceinvaders.gameobjects.RepresentationFactory;

/**
 * Created by Sérgio Gouveia on 16/02/16.
 */
public class SimpleGfxRepresentationFactory implements RepresentationFactory {

    /**
     *
     * @param type Alien, Earthship, or Stingray; //Todo: Bonus Alien and Shields;
     * @param x to be adapted in the factory for the correspondent shape;
     * @param y to be adapted in the factory for the correspondent shape;
     * @return
     */
    @Override
    public Representable getGameObject(GameObjectType type, int x, int y) {

        Representable shape = null;

        switch(type){
            case EARTHSHIP: shape = new EarthShip(x, y, "resources/earthship.png");
                break;
            case ALIEN: shape = new Alien(x, y, "resources/alien01.png");
                break;
            case STINGRAY: shape = new StingRay(x,y,x,y-20);
                break;

        }

        return shape;
    }
}
