package graphics;

/**
 * Ritar den nuvarande "framen". Visar gameplay, håller funktionalitet för knappintryck, alltså alla lyssnare.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.Model;
import logic.Player;
import logic.Thing;

public class Frame extends Canvas {
    private Model myModel;
    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;
    private boolean spacePressed = false;
    private Image level1Bakground;
    private Image level2Bakground;

    public Frame(Model myModel) {
        this.myModel = myModel;

        setHeight(Main.programHeight - 50);
        setWidth(Main.programWidth);

        try {
            level1Bakground = new Image(new FileInputStream("lvl1L.png"));
            level2Bakground = new Image(new FileInputStream("lvl2L.png"));
        } catch (FileNotFoundException e) {
        }


        setFocusTraversable(true);
        requestFocus();

        setOnKeyPressed(pressed -> {
            if (pressed.getCode() == KeyCode.W) {
                wPressed = true;
            }
            if (pressed.getCode() == KeyCode.A) {
                aPressed = true;
            }
            if (pressed.getCode() == KeyCode.S) {
                sPressed = true;
            }
            if (pressed.getCode() == KeyCode.D) {
                dPressed = true;
            }
            if (pressed.getCode() == KeyCode.SPACE) {
                spacePressed = true;
            }
        });

        setOnKeyReleased(pressed -> {
            if (pressed.getCode() == KeyCode.W) {
                wPressed = false;
            }
            if (pressed.getCode() == KeyCode.A) {
                aPressed = false;
            }
            if (pressed.getCode() == KeyCode.S) {
                sPressed = false;
            }
            if (pressed.getCode() == KeyCode.D) {
                dPressed = false;
            }
            if (pressed.getCode() == KeyCode.SPACE) {
                spacePressed = false;
            }
        });
    }


    public void repaint() {
        getGraphicsContext2D().clearRect(0, 0, Main.programWidth, Main.programHeight);

        for(Thing t : myModel.getThings()) {
            if (t instanceof Player) {
                new PlayerGraphic(((Player) t).getX(), ((Player) t).getY()).drawYourself(getGraphicsContext2D());
            }
        }
    }

    public void updateInput() {

        if (wPressed) {
            myModel.getPlayer().moveForward();
        }
        if (aPressed) {
            myModel.getPlayer().moveLeft();
        }
        if (sPressed) {
            myModel.getPlayer().moveBack();
        }
        if (dPressed) {
            myModel.getPlayer().moveRight();
        }
    }
}