package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.Game;
import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentationFactory;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.AliensArray;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 15/02/16.
 */
public class EarthShip extends GameObject implements KeyboardHandler {


    private int speed;
    private boolean shot;
    private SimpleGfxRepresentationFactory factory;
    private StingRay stingRay;

    /**
     * Constructor
     * @param representation -
     */
    public EarthShip(Representable representation){
        super(representation);
        speed = Game.GAME_SPEED + 20;
        setKeyboard();
        factory = new SimpleGfxRepresentationFactory();
    }


    private void setKeyboard() {
        Keyboard k = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);

        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(shoot);


    }

    public void moveRight(){
        for (int i = 0; i < speed ; i++) {
            this.move(Direction.RIGHT);
        }
    }

    public void moveLeft(){
        for (int i = 0; i < speed ; i++) {
            this.move(Direction.LEFT);
        }
    }

    public void shoot(){

        stingRay = new StingRay (factory.getGameObject(GameObjectType.STINGRAY, getRepresentation().getX(), getRepresentation().getY()));
        stingRay.moveUp();
        System.out.println("done shooting");
        if (hasShot()) {
            return;
        }
        }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;

            case KeyboardEvent.KEY_SPACE:
                //shoot();
                shot = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean hasShot() {
        return shot;
    }

    public void doneShooting() {
        shot = false;
    }
}
