package modelo;

import modelo.Cartas.*;

import java.util.*;

public class Lado {

	private List<CartaMonstruo> cartasMonstruo;
	private List<CartaDeUtilidad> cartasTrampaOMagicas;
	private Mazo mazo;
	private Map<String, CartaMonstruo> mazoDeFusiones;
	private CartaDeCampo cartaDeCampo;
	private Fusion fusion;



	public Lado(Mazo unMazo){

		cartasMonstruo = new ArrayList<>();
		cartasTrampaOMagicas = new ArrayList<>();
		mazo = unMazo;
		cartaDeCampo = new SinCartaDeCampo();
		fusion = new Fusion();
		mazoDeFusiones = new HashMap<>();
	}




	public Carta extraerDelMazo(){
		return mazo.extraerCarta();

	}

	public void jugarCartaMonstruo(CartaMonstruo carta) {
		cartaDeCampo.aplicarBuff(carta,this);
		cartasMonstruo.add(carta);

	}

	public void jugarCartaDeCampo(CartaDeCampo carta){
		cartaDeCampo = carta;
		cartaDeCampo.asignarLado(this);
		for(CartaMonstruo i : cartasMonstruo )
			cartaDeCampo.aplicarBuff(i,this);

	}


	public void jugarCartaMagica(CartaDeUtilidad carta) {
		cartasTrampaOMagicas.add(carta);

	}

	public void jugarCartaTrampa(CartaDeUtilidad carta,Lado esteLado,Lado ladoEnemigo){
		carta.activarTrampa(esteLado,ladoEnemigo);
		cartasTrampaOMagicas.add(carta);
	}

	public void verificarSiHayCartasMonstruos() throws HayUnMonstruoEnElCaminoException{
		if (!cartasMonstruo.isEmpty())
			throw new HayUnMonstruoEnElCaminoException();

	}


	public void verificarEspacioDeCartasMonstruos() throws NoHayEspacioEnLadoException{
		if (cartasMonstruo.size() == 5)
			throw new NoHayEspacioEnLadoException();

	}

	public void verificarEspacioDeCartasDeUtilidad() throws NoHayEspacioEnLadoException {
		if (cartasTrampaOMagicas.size() == 5)
			throw new NoHayEspacioEnLadoException();
	}

	public void verificarSiCartaDeUtilidadEstaEnLado(CartaDeUtilidad cartaDeUtilidad)throws LadoNoContieneCartaException{
		if (!cartasTrampaOMagicas.contains(cartaDeUtilidad))
			throw new LadoNoContieneCartaException();

	}

	public void verificarSiCartaMonstruoEstaEnLado(CartaMonstruo cartaMonstruo)throws LadoNoContieneCartaException{
		if (!cartasMonstruo.contains(cartaMonstruo))
			throw new LadoNoContieneCartaException();

	}

	public void refresacarAtaques() {
		for (CartaMonstruo i : cartasMonstruo)
			i.refrescarAtaque();

	}

	public void removerCartaMonstruo(CartaMonstruo cartaMonstruo){
		verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);
		cartasMonstruo.remove(cartaMonstruo);

	}

	public void removerCartaDeUtilidad(CartaDeUtilidad cartaDeUtilidad){
		verificarSiCartaDeUtilidadEstaEnLado(cartaDeUtilidad);
		cartasTrampaOMagicas.remove(cartaDeUtilidad);

	}


	public boolean activarTrampaConAtaque(CartaMonstruo miCarta,Jugador jugador) {
		boolean pasador = false;
		for (CartaDeUtilidad i: cartasTrampaOMagicas){
			if (i instanceof CartaTrampa)
				i.activarTrampaDeAtaque(jugador, miCarta);
		}
		return pasador;


	}


	public void darMazo(Mazo unMazo) {
		this.mazo = unMazo;

	}

	public int cantidadDeCartasEnMazo() {
		return mazo.cantidadDeCartas();

	}


	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		this.fusion.fusionDeTresMonstruos(primerSacrificio,segundoSacrificio,tercerSacrificio,this.mazoDeFusiones,this);

	}

	public void darMazoDeFusiones(Map<String,CartaMonstruo> mazo) {
		mazoDeFusiones = mazo;
	}


    //DISPATCHES DE PARAMETROS PARA LA ACTIVACION DE UN EFECTO//
	public void activarEfecto(Carta unaCarta, Jugador jugador) {
		jugador.activarEfecto(unaCarta, this.cartasMonstruo, this.mazo, jugador, this.fusion);
	}


	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, Mazo mazo, Jugador jugador, Fusion fusion) {
		jugador.activarEfecto(unaCarta, cartasMonstruoAliadas , this.cartasMonstruo, mazo, jugador, this.fusion);
	}
	
	public void habilitarFusion(Fusion fusion) {
		this.fusion = fusion;
	}

}