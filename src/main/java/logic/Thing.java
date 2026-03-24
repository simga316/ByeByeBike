package logic;

/**
 * Helper- och superklass för alla logikobjekt. Underlättar att iterera över Things i Model.
 */

public abstract class Thing {
    private double x, y;
    private Model myModel;

    public Thing (double x, double y, Model myModel) {
        this.setX(x);
        this.setY(y);
        this.myModel = myModel;
    }

    public abstract void update();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}