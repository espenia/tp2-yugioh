package modelo;

import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Jugador {
	private int puntosDeVida;
	private Mano mano;
	private Lado ladoEnemigo;
	private Jugador enemigo;
	private Lado lado;


	public Jugador() {
		this.puntosDeVida = 8000;
		mano = new Mano();
	}

	public void asignarLadosYJugadores(Lado lado, Lado ladoEnemigo, Jugador jugadorEnemigo){
		this.enemigo = jugadorEnemigo;
        this.lado = lado;
        this.ladoEnemigo = ladoEnemigo;
    }

	public void jugarCartaMonstruoEnLado(CartaMonstruo carta ) {// Excepciones incorrecta cantidad de sacrificios.
		mano.removerCarta(carta);
		this.lado.jugarCartaMonstruo(carta);

	}

	public void jugarCartaMagicaEnLado(CartaMagica carta) {
		mano.removerCarta(carta);
		this.lado.jugarCartaMagica(carta);

	}

	public void jugarCartaTrampaEnLado(CartaTrampa carta) {
		mano.removerCarta(carta);
		this.lado.jugarCartaTrampa(carta,lado,ladoEnemigo);

	}


	public void jugarCartaEnLadoConUnSacrificio(CartaMonstruo monstruo, CartaMonstruo sacrificio){
		mano.removerCarta(monstruo);
		sacrificio.estaMuerta();
		lado.removerCartaMonstruo(sacrificio);
		this.lado.jugarCartaMonstruo(monstruo);
	}

	public void jugarCartaEnLadoConDosSacrificio(CartaMonstruo monstruo, CartaMonstruo segundoSacrificio, CartaMonstruo primerSacrificio){
		mano.removerCarta(monstruo);
		segundoSacrificio.estaMuerta();
		primerSacrificio.estaMuerta();
		lado.removerCartaMonstruo(primerSacrificio);
        lado.removerCartaMonstruo(segundoSacrificio);
        this.lado.jugarCartaMonstruo(monstruo);

	}

	public void jugarCartaEnLadoConTresSacrificio(CartaMonstruo monstruo, CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		mano.removerCarta(monstruo);
		primerSacrificio.estaMuerta();
		segundoSacrificio.estaMuerta();
		tercerSacrificio.estaMuerta();
		lado.removerCartaMonstruo(primerSacrificio);
        lado.removerCartaMonstruo(segundoSacrificio);
        lado.removerCartaMonstruo(tercerSacrificio);
        this.lado.jugarCartaMonstruo(monstruo);

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


	public void seleccionarCartaDeLaMano(Carta unaCarta) {
		mano.removerCarta(unaCarta);

	}

	public void verificarSiCartaDeUtilidadEstaEnLado(CartaDeUtilidad cartaDeUtilidad) {
		lado.verificarSiCartaDeUtilidadEstaEnLado(cartaDeUtilidad);
	}


	public void verificarSiCartaMonstruoEstaEnLado(CartaMonstruo cartaMonstruo){
		lado.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);
	}

	public void verificarSiCartaMonstruoEstaEnElOtroLado(CartaMonstruo cartaMonstruo){
	    ladoEnemigo.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);

    }

	public void darCarta(Carta carta) {
		mano.agregarCarta(carta);

	}

	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}

	public void atacar(CartaMonstruo cartaSeleccionada, Jugador jugador) {
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		ladoEnemigo.activarTrampaConAtaque(cartaSeleccionada, enemigo);
		cartaSeleccionada.atacarA(jugador);

	}

	public void atacarAMonstruo(CartaMonstruo cartaSeleccionada, CartaMonstruo cartaEnemiga){
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		verificarSiCartaMonstruoEstaEnElOtroLado(cartaEnemiga);
		ladoEnemigo.activarTrampaConAtaque(cartaEnemiga, enemigo);
		int resultado = cartaSeleccionada.atacarAMonstruo(cartaEnemiga);
		resolverConflicto(resultado, cartaEnemiga);

	}

	private void resolverConflicto(int resultadoDelConflicto,CartaMonstruo cartaDefendiente) {
        if (resultadoDelConflicto < 0) {
            recibeDanio(-resultadoDelConflicto);
        }

        if (resultadoDelConflicto > 0) {
            if (!cartaDefendiente.posicionDeDefensa())
				notificarDanioAlEnemigo(resultadoDelConflicto);
        }

    }

    public void notificarDanioAlEnemigo(int danio){
		enemigo.recibeDanio(danio);

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


	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio) {
		lado.fusionDeTresMonstruos(primerSacrificio,segundoSacrificio,tercerSacrificio);
	}

	public void darMazoDeFusiones(Map<String,CartaMonstruo> mazo) {
		lado.darMazoDeFusiones(mazo);
	}
	
	public void colocarEnEstadoBocaArriba(Carta unaCarta){
		unaCarta.colocarEn(new EstadoBocaArriba());
		lado.activarEfecto(unaCarta, this);
	}

	//DISPATCHES DE PARAMETROS PARA LA ACTIVACION DE UN EFECTO//
	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, Mazo mazo, Jugador jugador, Fusion fusion) {
		ladoEnemigo.activarEfecto(unaCarta, cartasMonstruoAliadas, mazo, jugador, fusion);
	}

	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, List<CartaMonstruo> cartasMonstruoEnemigas, Mazo mazo, Jugador jugador, Fusion fusion){
		unaCarta.activarEfecto(cartasMonstruoAliadas, cartasMonstruoEnemigas, mazo, jugador, fusion);
	}
	
	public void habilitarFusion(Fusion fusion) {
		lado.habilitarFusion(fusion);
	}

}
