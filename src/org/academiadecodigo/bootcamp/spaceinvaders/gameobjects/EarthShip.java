package org.academiadecodigo.bootcamp.spaceinvaders.gameobjects;

import org.academiadecodigo.bootcamp.spaceinvaders.simplegfx.SimpleGfxRepresentationFactory;
import org.academiadecodigo.bootcamp.spaceinvaders.utils.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by Sérgio Gouveia on 15/02/16.
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
     * @param representation must use factory method;
     *                       creates a new factory for generating stingrays. Not the best cena;
     */
    public EarthShip(Representable representation) {
        super(representation);
        speed = 5;
        setKeyboard();
        factory = new SimpleGfxRepresentationFactory();
    }

    /**
     * Getter
     *
     * @return
     */
    public StingRay getStingRay() {
        return stingRay;
    }

    /**
     * moves in direction by speed;
     */
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

    /**
     * prepares the shoot; doesn't make the stingray move, but sets shotFired to true;
     * the game loop then checks for this flag and fires if true;
     * x and y are the coordinates for the spaceship;
     */
    public void makeShoot() {

        if (shotFired) {
            return;
        }
        int x = getRepresentation().getX() + getRepresentation().getWidth() / 2;
        int y = getRepresentation().getY();
        stingRay = new StingRay(factory.getGameObject(GameObjectType.STINGRAY, x, y));

        shotFired = true;
    }

    /**
     * Getter for shot boolean flag;
     *
     * @return
     */
    public boolean hasShot() {
        return shotFired;
    }

    /**
     * if the stingray gets an alien or if it leaves the screen,
     * the object disappears and the ship may shoot again;
     */
    public void doneShooting() {
        stingRay.getRepresentation().getShape().delete();
        stingRay = null;
        shotFired = false;
    }

    /**
     * sets keyboard events for spaceship - left, right, and shoot;
     */
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

    /**
     * directions only set the direction; space makes shoot, but doesn't fire.
     *
     * @param keyboardEvent
     */
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

    /**
     * stops the movement by setting direction to null.
     *
     * @param keyboardEvent
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        this.direction = null;
    }


}
