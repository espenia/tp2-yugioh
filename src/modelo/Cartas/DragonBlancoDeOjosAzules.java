package modelo.Cartas;

import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class DragonBlancoDeOjosAzules extends CartaMonstruo {

    private static String nombre = "Dragon Blanco De Ojos Azules";
    private static int defensa = 2500;
    private static int ataque = 3000;
    private static int estrellas = 8;



    public DragonBlancoDeOjosAzules() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 2)
            throw new CantidadDeSacrificiosIncorrectaException();

    }
}
