package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

/**
 * Created by codecadet on 16/02/16.
 */
public interface RepresentationFactory {

    Representable getGameObject(GameObjectType type, int x, int y);


}
