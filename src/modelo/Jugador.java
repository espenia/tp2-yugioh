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

	public void posicionarCartaMonstruoEnLado(CartaMonstruo carta ) {// Excepciones incorrecta cantidad de sacrificios.
		this.lado.jugarCartaMonstruo(carta);

	}

	public void posicionarCartaMagicaEnLado(CartaMagica carta) {
		this.lado.jugarCartaMagica(carta);

	}

	public void posicionarCartaTrampaEnLado(CartaTrampa carta) {
		this.lado.jugarCartaTrampa(carta,lado,ladoEnemigo);

	}


	public void posicionarCartaEnLadoConUnSacrificio(CartaMonstruo monstruo, String nombreDelSacrificio){
		lado.mandarCartaMonstruoAlCementerio(nombreDelSacrificio);
		this.lado.jugarCartaMonstruo(monstruo);
	}

	public void posicionarCartaEnLadoConDosSacrificio(CartaMonstruo monstruo, String nombreDelSegundoSacrificio, String nombreDelPrimerSacrificio){
		lado.mandarCartaMonstruoAlCementerio(nombreDelPrimerSacrificio);
		lado.mandarCartaMonstruoAlCementerio(nombreDelSegundoSacrificio);
		this.lado.jugarCartaMonstruo(monstruo);
	}

	public void posicionarCartaEnLadoConTresSacrificio(CartaMonstruo monstruo, String nombreDelPrimerSacrificio, String nombreDelSegundoSacrificio, String nombreDelTercerSacrificio){
		lado.mandarCartaMonstruoAlCementerio(nombreDelPrimerSacrificio);
		lado.mandarCartaMonstruoAlCementerio(nombreDelSegundoSacrificio);
		lado.mandarCartaMonstruoAlCementerio(nombreDelTercerSacrificio);
		this.lado.jugarCartaMonstruo(monstruo);
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

	public CartaMonstruo seleccionarCartaDeMiLado(String nombreCarta) {
		return this.lado.seleccionarCartaMonstruo(nombreCarta);

	}

	public CartaDeUtilidad seleccionarCartaDeUtilidadDeMiLado(String nombreCarta) {
		return lado.seleccionarCartaDeUtilidad(nombreCarta);
	}

	public Carta seleccionarCartaEnCementerio(String nombreCarta){
		return this.lado.seleccionarCartaEnCementerio(nombreCarta);

	}

	public CartaMonstruo seleccionarCartaDelOtroLado(String nombreCarta){
	    return ladoEnemigo.seleccionarCartaMonstruo(nombreCarta);

    }

	public CartaDeUtilidad seleccionarCartaDeUtilidadDelOtroLado(String nombreCarta){
		return ladoEnemigo.seleccionarCartaDeUtilidad(nombreCarta);

	}



	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;
	}


	public void aplicarDanioDirecto(int ataque) {
	    ladoEnemigo.notificarDanio(ataque);

	}

	public void atacar(String cartaSeleccionada, Jugador jugador) {
        CartaMonstruo miCarta = seleccionarCartaDeMiLado(cartaSeleccionada);
        if(ladoEnemigo.activarTrampaConAtaque(miCarta) == true) {
        	return;
        }
	    miCarta.atacarA(jugador);

	}

	public void atacarAMonstruo(String cartaSeleccionada, String cartaEnemiga){
	    CartaMonstruo miCarta = seleccionarCartaDeMiLado(cartaSeleccionada);
	    CartaMonstruo cartaDelEnemigo = seleccionarCartaDelOtroLado(cartaEnemiga);
		int resultado = miCarta.compararAtaqueDeMonstruo(cartaDelEnemigo);
		resolverConflicto(resultado, cartaSeleccionada, cartaEnemiga);

	}


	public void resolverConflicto(int resultadoDelConflicto,String cartaAtacante,String cartaDefendiente) {
        if (resultadoDelConflicto < 0) {
        	if (!(ladoEnemigo.seleccionarCartaMonstruo(cartaDefendiente)).posicionDeDefensa())
            	lado.mandarCartaMonstruoAlCementerio(cartaAtacante);
            recibeDanio(-resultadoDelConflicto);
        }

        if (resultadoDelConflicto > 0) {
            if (!(ladoEnemigo.seleccionarCartaMonstruo(cartaDefendiente)).posicionDeDefensa())
                ladoEnemigo.notificarDanio(resultadoDelConflicto);

        ladoEnemigo.mandarCartaMonstruoAlCementerio(cartaDefendiente);
        }



        if (resultadoDelConflicto == 0) {
        	if (!(ladoEnemigo.seleccionarCartaMonstruo(cartaDefendiente)).posicionDeDefensa()){
            	lado.mandarCartaMonstruoAlCementerio(cartaAtacante);
           		ladoEnemigo.mandarCartaMonstruoAlCementerio(cartaDefendiente);
           	}
        }
    }


	public void darCarta(Carta carta) {
	    mano.agregarCarta(carta);
	}

	public double getPuntosDeVida() {
		return this.puntosDeVida;
	}


	public boolean extraerCartasDelMazo(int cantidad){
		Stack<Carta> cartas = lado.extraerDelMazo(cantidad);
		if(cartas.empty()) {
			return false;
		}
		for (int i = 0; i < cantidad ; i++)
			mano.agregarCarta(cartas.pop());
		return true;
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
}
