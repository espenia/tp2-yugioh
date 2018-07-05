package modelo.Cartas;

import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class BrazoIzquierdoDeExodia extends CartaMonstruo {
    private static String nombre = "Brazo Izquierdo De Exodia";
    private static int defensa = 300;
    private static int ataque = 200;
    private static int estrellas = 1;

    public BrazoIzquierdoDeExodia() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }

}
