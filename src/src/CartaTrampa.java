package src;

public abstract class CartaTrampa extends CartaDeUtilidad{

	public CartaTrampa(String nombreDeCarta) {
		super(nombreDeCarta);
	}
    
    public abstract void activarEfecto(Jugador jugador);

}