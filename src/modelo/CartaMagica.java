package modelo;

import java.util.List;

public abstract class CartaMagica extends CartaDeUtilidad {

	public CartaMagica(String nombreDeCarta) {
		super(nombreDeCarta);
	}
    
    public void activarEfecto(List<CartaMonstruo> lista, List<CartaMonstruo> lista2) {};

	public void activarTrampa(Jugador jugador, CartaMonstruo carta) {};
}
