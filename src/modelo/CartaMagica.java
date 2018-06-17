package modelo;

public abstract class CartaMagica extends CartaDeUtilidad {

	public CartaMagica(String nombreDeCarta) {
		super(nombreDeCarta);
	}
    
    public void activarEfecto(Jugador jugador) {};

	public void activarTrampa(Jugador jugador, CartaMonstruo carta) {};
}
