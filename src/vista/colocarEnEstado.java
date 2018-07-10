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
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Jugador;


public class colocarEnEstado {

    private  Carta carta;
    private  Jugador jugador;

    public colocarEnEstado(Jugador jugador, Carta carta){
        this.jugador = jugador;
        this.carta = carta;
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(1000,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique la accion que desea Realizar Con esta Carta"),1,1);
        gridPane.add(bocaAbajo(stage),1,2);
        gridPane.add(bocaArriba(stage),2,2);
        Scene scene = new Scene(gridPane,1000,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();
    }

    private Button bocaArriba(Stage stage) {
        Button bocaArriba = new Button("Estado Boca Arriba");
        bocaArriba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnEstadoBocaArriba(carta);
                if (carta instanceof CartaMonstruo)
                    new colocarEnPosicion(jugador,carta);
                stage.close();
            }
        });
        return bocaArriba;
    }

    private Button bocaAbajo(Stage stage) {
        Button bocaAbajo = new Button("Estado Boca Abajo");
        bocaAbajo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnEstadoBocaAbajo(carta);
                if (carta instanceof CartaMonstruo)
                    new colocarEnPosicion(jugador,carta);
                stage.close();
            }
        });
        return bocaAbajo;
    }



}
