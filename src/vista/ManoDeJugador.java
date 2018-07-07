package vista;

import javafx.scene.layout.HBox;
import modelo.Carta;
import modelo.Jugador;
import modelo.Mano;



public class ManoDeJugador extends HBox{//cartas de la mano del jugador actual

    private Jugador jugador;
    private Mano mano;

    public ManoDeJugador(Jugador jugador){
        this.jugador = jugador;
        mano = jugador.devolverMano();
    }




}
