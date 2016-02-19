package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;


import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentation;

/**
 * Created by codecadet on 15/02/16.
 */
public abstract class GameObject {

    Representable representation;

    public GameObject(Representable representation){
        this.representation = representation;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public void move(Direction direction, int speed){

        SimpleGfxRepresentation unit = (SimpleGfxRepresentation) representation;
        switch(direction){
            case UP: unit.move(0,-speed);
                break;
            case DOWN: unit.move(0,speed);
                break;
            case LEFT: unit.move(-speed,0);
                break;
            case RIGHT: unit.move(speed,0);
                break;
        }
    }
}
