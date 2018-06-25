package modelo;

import modelo.Cartas.*;

import java.util.*;

public class Lado {

	private List<CartaMonstruo> cartasMonstruo;
	private List<CartaDeUtilidad> cartasTrampaOMagicas;
	private Mazo mazo;
	private Map<String, CartaMonstruo> mazoDeFusiones;
	private Jugador jugador;
	private CartaDeCampo cartaDeCampo;
	private boolean fusion;



	public Lado(Mazo unMazo){
		cartasMonstruo = new ArrayList<>();
		cartasTrampaOMagicas = new ArrayList<>();
		mazo = unMazo;
		cartaDeCampo = new SinCartaDeCampo("sincarta");
		fusion = false;
		mazoDeFusiones = new HashMap<>();
	}


	public void asignarJugador(Jugador unJugador){
		jugador = unJugador;

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
		carta.activarEfecto(esteLado,ladoEnemigo);
		cartasTrampaOMagicas.add(carta);

	}

	public boolean verificarSiCartaDeUtilidadEstaEnLado(CartaDeUtilidad cartaDeUtilidad){
		return cartasTrampaOMagicas.contains(cartaDeUtilidad);

	}

	public boolean verificarSiCartaMonstruoEstaEnLado(CartaMonstruo cartaMonstruo){
		return cartasMonstruo.contains(cartaMonstruo);

	}


	public void removerCartaMonstruo(CartaMonstruo cartaMonstruo)throws LadoNoContieneCartaException{
		if (!cartasMonstruo.remove(cartaMonstruo))
			throw new LadoNoContieneCartaException();

	}

	public void removerCartaDeUtilidad(CartaDeUtilidad cartaDeUtilidad)throws LadoNoContieneCartaException{
		if (!cartasMonstruo.remove(cartaDeUtilidad))
			throw new LadoNoContieneCartaException();

	}

	public void mandarCastasMonstruosAlCementerio() {
		for (CartaMonstruo i: cartasMonstruo)
			i.estaMuerta();


	}

    public void notificarDanio(int resultadoDelConflicto){
	    jugador.recibeDanio(resultadoDelConflicto);

    }


	public boolean activarTrampaConAtaque(CartaMonstruo miCarta) {
		boolean pasador = false;
		for (CartaDeUtilidad i: cartasTrampaOMagicas){
			if (i instanceof CartaTrampa)
				pasador = i.activarTrampaDeAtaque(this.jugador, miCarta);
		}
		return pasador;


	}


	public void darMazo(Mazo unMazo) {
		this.mazo = unMazo;

	}

	public int cantidadDeCartasEnMazo() {
		return mazo.cantidadDeCartas();

	}


	public void matarMenorAtaque() {
		CartaMonstruo nula = new CartaNula();
		CartaMonstruo cartaMenorAtaque = nula;
		for (CartaMonstruo i : cartasMonstruo) {
			if(cartaMenorAtaque.getAtaque() >= i.getAtaque())
				cartaMenorAtaque = i;
		}
		cartaMenorAtaque.estaMuerta();
	}

	public void habilitarFusion() {
		fusion = true;

	}

	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		if (fusion){
			CartaDeFusion cartaDeFusion = new CartaDeFusion(mazoDeFusiones);
			removerCartaMonstruo(primerSacrificio);
			removerCartaMonstruo(segundoSacrificio);
			removerCartaMonstruo(tercerSacrificio);
			cartaDeFusion.agregarSacrificio(primerSacrificio);
			cartaDeFusion.agregarSacrificio(segundoSacrificio);
			cartaDeFusion.agregarSacrificio(tercerSacrificio);
			CartaMonstruo monstruo = cartaDeFusion.realizarFusion();
			jugarCartaMonstruo(monstruo);
		}

	}

	public void darMazoDeFusiones(Map<String,CartaMonstruo> mazo) {
		mazoDeFusiones = mazo;
	}

	public Jugador obtenerJugador() {
		return jugador;

	}


}