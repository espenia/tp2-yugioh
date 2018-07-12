package vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Aplicacion extends Application{

    private Scene scene;
    private AudioClip sound;

    public static void main(String [] args){
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setFullScreen(false);
        primaryStage.setMaximized(true);
        sound = new AudioClip("file:src/vista/audioPrincipal.mp3");
        sound.play();
        sound.setCycleCount(AudioClip.INDEFINITE);
        configurarPantallaInicial(primaryStage);



    }

    public void configurarPantallaInicial(Stage primaryStage) {
        primaryStage.setTitle("Al-Go-OH!");


        Image background = new Image("file:src/vista/fondo5.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);

        GridPane gridPane = new GridPane();
        gridPane.setId("pantalla-principal");
        gridPane.setMinSize(background.getWidth(), background.getHeight());


        gridPane.setPadding(new Insets(10, 10, 10, 10));



        gridPane.setVgap(5);
        gridPane.setHgap(5);


        gridPane.setAlignment(Pos.CENTER);

        Button jugar = new Button();
        Image botonJugarImagen = new Image("file:src/vista/Botonjugar.jpg");
        jugar.setGraphic(new ImageView(botonJugarImagen));
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(primaryStage,this,sound);
        jugar.setOnAction(botonJugarEventHandler);

        Button creditos = new Button();
        Image botonCreditosImagen = new Image("file:src/vista/botonCreditos.jpg");
        creditos.setGraphic(new ImageView(botonCreditosImagen));
        BotonCreditosEventHandler botonCreditosEventHandler = new BotonCreditosEventHandler(primaryStage,this,sound);
        creditos.setOnAction(botonCreditosEventHandler);


        gridPane.add(jugar,5,37);
        gridPane.add(creditos,5,39);


        gridPane.setBackground(new Background(imagenDeFondo));
        scene = new Scene(gridPane);
        scene.getStylesheets().add("file:src/vista/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
