package modelo.Cartas;

import java.util.List;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Fusion;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class CartaTrampaCilindroMagico extends CartaTrampa {

    public CartaTrampaCilindroMagico() {
        super("CilindroMagico");

    }

    @Override
    public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
        jugador.notificarDanioAlEnemigo(carta.getAtaque());
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
	}

	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion, Jugador enemigo) {
		
	}
}
