package src;


public class Jugador {
	public int puntosDeVida;
	public Mano mano;
	private Lado ladoEnemigo;
	private Lado lado;


	public Jugador() { //Multiton 2
		this.puntosDeVida = 8000;
		mano = new Mano();
		//Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
		//Mazo.draw(5);
	}

	public void posicionarCartaEnLado(CartaMonstruo monstruo,String posicionDeLaCarta,String modoDeLaCarta ) {// Excepciones incorrecta cantidad de sacrificios.
		this.lado.jugarCartaMonstruo(monstruo, posicionDeLaCarta,modoDeLaCarta);

	}

	public void posicionarCartaEnLadoConUnSacrificio(CartaMonstruo monstruo,String posicionDeLaCarta,String modoDeLaCarta,String nombreDelSacrificio){
		lado.mandarCartaMonstruoAlCementerio(nombreDelSacrificio);
		this.lado.jugarCartaMonstruo(monstruo, posicionDeLaCarta,modoDeLaCarta);
	}

	public void posicionarCartaEnLadoConDosSacrificio(CartaMonstruo monstruo,String posicionDeLaCarta,String modoDeLaCarta,String nombreDelSegundoSacrificio,String nombreDelPrimerSacrificio){
		lado.mandarCartaMonstruoAlCementerio(nombreDelPrimerSacrificio);
		lado.mandarCartaMonstruoAlCementerio(nombreDelSegundoSacrificio);
		this.lado.jugarCartaMonstruo(monstruo, posicionDeLaCarta,modoDeLaCarta);
	}

	public void posicionarCartaEnLadoConTresSacrificio(CartaMonstruo monstruo,String posicionDeLaCarta,String modoDeLaCarta,String nombreDelPrimerSacrificio,String nombreDelSegundoSacrificio,String nombreDelTercerSacrificio){
		lado.mandarCartaMonstruoAlCementerio(nombreDelPrimerSacrificio);
		lado.mandarCartaMonstruoAlCementerio(nombreDelSegundoSacrificio);
		lado.mandarCartaMonstruoAlCementerio(nombreDelTercerSacrificio);
		this.lado.jugarCartaMonstruo(monstruo, posicionDeLaCarta,modoDeLaCarta);
	}



	public CartaMonstruo seleccionarCartaDeLaMano(String nombreCarta) {
		return (CartaMonstruo) this.mano.devolverCarta(nombreCarta);
	}


	public CartaMonstruo seleccionarCartaDelCampo(String nombreCarta) {
		return this.lado.seleccionarCartaMonstruo(nombreCarta);

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

	public void atacarAMonstruo(CartaMonstruo cartaSeleccionada, CartaMonstruo cartaEnemiga){
		int resultado = cartaSeleccionada.compararAtaqueDeMonstruo(cartaEnemiga);
		lado.resolverConflicto(resultado, cartaSeleccionada, cartaEnemiga);

	}

	public void darCarta(Carta carta) {
	    mano.agregarCarta(carta);
	}
}
