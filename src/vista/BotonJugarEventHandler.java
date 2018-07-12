package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import modelo.Jugador;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private final AudioClip sound;
    private Stage primaryStage;
    private BorderPane pane;
    private Aplicacion aplicacion;

    public BotonJugarEventHandler(Stage stage, Aplicacion aplicacion, AudioClip sound){
        primaryStage = stage;
        this.aplicacion = aplicacion;
        this.sound = sound;


    }


    @Override
    public void handle(ActionEvent event) {
        sound.stop();
        AudioClip newSound = new AudioClip("file:src/vista/audiojuego.mp3");
        newSound.play();
        pane = new JuegoScene(new Jugador(),new Jugador(),primaryStage,aplicacion,newSound);
        pane.setMinSize(1300, 700);
        pane.setMaxSize(1920,1080);
        Scene gameScene = new Scene(pane);
        primaryStage.setScene(gameScene);
        primaryStage.setFullScreen(false);
        primaryStage.setMaximized(true);
        gameScene.getStylesheets().add("file:src/vista/style.css");

    }
}
