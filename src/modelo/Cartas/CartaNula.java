package modelo.Cartas;

import modelo.CartaMonstruo;

public class CartaNula extends CartaMonstruo {
    private static String nombre = "Carta Nula";
    private static int defensa = 999999;
    private static int ataque = 999999;
    private static int estrellas = 1;



    public CartaNula() {
        super(nombre, defensa, ataque, estrellas);
    }


}
