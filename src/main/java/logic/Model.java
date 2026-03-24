package logic;

import java.util.ArrayList;

/**
 * Uppdaterar alla objekt samt håller koll på dem.
 */

public class Model {
    private ArrayList<Thing> things;
    private ArrayList<Thing> waitingThingsAdd;
    private ArrayList<Thing> waitingThingsRemove;
    private Player player;


    public Model() {
        things = new ArrayList<Thing>();
        waitingThingsAdd = new ArrayList<Thing>();
        waitingThingsRemove = new ArrayList<Thing>();
    }

    public void clearThings() {
        for (Thing t : things) {
            if (!(t instanceof Player)) {
                removeThing(t);
            }

        }

    }

    public void removeThing(Thing thing) {
        waitingThingsRemove.add(thing);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    public void addThing(Thing thing) {
        waitingThingsAdd.add(thing);
    }

    public void update() {
        for (Thing t: things) {
            t.update();
        }
        //ser till att inget tas bort från things
        //samtidigt som t.update körs --> ger annars error
        if (!waitingThingsAdd.isEmpty()) {
            things.addAll(waitingThingsAdd);
            waitingThingsAdd.clear();
        }
        if (!waitingThingsRemove.isEmpty()) {
            things.removeAll(waitingThingsRemove);
            waitingThingsRemove.clear();
        }
    }

    public void addPlayer(Player player) {
        this.player = player;
        addThing(player);
    }
}