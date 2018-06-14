package src;

public abstract class CartaMagica extends CartaDeUtilidad{

	public CartaMagica(String nombreDeCarta) {
		super(nombreDeCarta);
	}
    
    public void activarEfecto(Jugador jugador) {};

	public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta) {
		lado.jugarCartaMagica(this, posicionDeLaCarta);
	}

	public void activarTrampa(Jugador jugador, CartaMonstruo carta) {};
}
