package graphics;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Model;
import logic.Player;

/**
 * Huvudklassen som instansierar spelet, alla scener och byter mellan dem.
 */

public class Main extends Application {

    public static int programWidth = 1280;
    public static int programHeight = 720;

    private HashMap<String, Scene> scenes;
    private Scene currentScene;
    private Stage primaryStage;


    @Override
    public void start(Stage arg0) throws Exception {
        scenes = new HashMap<>();
        Model myModel = new Model();
        myModel.addPlayer(new Player(100, 100, myModel));

        primaryStage = new Stage();
        primaryStage.setHeight(programHeight);
        primaryStage.setWidth(programWidth);
        primaryStage.setTitle("ByeByeBikes");

        GameView myGameView = new GameView(myModel, this);
        MenuView myMenuView = new MenuView();

        Scene gameScene = new Scene(myGameView);
        Scene menuScene = new Scene(myMenuView);

        scenes.put("gameScene", gameScene);
        scenes.put("menuScene", menuScene);

        primaryStage.setScene(gameScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

    public void changeScene(String sceneName) {
        currentScene = scenes.get(sceneName);
        primaryStage.setScene(currentScene);

    }
}