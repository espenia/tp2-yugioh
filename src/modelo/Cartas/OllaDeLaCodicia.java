package modelo.Cartas;

import java.util.Stack;

import modelo.Carta;
import modelo.CartaMagica;
import modelo.Lado;

public class OllaDeLaCodicia extends CartaMagica {


    public OllaDeLaCodicia(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {
    	for ( int i = 0 ; i < 2; i++){
            Carta auxiliar = lado.extraerDelMazo();
            lado.obtenerJugador().darCarta(auxiliar);
        }
    }
}
