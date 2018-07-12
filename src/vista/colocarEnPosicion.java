package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Jugador;

public class colocarEnPosicion {

    private final Jugador jugador;
    private final Carta carta;

    public colocarEnPosicion(Jugador jugador, Carta carta) {
        this.jugador = jugador;
        this.carta = carta;

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(350,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique la accion que desea\n Realizar Con esta Carta"),1,1);
        gridPane.add(posicionDeAtaque(stage),1,2);
        gridPane.add(posicionDeDefensa(stage),2,2);
        Scene scene = new Scene(gridPane,350,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();
    }

    private Button posicionDeDefensa(Stage stage) {
        Button posicionDeDefensa = new Button("Posicion De Defensa");
        posicionDeDefensa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionDefensa((CartaMonstruo) carta);
                stage.close();
            }
        });
        return posicionDeDefensa;
    }

    private Button posicionDeAtaque(Stage stage) {
        Button posicionDeAtaque = new Button("Posicion De Ataque");
        posicionDeAtaque.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionAtaque((CartaMonstruo) carta);
                stage.close();
            }
        });
        return posicionDeAtaque;
    }

}
