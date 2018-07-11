package modelo;

public abstract class CartaTrampa extends CartaDeUtilidad {


	private EstadoDeCarta estadoDeCarta;

	public CartaTrampa(String nombreDeCarta) {
		super(nombreDeCarta);
		estadoDeCarta = new EstadoBocaAbajo();
	}

	public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
		estadoDeCarta = new EstadoBocaArriba();
	}
}