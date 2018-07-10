package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Jugador;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private BorderPane pane;

    public BotonJugarEventHandler(Stage stage){
        primaryStage = stage;


    }


    @Override
    public void handle(ActionEvent event) {

        pane = new JuegoScene(new Jugador(),new Jugador(),primaryStage);
        pane.setMinSize(1300, 700);
        pane.setMaxSize(1920,1080);
        Scene gameScene = new Scene(pane);
        primaryStage.setScene(gameScene);
        primaryStage.setFullScreen(false);
        primaryStage.setMaximized(true);
        gameScene.getStylesheets().add("file:src/vista/style.css");

    }
}
