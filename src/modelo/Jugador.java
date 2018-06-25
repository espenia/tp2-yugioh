package modelo;

import java.util.Stack;

public class Jugador {
	private int puntosDeVida;
	private Mano mano;
	public Lado ladoEnemigo;
	private Lado lado;


	public Jugador() { //Multiton 2
		this.puntosDeVida = 8000;
		mano = new Mano();
	}

	public void asignarLados(Lado lado, Lado ladoEnemigo){
        this.lado = lado;
        this.ladoEnemigo = ladoEnemigo;
    }

	public void jugarCartaMonstruoEnLado(String carta ) {// Excepciones incorrecta cantidad de sacrificios.
		CartaMonstruo unaCarta = (CartaMonstruo) seleccionarCartaDeLaMano(carta);
		this.lado.jugarCartaMonstruo(unaCarta);

	}

	public void jugarCartaMagicaEnLado(String carta) {
		CartaMagica unaCarta = (CartaMagica) seleccionarCartaDeLaMano(carta);
		this.lado.jugarCartaMagica(unaCarta);

	}

	public void jugarCartaTrampaEnLado(String carta) {
		CartaTrampa unaCarta = (CartaTrampa) seleccionarCartaDeLaMano(carta);
		this.lado.jugarCartaTrampa(unaCarta,lado,ladoEnemigo);

	}


	public void jugarCartaEnLadoConUnSacrificio(String monstruo, String sacrificio){
		CartaMonstruo unaCarta = (CartaMonstruo) seleccionarCartaDeLaMano(monstruo);
		seleccionarCartaMonstruoDeMiLado(sacrificio).estaMuerta();
		this.lado.jugarCartaMonstruo(unaCarta);
	}

	public void jugarCartaEnLadoConDosSacrificio(String monstruo, String segundoSacrificio, String primerSacrificio){
		CartaMonstruo unaCarta = (CartaMonstruo) seleccionarCartaDeLaMano(monstruo);
		seleccionarCartaMonstruoDeMiLado(primerSacrificio).estaMuerta();
		seleccionarCartaMonstruoDeMiLado(segundoSacrificio).estaMuerta();
		this.lado.jugarCartaMonstruo(unaCarta);
	}

	public void jugarCartaEnLadoConTresSacrificio(String monstruo, String primerSacrificio, String segundoSacrificio, String tercerSacrificio){
		CartaMonstruo unaCarta = (CartaMonstruo) seleccionarCartaDeLaMano(monstruo);
		seleccionarCartaMonstruoDeMiLado(primerSacrificio).estaMuerta();
		seleccionarCartaMonstruoDeMiLado(segundoSacrificio).estaMuerta();
		seleccionarCartaMonstruoDeMiLado(tercerSacrificio).estaMuerta();
		this.lado.jugarCartaMonstruo(unaCarta);
	}




	public void colocarEnEstadoBocaArriba(Carta unaCarta){
		unaCarta.colocarEn(new EstadoBocaArriba());
		unaCarta.activarEfecto(lado,ladoEnemigo);

	}

	public void colocarEnEstadoBocaAbajo(Carta unaCarta){
		unaCarta.colocarEn(new EstadoBocaAbajo());

	}

	public void colocarEnPosicionAtaque(CartaMonstruo carta){
		carta.enPosicion(new PosicionAtaque());

	}

	public void colocarEnPosicionDefensa(CartaMonstruo carta){
		carta.enPosicion(new PosicionDefensa());

	}



	public Carta seleccionarCartaDeLaMano(String nombreCarta) {
		return this.mano.devolverCarta(nombreCarta);

	}

	public CartaDeUtilidad seleccionarCartaDeUtilidadDeMiLado(String nombreCarta) {
		return lado.seleccionarCartaDeUtilidad(nombreCarta);
	}


	public CartaMonstruo seleccionarCartaMonstruoDeMiLado(String nombreCarta){
		return lado.seleccionarCartaMonstruo(nombreCarta);
	}

	public CartaMonstruo seleccionarCartaDelOtroLado(String nombreCarta){
	    return ladoEnemigo.seleccionarCartaMonstruo(nombreCarta);

    }

	public void darCarta(Carta carta) {
		mano.agregarCarta(carta);

	}


	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}



	public void atacar(String cartaSeleccionada, Jugador jugador) {
		CartaMonstruo cartaMonstruo = seleccionarCartaMonstruoDeMiLado(cartaSeleccionada);
        if(ladoEnemigo.activarTrampaConAtaque(cartaMonstruo) == true) {
        	return;
        }
		cartaMonstruo.atacarA(jugador);

	}

	public void atacarAMonstruo(String cartaSeleccionada, String cartaEnemiga){
		CartaMonstruo cartaMonstruo = seleccionarCartaMonstruoDeMiLado(cartaSeleccionada);
		int resultado = cartaMonstruo.atacarAMonstruo(seleccionarCartaDelOtroLado(cartaEnemiga));
		resolverConflicto(resultado, seleccionarCartaDelOtroLado(cartaEnemiga));

	}


	private void resolverConflicto(int resultadoDelConflicto,CartaMonstruo cartaDefendiente) {
        if (resultadoDelConflicto < 0) {
            recibeDanio(-resultadoDelConflicto);
        }

        if (resultadoDelConflicto > 0) {
            if (!cartaDefendiente.posicionDeDefensa())
                ladoEnemigo.notificarDanio(resultadoDelConflicto);

        }

    }



	public double getPuntosDeVida() {
		return this.puntosDeVida;

	}


	public void extraerCartasDelMazo(){
		Carta carta = lado.extraerDelMazo();
		mano.agregarCarta(carta);
	}


	public void colocarCartaDeCampo(CartaDeCampo cartaCampo) {
		lado.jugarCartaDeCampo(cartaCampo);
		ladoEnemigo.jugarCartaDeCampo(cartaCampo);

	}

	public void darMazo(Mazo mazo) {
		lado.darMazo(mazo);

	}

	public boolean tieneExodiaEnMano() {
		return mano.contieneExodia();
	}



	public int cantidadDeCartasEnMazo() {
		return lado.cantidadDeCartasEnMazo();

	}


	public void fusionDeTresMonstruos(String primerSacrificio, String segundoSacrificio, String tercerSacrificio) {
		lado.fusionDeTresMonstruos(primerSacrificio,segundoSacrificio,tercerSacrificio);


	}

	public void darMazoDeFusiones(Mazo mazo) {
		lado.darMazoDeFusiones(mazo);
	}
}
