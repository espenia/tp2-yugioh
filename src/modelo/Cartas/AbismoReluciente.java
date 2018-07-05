package modelo.Cartas;

import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class AbismoReluciente extends CartaMonstruo {
	private static String nombre = "Abismo Reluciente";
    private static int defensa = 1600;
    private static int ataque = 1800;
    private static int estrellas = 4;
    
	public AbismoReluciente() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 0)
			throw new CantidadDeSacrificiosIncorrectaException();

	}
	
}
