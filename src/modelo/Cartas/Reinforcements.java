package modelo.Cartas;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;

public class Reinforcements extends CartaTrampa {

    public Reinforcements(String nombreDeLaCarta) {
        super(nombreDeLaCarta);
    }

    @Override
    public void activarTrampa(Jugador jugador, CartaMonstruo carta) {

    }

    @Override
    public boolean activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
        carta.aplicarBuff(0,400);
        return false;
    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {

    }
}
