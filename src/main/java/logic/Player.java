package logic;

/**
 * Funktionalitet för spelaren. Innehåller skjut- och rörelsemetoder samt stats som hälsa och skjuthastighet.
 */

import graphics.Main;

public class Player extends Entity{
    private boolean invincible;

    public Player(int x, int y, Model myModel) {
        super(x, y, myModel);
        setX(graphics.Main.programWidth / 2);
        setY(graphics.Main.programHeight - 100);
        setHealthPoints(100);
        setFiringSpeed(20);
        invincible = false;

    }



    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincibleStatus) {
        invincible = invincibleStatus;
    }

    @Override
    public void moveLeft() {
        if (getX() > 0) {
            setX(getX() - 10);
        }
    }
    @Override
    public void moveRight() {
        if (getX() < Main.programWidth- 23) {
            setX(getX() + 10);
        }
    }
    @Override
    public void moveForward() {
        if (getY() > 0) {
            setY(getY() - 10);
        }
    }
    @Override
    public void moveBack() {
        if (getY() < 673) {
            setY(getY() + 10);
        }
    }

    @Override
    public void update() {
        if (getHealthPoints() < 1) {

        }

    }
}