package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;


import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentation;
import org.academiadecodigo.simplegraphics.graphics.Movable;

/**
 * Created by codecadet on 15/02/16.
 */
public abstract class GameObject {

    Representable representation;
    Direction direction;

    public GameObject(Representable representation){
        this.representation = representation;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public  void setDirection(Direction direction){
        this.direction = direction;
    }

    public void move(Direction direction){

        SimpleGfxRepresentation unit = (SimpleGfxRepresentation) representation;

        switch(direction){
            case UP: unit.move(0,-1);
                break;
            case DOWN: unit.move(0,1);
                break;
            case LEFT: unit.move(-1,0);
                break;
            case RIGHT: unit.move(1,0);
                break;
        }
    }



}
