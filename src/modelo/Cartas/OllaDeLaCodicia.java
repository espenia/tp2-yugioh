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
    	Stack <Carta> auxiliar = lado.extraerDelMazo(2);
    	for(int i = 0; i < 2; i++)
    		lado.obtenerJugador().darCarta(auxiliar.pop());
    }
}
