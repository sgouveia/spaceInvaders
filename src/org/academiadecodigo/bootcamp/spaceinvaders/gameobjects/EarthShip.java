package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.Game;
import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentationFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 15/02/16.
 */
public class EarthShip extends GameObject implements KeyboardHandler {


    private int speed;
    private Direction direction;
    private boolean shotFired;
    private SimpleGfxRepresentationFactory factory;
    private StingRay stingRay;

    /**
     * Constructor
     *
     * @param representation -
     */
    public EarthShip(Representable representation) {
        super(representation);
        speed = 5;
        setKeyboard();
        factory = new SimpleGfxRepresentationFactory();
    }


    private void setKeyboard() {
        Keyboard k = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        KeyboardEvent leftUp = new KeyboardEvent();
        leftUp.setKey(KeyboardEvent.KEY_LEFT);
        leftUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(leftUp);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);

        KeyboardEvent rightUp = new KeyboardEvent();
        rightUp.setKey(KeyboardEvent.KEY_RIGHT);
        rightUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(rightUp);

        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(shoot);


    }

    public void moveRight() {
        this.move(Direction.RIGHT, speed);
    }

    public void moveLeft() {
        this.move(Direction.LEFT, speed);
    }

    public StingRay getStingRay() {
        return stingRay;
    }

    public void makeShoot() {

        if (shotFired) {
            return;
        }

        int x = getRepresentation().getX() + getRepresentation().getWidth() / 2;
        int y = getRepresentation().getY();
        stingRay = new StingRay(factory.getGameObject(GameObjectType.STINGRAY, x, y));
        shotFired = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                this.direction = Direction.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                this.direction = Direction.RIGHT;
                break;
            case KeyboardEvent.KEY_SPACE:
                makeShoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        this.direction = null;
    }

    public boolean hasShot() {
        return shotFired;
    }

    public void doneShooting() {
        stingRay.getRepresentation().getShape().delete();
        stingRay = null;
        shotFired = false;
    }

    public void move() {

        if (direction == null) {
            return;
        }

        int dx = speed;
        if (direction == Direction.LEFT) {
            dx = -speed;
        }

        getRepresentation().move(dx, 0);
    }

}
