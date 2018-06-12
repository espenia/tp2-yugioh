package src;

import java.util.List;

public class Jugador {
    public int lifePoints;
    private int cantidadDeCartasMano;
    private int cantidadDeCartasMazo;
    private int cantidadDeCartasCementerio;
    public Mano mano;
    private Mazo mazo;
    private List<Carta> cementerio;
	private Lado lado;
    

    public Jugador () { //Multiton 2
    	this.lifePoints = 8000;
    	this.cantidadDeCartasMano = 5; // No me acuerdo con cuantas empezas
    	this.cantidadDeCartasMazo = 30;
    	this.cantidadDeCartasCementerio = 0;
    	this.mazo = new Mazo();
        //Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
        //Mazo.draw(5);
    }

	public void posicionarCartaEnLado(Monstruo monstruo) {
		this.lado.agregarCarta(monstruo);
	}

	public Monstruo seleccionarCartaDeLaMano(String nombreCarta) {
		return this.mano.devolverCarta(nombreCarta);
	}

	public Monstruo seleccionarCartaDelCampo(String nombreCarta) {
		return this.lado.seleccionarCarta(nombreCarta);
	}

	public void recibeDanio(int ataque) {
		this.lifePoints = this.lifePoints - ataque;
	}

}
