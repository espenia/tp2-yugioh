package src;

import java.util.List;

public class Jugador {
    public int puntosDeVida;
    public Mano mano;
    private List<Carta> cementerio;
	private Campo campo;
    

    public Jugador () { //Multiton 2
    	this.puntosDeVida = 8000;
        //Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
        //Mazo.draw(5);
    }

	public void posicionarCartaEnLado(CartaMonstruo monstruo,String posicionDeLaCarta,String modoDeLaCarta ) {
		this.campo.jugarCartaMonstruo(monstruo,posicionDeLaCarta,modoDeLaCarta);

	}

	public CartaMonstruo seleccionarCartaDeLaMano(String nombreCarta) {
		//return this.mano.devolverCarta(nombreCarta);
		return null;
	}


	public CartaMonstruo seleccionarCartaDelCampo(String nombreCarta) {
		//return this.campo.seleccionarCarta(nombreCarta);
		return null;
	}

	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}

}
