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
	private Fase fase;


	public Jugador() {
		this.puntosDeVida = 8000;
		mano = new Mano();
		fase = new SinFase();
	}

	public void asignarLadosYJugadores(Lado lado, Lado ladoEnemigo, Jugador jugadorEnemigo){
		this.enemigo = jugadorEnemigo;
        this.lado = lado;
        this.ladoEnemigo = ladoEnemigo;
    }

	public void jugarCartaMonstruoEnLado(CartaMonstruo carta ) {
		fase.jugarCartaMonstruo();
		carta.verificarCantidadDeSacrificios(0);
		lado.verificarEspacioDeCartasMonstruos();
		mano.removerCarta(carta);
		this.lado.jugarCartaMonstruo(carta);

	}

	public void jugarCartaMagicaEnLado(CartaMagica carta) {
		fase.jugarCartaDeUtilidad();
		lado.verificarEspacioDeCartasDeUtilidad();
		mano.removerCarta(carta);
		this.lado.jugarCartaMagica(carta);

	}

	public void jugarCartaTrampaEnLado(CartaTrampa carta) {
		fase.jugarCartaDeUtilidad();
		lado.verificarEspacioDeCartasDeUtilidad();
		mano.removerCarta(carta);
		this.lado.jugarCartaTrampa(carta,lado,ladoEnemigo);

	}


	public void jugarCartaEnLadoConUnSacrificio(CartaMonstruo monstruo, CartaMonstruo sacrificio){
		fase.jugarCartaMonstruo();
		monstruo.verificarCantidadDeSacrificios(1);
		mano.removerCarta(monstruo);
		sacrificio.estaMuerta();
		lado.removerCartaMonstruo(sacrificio);
		lado.verificarEspacioDeCartasMonstruos();
		this.lado.jugarCartaMonstruo(monstruo);
	}

	public void jugarCartaEnLadoConDosSacrificio(CartaMonstruo monstruo, CartaMonstruo segundoSacrificio, CartaMonstruo primerSacrificio){
		fase.jugarCartaMonstruo();
		monstruo.verificarCantidadDeSacrificios(2);
		mano.removerCarta(monstruo);
		segundoSacrificio.estaMuerta();
		primerSacrificio.estaMuerta();
		lado.removerCartaMonstruo(primerSacrificio);
        lado.removerCartaMonstruo(segundoSacrificio);
		lado.verificarEspacioDeCartasMonstruos();
        this.lado.jugarCartaMonstruo(monstruo);

	}

	public void jugarCartaEnLadoConTresSacrificio(CartaMonstruo monstruo, CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		fase.jugarCartaMonstruo();
		monstruo.verificarCantidadDeSacrificios(3);
		mano.removerCarta(monstruo);
		primerSacrificio.estaMuerta();
		segundoSacrificio.estaMuerta();
		tercerSacrificio.estaMuerta();
		lado.removerCartaMonstruo(primerSacrificio);
        lado.removerCartaMonstruo(segundoSacrificio);
        lado.removerCartaMonstruo(tercerSacrificio);
		lado.verificarEspacioDeCartasMonstruos();
        this.lado.jugarCartaMonstruo(monstruo);

	}

	public void colocarEnEstadoBocaAbajo(Carta unaCarta){
		unaCarta.colocarEn(new EstadoBocaAbajo());

	}

	public void colocarEnEstadoBocaArriba(Carta unaCarta){
		unaCarta.colocarEn(new EstadoBocaArriba());
		lado.activarEfecto(unaCarta, this);
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


	public void atacar(CartaMonstruo cartaSeleccionada, Jugador jugador) {
		fase.atacar();
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		ladoEnemigo.verificarSiHayCartasMonstruos();
		ladoEnemigo.activarTrampaConAtaque(cartaSeleccionada, enemigo);
		cartaSeleccionada.atacarA(jugador);

	}


	public void atacarAMonstruo(CartaMonstruo cartaSeleccionada, CartaMonstruo cartaEnemiga){
		fase.atacar();
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

	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}

	public double getPuntosDeVida() {
		return this.puntosDeVida;

	}

	public void extraerCartasDelMazo(){
		Carta carta = lado.extraerDelMazo();
		mano.agregarCarta(carta);
	}

	public void colocarCartaDeCampo(CartaDeCampo cartaCampo) {
		fase.jugarCartaDeCampo();
		lado.jugarCartaDeCampo(cartaCampo);
		ladoEnemigo.jugarCartaDeCampo(cartaCampo);

	}

	public void darMazo(Mazo mazo) {
		lado.darMazo(mazo);

	}

	public void refrescarAtaques() {
		lado.refresacarAtaques();

	}

	public boolean tieneExodiaEnMano() {
		return mano.contieneExodia();
	}

	public int cantidadDeCartasEnMazo() {
		return lado.cantidadDeCartasEnMazo();
	}


	public void darMazoDeFusiones(Map<String,CartaMonstruo> mazo) {
		lado.darMazoDeFusiones(mazo);
	}

	public void habilitarFusion(Fusion fusion) {
		lado.habilitarFusion(fusion);
	}

	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio) {
		lado.fusionDeTresMonstruos(primerSacrificio,segundoSacrificio,tercerSacrificio);
	}

	public void asignarFase(Fase unaFase) {
		fase = unaFase;

	}



	//DISPATCHES DE PARAMETROS PARA LA ACTIVACION DE UN EFECTO//
	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, Mazo mazo, Jugador jugador, Fusion fusion) {
		ladoEnemigo.activarEfecto(unaCarta, cartasMonstruoAliadas, mazo, jugador, fusion);
	}

	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, List<CartaMonstruo> cartasMonstruoEnemigas, Mazo mazo, Jugador jugador, Fusion fusion){
		unaCarta.activarEfecto(cartasMonstruoAliadas, cartasMonstruoEnemigas, mazo, jugador, fusion);
	}



}
