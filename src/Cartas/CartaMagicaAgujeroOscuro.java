package Cartas;

import modelo.CartaMagica;
import modelo.Jugador;
import modelo.Lado;

public class CartaMagicaAgujeroOscuro extends CartaMagica {

	public CartaMagicaAgujeroOscuro(String nombreDeCarta) {
		super(nombreDeCarta);
	}

	@Override
	public void activarEfecto(Jugador jugador) {
		Lado lado = jugador.getLado();
		Lado ladoEnemigo = jugador.getLadoEnemigo(); 
		lado.mandarCastasMonstruosAlCementerio();
		ladoEnemigo.mandarCastasMonstruosAlCementerio();
	}

}
