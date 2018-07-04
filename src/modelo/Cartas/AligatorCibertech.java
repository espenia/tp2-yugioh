package modelo.Cartas;

import modelo.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class AligatorCibertech extends CartaMonstruo {
	private static String nombre = "Aligator Cibertech";
    private static int defensa = 1600;
    private static int ataque = 2500;
    private static int estrellas = 5;
    
	public AligatorCibertech() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 1)
			throw new CantidadDeSacrificiosIncorrectaException();

	}

}
