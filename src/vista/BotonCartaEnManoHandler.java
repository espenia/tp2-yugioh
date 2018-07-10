package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Jugador;

public class BotonCartaEnManoHandler implements EventHandler<ActionEvent>{

    private  ManoDeJugador manoDeJugador;
    private Datos datos;
    private Jugador jugador;
    private Carta carta;
    private Tablero tablero;

    public BotonCartaEnManoHandler(Jugador jugador, Carta carta, Datos datos, Tablero tablero, ManoDeJugador manoDeJugador) {//opciones posibles que puede realizar la carta
        this.carta = carta;
        this.jugador = jugador;
        this.datos = datos;
        this.tablero = tablero;
        this.manoDeJugador = manoDeJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        //popup de accion
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(200,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new TextField("Indique la accion que desea Realizar Con esta Carta"),1,1);
        gridPane.add(new BotonjugarCartaMonstruo(tablero,manoDeJugador,jugador,carta),2,1);
        //hBox.getChildren().add(new BotonjugarCartaMagica(tablero,manoDeJugador,jugador,carta));
        Scene scene = new Scene(gridPane,200,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.show();
        datos.mostrarDatosDeCarta(carta);

    }

}
