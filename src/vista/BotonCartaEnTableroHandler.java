package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.Jugador;

public class BotonCartaEnTableroHandler implements EventHandler<ActionEvent>{

    private  Tablero tablero;
    private Jugador jugador;
    private Carta carta;
	
	public BotonCartaEnTableroHandler(Jugador jugador, Carta carta, Tablero tablero) {//opciones posibles que puede realizar la carta
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;
    }
	
	@Override
    public void handle(ActionEvent event) {
        //popup de accion
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(1000,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique a quien quiere atacar"),1,1);
        gridPane.add(new BotonAtacarJugadorEnemigo(stage, jugador, carta,tablero),1,2);
        Scene scene = new Scene(gridPane,1000,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();
    }

}
