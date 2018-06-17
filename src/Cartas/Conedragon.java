package Cartas;

import modelo.CartaMonstruo;

public class Conedragon extends CartaMonstruo {
	private static String nombre = "Acechador Del Craneo";
    private static int defensa = 2900;
    private static int ataque = 2950;
    //private Estado estado;
    private static int estrellas = 8;
    
	public Conedragon() {
		super(nombre, defensa, ataque, estrellas);
	}

}
