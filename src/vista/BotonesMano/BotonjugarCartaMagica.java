package vista.BotonesMano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.*;
import modelo.Exceptions.AccionInvalidaEnFaseException;
import vista.ManoDeJugador;
import vista.Tablero;


public class BotonjugarCartaMagica extends Button {

    private final Carta carta;
    private final Jugador jugador;
    private final Tablero tablero;
    private final ManoDeJugador manoDeJugador;

    public BotonjugarCartaMagica(Stage stage, Tablero tablero, ManoDeJugador manoDeJugador, Jugador jugador, Carta carta) {
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;
        this.manoDeJugador = manoDeJugador;

        this.setText("Jugar Carta Magica");
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws AccionInvalidaEnFaseException {
                try {
                    if (carta instanceof CartaMagica){
                        jugador.jugarCartaMagicaEnLado((CartaMagica) carta);
                        new colocarEnEstado(jugador, carta);
                        stage.close();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Tipo De Carta Incorrecta", ButtonType.CLOSE);
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
                manoDeJugador.actualizarMano();//puede que rompa
            }

        });

    }


}

