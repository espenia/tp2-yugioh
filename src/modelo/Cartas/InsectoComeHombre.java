package modelo.Cartas;

import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class InsectoComeHombre extends CartaMonstruo {

    private static String nombre = "Insecto Come-Hombre";
    private static int defensa = 600;
    private static int ataque = 450;
    private static int estrellas = 2;



    public InsectoComeHombre() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void activarEfectoAlRecibirAtaque(CartaMonstruo cartaMonstruo){
        cartaMonstruo.estaMuerta();

    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }
}
