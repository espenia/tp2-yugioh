package modelo;

import java.util.List;
import java.util.Map;


public class Jugador {
	private int puntosDeVida;
	private Mano mano;
	private Lado ladoEnemigo;
	private Jugador enemigo;
	private Lado lado;
	private Fase fase;


	public Jugador() {
		this.puntosDeVida = 8000;
		this.mano = new Mano();
		this.fase = new SinFase();
	}

	public void darMazoDeFusiones(Map<String,CartaMonstruo> mazo) {
		this.lado.darMazoDeFusiones(mazo);
	}
	
	public void asignarLadosYJugadores(Lado lado, Lado ladoEnemigo, Jugador jugadorEnemigo){
		this.enemigo = jugadorEnemigo;
        this.lado = lado;
        this.ladoEnemigo = ladoEnemigo;
    }

	public void jugarCartaMonstruoEnLado(CartaMonstruo carta ) {
		carta.verificarCantidadDeSacrificios(0);
		this.fase.jugarCartaMonstruo();
		this.lado.verificarEspacioDeCartasMonstruos();
		this.mano.removerCarta(carta);
		this.lado.jugarCartaMonstruo(carta);

	}

	public void jugarCartaMagicaEnLado(CartaMagica carta) {
		this.fase.jugarCartaDeUtilidad();
		this.lado.verificarEspacioDeCartasDeUtilidad();
		this.mano.removerCarta(carta);
		this.lado.jugarCartaMagica(carta);

	}

	public void jugarCartaTrampaEnLado(CartaTrampa carta) {
		this.fase.jugarCartaDeUtilidad();
		this.lado.verificarEspacioDeCartasDeUtilidad();
		this.mano.removerCarta(carta);
		this.lado.jugarCartaTrampa(carta,this.lado,this.ladoEnemigo);

	}


	public void jugarCartaEnLadoConUnSacrificio(CartaMonstruo monstruo, CartaMonstruo sacrificio){
		this.fase.jugarCartaMonstruo();
		monstruo.verificarCantidadDeSacrificios(1);
		this.mano.removerCarta(monstruo);
		sacrificio.estaMuerta();
		this.lado.removerCartaMonstruo(sacrificio);
		this.lado.verificarEspacioDeCartasMonstruos();
		this.lado.jugarCartaMonstruo(monstruo);
	}

	public void jugarCartaEnLadoConDosSacrificio(CartaMonstruo monstruo, CartaMonstruo segundoSacrificio, CartaMonstruo primerSacrificio){
		this.fase.jugarCartaMonstruo();
		monstruo.verificarCantidadDeSacrificios(2);
		this.mano.removerCarta(monstruo);
		segundoSacrificio.estaMuerta();
		primerSacrificio.estaMuerta();
		this.lado.removerCartaMonstruo(primerSacrificio);
		this.lado.removerCartaMonstruo(segundoSacrificio);
		this.lado.verificarEspacioDeCartasMonstruos();
        this.lado.jugarCartaMonstruo(monstruo);

	}

	public void jugarCartaEnLadoConTresSacrificio(CartaMonstruo monstruo, CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		this.fase.jugarCartaMonstruo();
		monstruo.verificarCantidadDeSacrificios(3);
		this.mano.removerCarta(monstruo);
		primerSacrificio.estaMuerta();
		segundoSacrificio.estaMuerta();
		tercerSacrificio.estaMuerta();
		this.lado.removerCartaMonstruo(primerSacrificio);
		this.lado.removerCartaMonstruo(segundoSacrificio);
		this.lado.removerCartaMonstruo(tercerSacrificio);
		this.lado.verificarEspacioDeCartasMonstruos();
        this.lado.jugarCartaMonstruo(monstruo);

	}

	public void colocarEnEstadoBocaAbajo(Carta unaCarta){
		unaCarta.colocarEn(new EstadoBocaAbajo());

	}

	public void colocarEnEstadoBocaArriba(Carta unaCarta){
		this.fase.activarCartaMagica();
		unaCarta.colocarEn(new EstadoBocaArriba());
		this.lado.activarEfecto(unaCarta, this, this.enemigo);
		if (unaCarta instanceof CartaDeUtilidad)
			this.lado.removerCartaDeUtilidad((CartaDeUtilidad) unaCarta);
		lado.actualizarLado();
		ladoEnemigo.actualizarLado();
	}

	public void colocarEnPosicionAtaque(CartaMonstruo carta){
		carta.enPosicion(new PosicionAtaque());

	}

	public void colocarEnPosicionDefensa(CartaMonstruo carta){
		carta.enPosicion(new PosicionDefensa());

	}

	public void verificarSiCartaDeUtilidadEstaEnLado(CartaDeUtilidad cartaDeUtilidad) {
		this.lado.verificarSiCartaDeUtilidadEstaEnLado(cartaDeUtilidad);
	}


	public void verificarSiCartaMonstruoEstaEnLado(CartaMonstruo cartaMonstruo){
		this.lado.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);
	}

	public void verificarSiCartaMonstruoEstaEnElOtroLado(CartaMonstruo cartaMonstruo){
		this.ladoEnemigo.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);

    }

	public void darCarta(Carta carta) {
		this.mano.agregarCarta(carta);

	}


	public void atacar(CartaMonstruo cartaSeleccionada, Jugador jugador) {
		this.fase.atacar();
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		this.ladoEnemigo.verificarSiHayCartasMonstruos();
		this.ladoEnemigo.activarTrampaConAtaque(cartaSeleccionada, this.enemigo);
		cartaSeleccionada.atacarA(jugador);

	}


	public void atacarAMonstruo(CartaMonstruo cartaSeleccionada, CartaMonstruo cartaEnemiga){
		this.fase.atacar();
		verificarSiCartaMonstruoEstaEnLado(cartaSeleccionada);
		verificarSiCartaMonstruoEstaEnElOtroLado(cartaEnemiga);
		this.ladoEnemigo.activarTrampaConAtaque(cartaEnemiga, this.enemigo);
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
        lado.actualizarLado();
        ladoEnemigo.actualizarLado();

    }

    public void notificarDanioAlEnemigo(int danio){
    	this.enemigo.recibeDanio(danio);

	}

	public void recibeDanio(int ataque) {
		this.puntosDeVida = this.puntosDeVida - ataque;

	}

	public double getPuntosDeVida() {
		return this.puntosDeVida;

	}

	public void extraerCartasDelMazo(){
		Carta carta = this.lado.extraerDelMazo();
		this.mano.agregarCarta(carta);
	}

	public void colocarCartaDeCampo(CartaDeCampo cartaCampo) {
		this.fase.jugarCartaDeCampo();
		this.lado.removerBuffs();
		this.ladoEnemigo.removerBuffs();
		this.lado.jugarCartaDeCampo(cartaCampo);
		this.ladoEnemigo.jugarCartaDeCampo(cartaCampo);

	}

	public void darMazo(Mazo mazo) {
		this.lado.darMazo(mazo);
	}

	public void refrescarAtaques() {
		this.lado.refrescarAtaques();
	}

	public boolean tieneExodiaEnMano() {
		return mano.contieneExodia();
	}

	public int cantidadDeCartasEnMazo() {
		return lado.cantidadDeCartasEnMazo();
	}
	
	//DISPATCHES DE FUSION//
	public void habilitarFusion(Fusion fusion) {
		this.lado.habilitarFusion(fusion);
	}

	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio) {
		this.lado.fusionDeTresMonstruos(primerSacrificio,segundoSacrificio,tercerSacrificio);
	}
	
	//INDICA AL JUGADOR LA FASE EN LA QUE SE ENCUENTRA//
	public void asignarFase(Fase unaFase) {
		this.fase = unaFase;
	}

	//DISPATCHES DE PARAMETROS PARA LA ACTIVACION DE UN EFECTO AL DARLA VUELTA//
	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, Mazo mazo, Jugador jugador, Fusion fusion, Jugador enemigo) {
		this.ladoEnemigo.activarEfecto(unaCarta, cartasMonstruoAliadas, mazo, jugador, fusion, enemigo);
	}

	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, List<CartaMonstruo> cartasMonstruoEnemigas, Mazo mazo, Jugador jugador, Fusion fusion, Jugador enemigo){
		unaCarta.activarEfecto(cartasMonstruoAliadas, cartasMonstruoEnemigas, mazo, jugador, enemigo);
	}

	// metodos para vista

    public List<Carta> devolverMano() {
		return mano.getCartasEnMano();
    }

    public Map getMazoDeFusion() {
        return  lado.getMazoDeFusion();
    }

    public Mazo getMazo() {
        return lado.getMazo();
    }

    public List<CartaMonstruo> getCartasMonstruos() {
		return lado.getCartasMosntruos();
    }

    public List<CartaDeUtilidad> getCartasDeUtilidad() {
        return lado.getCartasDeUtilidad();
    }

    public CartaDeCampo getCartaDeCampo() {
        return lado.getCartaDeCampo();
    }
    
    public Jugador getJugadorEnemigo (){
    	return enemigo;
    }
}
