package modelo.Cartas;

import modelo.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class PieDerechoDeExodia extends CartaMonstruo {
    private static String nombre = "Pie Derecho De Exodia";
    private static int defensa = 300;
    private static int ataque = 200;
    private static int estrellas = 1;

    public PieDerechoDeExodia() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }
}
