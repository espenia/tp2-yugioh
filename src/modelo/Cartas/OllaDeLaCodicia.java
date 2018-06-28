package modelo.Cartas;

import java.util.List;

import modelo.Carta;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class OllaDeLaCodicia extends CartaMagica {


    public OllaDeLaCodicia(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, boolean fusion) {
    	for ( int i = 0 ; i < 2; i++){
            Carta auxiliar = mazo.extraerCarta();
            jugador.darCarta(auxiliar);
        }
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
