package Cartas;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;

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
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {



    }

	@Override
	public void activarTrampa(Jugador jugador, CartaMonstruo carta) {
	}
}
