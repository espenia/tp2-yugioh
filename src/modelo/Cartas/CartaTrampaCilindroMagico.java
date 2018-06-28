package modelo.Cartas;

import java.util.List;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class CartaTrampaCilindroMagico extends CartaTrampa {

    public CartaTrampaCilindroMagico(String nombreDeCarta) {
        super(nombreDeCarta);

    }

    @Override
    public boolean activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
        carta.atacarA(jugador.ladoEnemigo.obtenerJugador());
        return true;
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
	}

	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, boolean fusion) {
		
	}
}
