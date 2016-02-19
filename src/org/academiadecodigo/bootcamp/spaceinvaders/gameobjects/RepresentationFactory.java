package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

/**
 * Created by Sérgio Gouveia on 16/02/16.
 */
public interface RepresentationFactory {

    /**
     * will set the method for creating new game objects;
     * @param type Alien, Earthship, or Stingray; //Todo: Bonus Alien and Shields;
     * @param x to be adapted in the factory for the correspondent shape;
     * @param y to be adapted in the factory for the correspondent shape;
     * @return new object with attributed shape;
     */
    Representable getGameObject(GameObjectType type, int x, int y);
}
