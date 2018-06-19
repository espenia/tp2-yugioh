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
    public void activarEfecto() {};

    public void activarTrampa(Jugador jugador, CartaMonstruo carta) {
        jugador.aplicarDanioDirecto(carta.getAtaque());
    }
}
