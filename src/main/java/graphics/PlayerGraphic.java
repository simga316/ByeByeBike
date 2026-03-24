package graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Spelargrafiken. Ritar ut spelaren under gameplay.
 */

public class PlayerGraphic extends Graphic {
    // private Image image;



    public PlayerGraphic(double x, double y) {
        super(x, y);

//        try {
//            image = new Image(new FileInputStream("player1L.png"));
//        } catch (FileNotFoundException e) {
//        }
    }

    @Override
    public void drawYourself(GraphicsContext graphicsContext2D) {
        graphicsContext2D.setFill(javafx.scene.paint.Color.BLUE);
        graphicsContext2D.fillRect(getX() - 80, getY() - 60, 50, 50);
    }

}