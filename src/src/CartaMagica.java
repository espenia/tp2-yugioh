package src;

public abstract class CartaMagica extends CartaDeUtilidad{

	public CartaMagica(String nombreDeCarta) {
		super(nombreDeCarta);
	}
    
    public abstract void activarEfecto(Jugador jugador);

}
