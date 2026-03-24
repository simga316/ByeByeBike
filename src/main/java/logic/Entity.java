package logic;


/**
 * Superklass för alla fiender och spelaren. Styr rörelser.
 */

public abstract class Entity extends Thing {
    private double x, y;
    private int healthPoints;
    private double firingSpeed;


    public Entity(int x, int y, Model myModel) {
        super(x, y, myModel);


    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public double getFiringSpeed() {
        return firingSpeed;
    }

    public void setFiringSpeed(double firingSpeed) {
        this.firingSpeed = firingSpeed;
    }

    public void moveLeft() {
        setX(getX() - 10);
    }
    public void moveRight() {
        setX(getX() + 10);
    }
    public void moveForward() {
        setY(getY() - 10);
    }
    public void moveBack() {
        setY(getY() + 10);
    }
}