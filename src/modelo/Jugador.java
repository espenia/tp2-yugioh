package modelo;

import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Jugador {
	private int puntosDeVida;
	private Mano mano;
	public Lado ladoEnemigo;
	private Lado lado;


	public Jugador() {
		this.puntosDeVida = 8000;
		mano = new Mano();
	}

	public void asignarLados(Lado lado, Lado ladoEnemigo){
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

    public boolean verificarSiCartaEstaEnMano(Carta unaCarta){
	    return mano.verificarSiCartaEstaEnMano(unaCarta);
    }

	public void seleccionarCartaDeLaMano(Carta unaCarta) {
		mano.removerCarta(unaCarta);

	}

	public boolean verificarSiCartaDeUtilidadEstaEnLado(CartaDeUtilidad cartaDeUtilidad) {
		return lado.verificarSiCartaDeUtilidadEstaEnLado(cartaDeUtilidad);
	}


	public boolean verificarSiCartaMonstruoEstaEnLado(CartaMonstruo cartaMonstruo){
		return lado.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);
	}

	public boolean verificarSiCartaMonstruoEstaEnElOtroLado(CartaMonstruo cartaMonstruo){
	    return ladoEnemigo.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);

    }

	public void darCarta(Carta carta) {
		mano.agregarCarta(carta);

	}

	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}

	public void atacar(CartaMonstruo cartaSeleccionada, Jugador jugador) {
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		activarTrampas(cartaSeleccionada);
		cartaSeleccionada.atacarA(jugador);

	}

	private void activarTrampas(CartaMonstruo cartaMonstruo) {
		if(ladoEnemigo.activarTrampaConAtaque(cartaMonstruo) == true)
			return;
	}

	public void atacarAMonstruo(CartaMonstruo cartaSeleccionada, CartaMonstruo cartaEnemiga){
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		verificarSiCartaMonstruoEstaEnElOtroLado(cartaEnemiga);
		activarTrampas(cartaEnemiga);
		int resultado = cartaSeleccionada.atacarAMonstruo(cartaEnemiga);
		resolverConflicto(resultado, cartaEnemiga);

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
	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, Mazo mazo, Jugador jugador, boolean fusion) {
		ladoEnemigo.activarEfecto(unaCarta, cartasMonstruoAliadas, mazo, jugador, fusion);
	}

	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, List<CartaMonstruo> cartasMonstruoEnemigas, Mazo mazo, Jugador jugador, boolean fusion){
		unaCarta.activarEfecto(cartasMonstruoAliadas, cartasMonstruoEnemigas, mazo, jugador, fusion);
	}
}
