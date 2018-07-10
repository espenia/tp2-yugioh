package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaDeCampo;
import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Jugador;

public class BotonjugarCartaDeCampo extends Button {
    public BotonjugarCartaDeCampo(Stage stage, Tablero tablero, ManoDeJugador manoDeJugador, Jugador jugador, Carta carta) {

        this.setText("Jugar Carta De Campo");

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws AccionInvalidaEnFaseException {
                try {
                    if (carta instanceof CartaDeCampo){
                        jugador.colocarCartaDeCampo((CartaDeCampo) carta);
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
                manoDeJugador.actualizarMano();
            }

        });

    }
}
