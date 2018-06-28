package modelo.Cartas;

import java.util.List;

import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Fusion;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class CartaMagicaAgujeroOscuro extends CartaMagica {

	public CartaMagicaAgujeroOscuro() {
		super("AgujeroOscuro");
	}


	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion) {
		for(CartaMonstruo actual: monstruosAliados) {
			actual.estaMuerta();
		}
		for(CartaMonstruo actual: monstruosEnemigos) {
			actual.estaMuerta();
		}
	}


	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		// TODO Auto-generated method stub
		
	}

}
