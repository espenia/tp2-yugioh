package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class BarraDeMenu extends MenuBar {

    private AudioClip sound;

    public BarraDeMenu(Stage primaryStage, Aplicacion aplication){
        sound = new AudioClip("file:src/vista/audiojuego.mp3");
        Menu menuFile = new Menu("File");
        MenuItem pantallaCompleta = new MenuItem("Pantalla Completa");
        MenuItem volverAjugar = new MenuItem("Volver a Jugar");
        MenuItem salir = new MenuItem("Salir");
        
        pantallaCompleta.setOnAction(fullAction(primaryStage));
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(primaryStage, aplication, sound);
        volverAjugar.setOnAction(botonJugarEventHandler);
        salir.setOnAction(quitAction());
        menuFile.getItems().add(pantallaCompleta);
        menuFile.getItems().add(volverAjugar);
        menuFile.getItems().add(salir);
        this.getMenus().addAll(menuFile);

    }

    private EventHandler<ActionEvent> fullAction(Stage primaryStage){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	primaryStage.setMaximized(false);
            	primaryStage.setMaximized(true);
            }
        };
    }

    private EventHandler<ActionEvent> quitAction(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Esta Seguro que Quiere Salir?", ButtonType.YES, ButtonType.NO);
                alert.getDialogPane().setMaxHeight(5);
                alert.getDialogPane().setMaxWidth(5);
                alert.showAndWait();
                if (alert.getResult()==ButtonType.YES)
                    System.exit(0);
            }
        };
    }
}
