package Cartas;

import modelo.CartaMagica;
import modelo.Jugador;
import modelo.Lado;

public class CartaMagicaAgujeroOscuro extends CartaMagica {

	public CartaMagicaAgujeroOscuro(String nombreDeCarta) {
		super(nombreDeCarta);
	}


	@Override
	public void activarEfecto(Lado lado, Lado ladoEnemigo) {
		lado.mandarCastasMonstruosAlCementerio();
		ladoEnemigo.mandarCastasMonstruosAlCementerio();

	}

}
