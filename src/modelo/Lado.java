package modelo;

import modelo.Cartas.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lado {

	private Map<String, CartaDeUtilidad> cartasTrampaOMagicas;
	private Map<String, CartaMonstruo> cartasMonstruo;
	private Mazo mazo;
	private Mazo mazoDeFusiones;
	private Jugador jugador;
	private CartaDeCampo cartaDeCampo;
	private boolean fusion;



	public Lado(Mazo unMazo){
		cartasMonstruo = new HashMap<>();
		cartasTrampaOMagicas = new HashMap<>();
		mazo = unMazo;
		cartaDeCampo = new SinCartaDeCampo("sincarta");
		fusion = false;
		mazoDeFusiones = new Mazo();
	}


	public void asignarJugador(Jugador unJugador){
		jugador = unJugador;

	}


	public Carta extraerDelMazo(){
		return mazo.extraerCarta();

	}

	public void jugarCartaMonstruo(CartaMonstruo carta) {
		cartaDeCampo.aplicarBuff(carta,this);
		cartasMonstruo.put(carta.getNombre(),carta);

	}

	public void jugarCartaDeCampo(CartaDeCampo carta){
		cartaDeCampo = carta;
		CartaMonstruo cartaMonstruo;
		cartaDeCampo.asignarLado(this);
		for (Map.Entry<String,CartaMonstruo> entry : cartasMonstruo.entrySet()){
			cartaMonstruo = entry.getValue();
			cartaDeCampo.aplicarBuff(cartaMonstruo,this);
		}


	}


	public void jugarCartaMagica(CartaDeUtilidad carta) {
		
		cartasTrampaOMagicas.put(carta.getNombre(),carta);

	}


	public void jugarCartaTrampa(CartaDeUtilidad carta,Lado esteLado,Lado ladoEnemigo){
		carta.activarEfecto(esteLado,ladoEnemigo);
		cartasTrampaOMagicas.put(carta.getNombre(),carta);

	}

	public CartaDeUtilidad seleccionarCartaDeUtilidad(String nombreDeLaCarta){

		return cartasTrampaOMagicas.get(nombreDeLaCarta);
	}

	public CartaMonstruo seleccionarCartaMonstruo(String nombreDeLaCarta){

		return cartasMonstruo.get(nombreDeLaCarta);
	}

	public void mandarCastasMonstruosAlCementerio() {

		for(Map.Entry<String,CartaMonstruo> entry : cartasMonstruo.entrySet() ){
			entry.getValue().estaMuerta();

		}


	}

    public void notificarDanio(int resultadoDelConflicto){
	    jugador.recibeDanio(resultadoDelConflicto);

    }


	public boolean activarTrampaConAtaque(CartaMonstruo miCarta) {
		boolean pasador = false;
		for (Map.Entry<String, CartaDeUtilidad> entry : cartasTrampaOMagicas.entrySet()){
			cartasTrampaOMagicas.remove(entry);
			pasador = entry.getValue().activarTrampaDeAtaque(this.jugador, miCarta);
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
		for (Map.Entry<String, CartaMonstruo> entry : cartasMonstruo.entrySet()){
			if(cartaMenorAtaque.getAtaque() >= entry.getValue().getAtaque()) {
				cartaMenorAtaque = entry.getValue();
			}
		}
		if(cartaMenorAtaque == nula) {
			return;
		}
		cartaMenorAtaque.estaMuerta();
	}

	public void habilitarFusion() {
		fusion = true;

	}

	public void fusionDeTresMonstruos(String primerSacrificio, String segundoSacrificio, String tercerSacrificio){
		if (fusion){
			CartaMonstruo sacrificioUno = seleccionarCartaMonstruo(primerSacrificio);
			CartaMonstruo sacrificioDos = seleccionarCartaMonstruo(segundoSacrificio);
			CartaMonstruo sacrificioTres = seleccionarCartaMonstruo(tercerSacrificio);
			CartaDeFusion cartaDeFusion = new CartaDeFusion(mazoDeFusiones);
			cartaDeFusion.agregarSacrificio(sacrificioUno);
			cartaDeFusion.agregarSacrificio(sacrificioDos);
			cartaDeFusion.agregarSacrificio(sacrificioTres);
			cartaDeFusion.realizarFusion();
		}

	}

	public void darMazoDeFusiones(Mazo mazo) {
		mazoDeFusiones = mazo;
	}

	public Jugador obtenerJugador() {
		return jugador;

	}

}