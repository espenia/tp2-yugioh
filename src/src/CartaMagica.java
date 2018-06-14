package src;

public abstract class CartaMagica extends CartaDeUtilidad{

	public CartaMagica(String nombreDeCarta) {
		super(nombreDeCarta);
	}
    
    public abstract void activarEfecto(Jugador jugador);

	public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta) {
		lado.jugarCartaMagica(this, posicionDeLaCarta);
	}
}
