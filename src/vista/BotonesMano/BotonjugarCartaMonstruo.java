package vista.BotonesMano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Jugador;
import vista.ManoDeJugador;
import vista.Tablero;

public class BotonjugarCartaMonstruo extends Button {


    private Jugador jugador;
    private ManoDeJugador manoDeJugador;
    private Carta carta;
    private Tablero tablero;

    public BotonjugarCartaMonstruo(Stage stage, Tablero tablero, ManoDeJugador manoDeJugador, Jugador jugador, Carta carta) {
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;
        this.manoDeJugador = manoDeJugador;

        this.setText("Jugar Carta Monstruo");
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws AccionInvalidaEnFaseException{
                try {
                    if (carta instanceof CartaMonstruo){
                        jugador.jugarCartaMonstruoEnLado((CartaMonstruo)carta);
                        new colocarEnEstado(jugador,carta);
                        stage.close();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Tipo De Carta Incorrecta",ButtonType.CLOSE);
                        alert.setHeight(40);
                        alert.setWidth(50);
                        alert.showAndWait();
                        if (alert.getResult()==ButtonType.CLOSE)
                            stage.close();
                    }
                }
                catch (AccionInvalidaEnFaseException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Acccion Invalida en Fase Actual",ButtonType.CLOSE);
                    alert.setHeight(40);
                    alert.setWidth(50);
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.CLOSE)
                        stage.close();
                }

                tablero.actualizarTablero();
                manoDeJugador.actualizarMano();
            }

        });

    }

}
