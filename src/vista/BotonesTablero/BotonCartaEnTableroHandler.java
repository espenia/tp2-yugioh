package vista.BotonesTablero;

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
import modelo.Cartas.MonstruoNulo;
import modelo.Jugador;
import vista.Datos;
import vista.JuegoScene;
import vista.Tablero;

public class BotonCartaEnTableroHandler implements EventHandler<ActionEvent>{

    private JuegoScene juegoScene;
    private Datos datos;
    private Tablero tablero;
    private Jugador jugador;
    private Carta carta;
	
	public BotonCartaEnTableroHandler(Jugador jugador, Carta carta, Tablero tablero, Datos dato, JuegoScene juegoScene) {//opciones posibles que puede realizar la carta
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;
        this.datos = dato;
        this.juegoScene = juegoScene;
    }
	
	@Override
    public void handle(ActionEvent event) {
	    datos.mostrarDatosDeCarta(carta);
        if (!(carta instanceof MonstruoNulo)){
            Stage stage = new Stage();
            GridPane gridPane = new GridPane();
            gridPane.setMinSize(200,100 );
            gridPane.setPadding(new Insets(10, 10, 10, 10));
            gridPane.setVgap(5);
            gridPane.setHgap(5);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.add(new Text("Indique a quien quiere atacar"),1,1);
            gridPane.add(new BotonAtacarJugadorEnemigo(stage, jugador, carta,tablero,juegoScene),1,2);
            gridPane.add(new BotonAtacarMonstruoEnemigo(stage, jugador, carta,tablero,juegoScene),2,2);
            gridPane.add(cancelar(stage),3,2);
            Scene scene = new Scene(gridPane,400,100);
            stage.setTitle("Accion");
            stage.setScene(scene);
            stage.showAndWait();
            juegoScene.configurarPanel();
        }
    }

    private Button cancelar(Stage stage) {
        Button cancelar = new Button("Cancelar");
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
        return cancelar;
    }

}
