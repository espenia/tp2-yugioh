package modelo.Cartas;

import java.util.List;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class Reinforcements extends CartaTrampa {

    public Reinforcements(String nombreDeLaCarta) {
        super(nombreDeLaCarta);
    }

    @Override
    public void activarTrampa(Lado lado, Lado ladoEnemigo) {
    }

    @Override
    public boolean activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
    	carta.aplicarBuff(0,400);
    	return false;
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, boolean fusion) {

    }
}
