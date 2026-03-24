package graphics;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Model;


/**
 * Har animationtimer, som sätter spelets fps och hur ofta det tickar
 */

public class GameView extends VBox {

    private Frame myFrame;
    // private Model myModel;
    // private BottomPanel myBottomPanel;

    public GameView (Model myModel, Main myMain) {
        final double targetFps = 50.0;
        final double nanoPerUpdate = 1000000000.0 / targetFps;
        // myBottomPanel = new BottomPanel(myMain.getMyGame());

        this.myFrame = new Frame(myModel);
        getChildren().add(myFrame);
        // getChildren().add(myBottomPanel);

        new AnimationTimer() {
            long lastUpdate = 0;
            public void handle(long now) {
                if ((now - lastUpdate) > nanoPerUpdate) {
                    myFrame.updateInput();
                    myModel.update();
                    myFrame.repaint();
                    // myBottomPanel.update();
                    lastUpdate = now;
                }
            }
        }.start();
    }

}