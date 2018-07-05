package modelo.Cartas;

import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class Conedragon extends CartaMonstruo {
	private static String nombre = "ConeDragon";
    private static int defensa = 2900;
    private static int ataque = 2950;
    private static int estrellas = 8;
    
	public Conedragon() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 2)
			throw new CantidadDeSacrificiosIncorrectaException();

	}


}
