package src;

import java.util.List;

public class Jugador {
	public int puntosDeVida;
	public Mano mano;
	private List<Carta> cementerio;
	private Lado lado;


	public Jugador() { //Multiton 2
		this.puntosDeVida = 8000;
		//Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
		//Mazo.draw(5);
	}

	public void posicionarCartaEnLado(CartaMonstruo monstruo,String posicionDeLaCarta,String modoDeLaCarta ) {
		this.lado.jugarCartaMonstruo(monstruo, posicionDeLaCarta,modoDeLaCarta);

	}

	public CartaMonstruo seleccionarCartaDeLaMano(String nombreCarta) {
		return (CartaMonstruo) this.mano.devolverCarta(nombreCarta);
	}


	public CartaMonstruo seleccionarCartaDelCampo(String nombreCarta) {
		return this.lado.seleccionarCartaMonstruo(nombreCarta);
		//return null;
	}

	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}

	public void asignarLado(Lado ladoJugador) {
		lado = ladoJugador;
	}

	public void atacar(CartaMonstruo cartaSeleccionada, Jugador jugador) {
		cartaSeleccionada.atacarA(jugador);
	}

}
