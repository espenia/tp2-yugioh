package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Carta;
import modelo.Jugador;

public class BotonCartaEnManoHandler implements EventHandler<ActionEvent>{

    private final Datos datos;
    private Jugador jugador;
    private Carta carta;

    public BotonCartaEnManoHandler(Jugador jugador, Carta carta,Datos datos) {//opciones posibles que puede realizar la carta
        this.carta = carta;
        this.jugador = jugador;
        this.datos = datos;
    }

    @Override
    public void handle(ActionEvent event) {
        //popup de accion

        datos.mostrarDatosDeCarta(carta);

    }
}
