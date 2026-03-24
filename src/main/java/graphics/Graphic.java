package graphics;

import javafx.scene.canvas.GraphicsContext;

/**
 * Superklass för alla grafiska objekt
 */

public abstract class Graphic {
    private double x, y;

    public Graphic (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void drawYourself(GraphicsContext graphicsContext2D);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}