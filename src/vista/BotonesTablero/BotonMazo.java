package vista.BotonesTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Jugador;
import modelo.Mazo;
import modelo.MazoEstandar;
import vista.Datos;
import vista.JuegoScene;

public class BotonMazo extends Button {


    private final Jugador jugador;
    private final Mazo carta;
    private final JuegoScene juegoScenes;

    public BotonMazo(Jugador jugadorActual, Mazo cartas, JuegoScene juegoScene) {
        jugador = jugadorActual;
        carta = cartas;
        juegoScenes = juegoScene;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);        

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rendirse();
            }
        });


    }

    private void rendirse() {
        Stage nuevoStage = new Stage();
        nuevoStage.initStyle(StageStyle.UNDECORATED);
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(750, 100);
        //gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Quiere Rendirse y Volver Al menu Principal"), 1, 1);
        gridPane.add(rendir(nuevoStage,juegoScenes),1,2);
        gridPane.add(cancelar(nuevoStage),2,2);
        Scene scene = new Scene(gridPane, 300, 100);
        nuevoStage.setScene(scene);
        nuevoStage.showAndWait();
    }

    private Button rendir(Stage nuevoStage, JuegoScene juegoScenes) {
        Button button = new Button("Rendirse");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                juegoScenes.rendirse();
                nuevoStage.close();
            }
        });
        return button;
    }

    private Button cancelar(Stage nuevoStage) {
        Button button = new Button("Cancelar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoStage.close();
            }
        });
        return button;
    }
}
