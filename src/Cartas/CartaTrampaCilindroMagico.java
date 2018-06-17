package Cartas;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;

public class CartaTrampaCilindroMagico extends CartaTrampa {

    public CartaTrampaCilindroMagico(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    public void activarEfecto(Jugador jugador) {};

    public void activarTrampa(Jugador jugador, CartaMonstruo carta) {
        jugador.aplicarDanioDirecto(carta.getAtaque());
    }
}
