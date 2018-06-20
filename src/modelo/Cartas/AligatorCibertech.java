package modelo.Cartas;

import modelo.CartaMonstruo;

public class AligatorCibertech extends CartaMonstruo {
	private static String nombre = "Acechador Del Craneo";
    private static int defensa = 1600;
    private static int ataque = 2500;
    //private Estado estado;
    private static int estrellas = 5;
    
	public AligatorCibertech() {
		super(nombre, defensa, ataque, estrellas);
	}
}
