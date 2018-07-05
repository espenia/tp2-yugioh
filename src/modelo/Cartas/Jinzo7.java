package modelo.Cartas;

import modelo.*;

import java.util.List;

public class Jinzo7 extends CartaMonstruo {
    private static String nombre = "Jinzo #7";
    private static int defensa = 400;
    private static int ataque = 500;
    private static int estrellas = 2;

    public Jinzo7() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion, Jugador enemigo) {
        atacarA(enemigo);

    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }
}
