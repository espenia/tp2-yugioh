package modelo.Cartas;

import modelo.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class AcechadorDelCraneo extends CartaMonstruo {
	private static String nombre = "Acechador Del Craneo";
    private static int defensa = 800;
    private static int ataque = 900;
    private static int estrellas = 3;
    
	public AcechadorDelCraneo() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 0)
			throw new CantidadDeSacrificiosIncorrectaException();

	}
}
