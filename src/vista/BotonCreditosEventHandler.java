package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class BotonCreditosEventHandler implements EventHandler<ActionEvent>{


    private  Stage stage;
    private  Aplicacion aplicacion;
    private AudioClip sound;

    public BotonCreditosEventHandler(Stage stage, Aplicacion aplicacion, AudioClip sound){
        this.stage = stage;
        this.aplicacion = aplicacion;
        this.sound = sound;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setTitle("Creditos");


        Image background = new Image("file:src/vista/creditos.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        GridPane gridPane = new GridPane();
        gridPane.setId("pantalla-creditos");
        gridPane.setMinSize(background.getWidth(), background.getHeight());


        gridPane.setPadding(new Insets(10, 10, 10, 10));



        gridPane.setVgap(5);
        gridPane.setHgap(5);


        gridPane.setAlignment(Pos.CENTER);

        Button cancelar = new Button("Cerrar");
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    sound.stop();
                    aplicacion.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        gridPane.add(cancelar,5,130);


        gridPane.setBackground(new Background(imagenDeFondo));
        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add("file:src/vista/style.css");
        stage.setScene(scene);
        stage.show();
    }
}
