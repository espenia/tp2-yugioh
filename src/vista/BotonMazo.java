package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.Jugador;
import modelo.Mazo;
import modelo.MazoEstandar;

public class BotonMazo extends Button {


    private final Jugador jugador;
    private final Mazo carta;
    private final Datos dato;

    public BotonMazo(Jugador jugadorActual, Mazo cartas, Datos datos) {
        jugador = jugadorActual;
        carta = cartas;
        dato = datos;

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //dato.mostrarDatosDeCarta(carta);
            }
        });


    }
}
