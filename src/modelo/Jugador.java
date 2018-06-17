package modelo;

public class Jugador {
	private int puntosDeVida;
	private Mano mano;
	private Lado ladoEnemigo;
	private Lado lado;


	public Jugador() { //Multiton 2
		this.puntosDeVida = 8000;
		mano = new Mano();
		//Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
		//Mazo.draw(5);
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
		this.lado.jugarCartaTrampa(carta);

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

	public Carta seleccionarCartaEnCementerio(String nombreCarta){
		return this.lado.seleccionarCartaEnCementerio(nombreCarta);

	}

	public CartaMonstruo seleccionarCartaDelOtroLado(String nombreCarta){
	    return ladoEnemigo.seleccionarCartaMonstruo(nombreCarta);

    }



	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}


	public void aplicarDanioDirecto(int ataque) {
	    ladoEnemigo.notificarDanio(ataque);

	}

	public void atacar(String cartaSeleccionada, Jugador jugador) {
        CartaMonstruo miCarta = seleccionarCartaDeMiLado(cartaSeleccionada);
        if(ladoEnemigo.activarTrampa(miCarta) == true) {
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
            lado.mandarCartaMonstruoAlCementerio(cartaAtacante);
            recibeDanio(-resultadoDelConflicto);
        }

        if (resultadoDelConflicto > 0) {
            if (!(ladoEnemigo.seleccionarCartaMonstruo(cartaDefendiente)).posicionDeDefensa())
                ladoEnemigo.notificarDanio(resultadoDelConflicto);

        ladoEnemigo.mandarCartaMonstruoAlCementerio(cartaDefendiente);
        }



        if (resultadoDelConflicto == 0) {
            lado.mandarCartaMonstruoAlCementerio(cartaAtacante);
            ladoEnemigo.mandarCartaMonstruoAlCementerio(cartaDefendiente);
        }
    }


	public void darCarta(Carta carta) {
	    mano.agregarCarta(carta);
	}

	public double getPuntosDeVida() {
		return this.puntosDeVida;
	}
	public Lado getLado() {
		return this.lado;
	}
	public Lado getLadoEnemigo() {
		return this.ladoEnemigo;
	}
	public int cantidadEnCementerio() {
		return this.lado.cantidadEnCementerio();
	}
}
