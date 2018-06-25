package modelo;

import modelo.Cartas.*;

import java.util.*;

public class Lado {

	private Map<String, CartaDeUtilidad> cartasTrampaOMagicas;
	private Map<String, List<CartaMonstruo>> cartasMonstruo;
	private Mazo mazo;
	private Map<String, CartaMonstruo> mazoDeFusiones;
	private Jugador jugador;
	private CartaDeCampo cartaDeCampo;
	private boolean fusion;



	public Lado(Mazo unMazo){
		cartasMonstruo = new HashMap<>();
		cartasTrampaOMagicas = new HashMap<>();
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
		List<CartaMonstruo> lista = new ArrayList<>();
		if (cartasMonstruo.containsKey(carta.getNombre())){
			List <CartaMonstruo> cartas = cartasMonstruo.get(carta.getNombre());
			for (int i = 0; i < cartas.size(); i++)
				lista.add(cartas.get(i));
		}
		lista.add(carta);
		cartasMonstruo.put(carta.getNombre(),lista);

	}

	public void jugarCartaDeCampo(CartaDeCampo carta){
		cartaDeCampo = carta;
		CartaMonstruo cartaMonstruo;
		cartaDeCampo.asignarLado(this);
		for(Map.Entry<String,List<CartaMonstruo>> entry : cartasMonstruo.entrySet() ){
			for (int i = 0; i < entry.getValue().size() ; i++){
				cartaMonstruo = entry.getValue().get(i);
				cartaDeCampo.aplicarBuff(cartaMonstruo,this);
			}
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

		List<CartaMonstruo> cartas = cartasMonstruo.get(nombreDeLaCarta);
		if (cartas.isEmpty())
			cartasMonstruo.remove(nombreDeLaCarta);
		return cartas.get(0);
	}

	public void mandarCastasMonstruosAlCementerio() {

		for(Map.Entry<String,List<CartaMonstruo>> entry : cartasMonstruo.entrySet() ){
			for (int i = 0; i < entry.getValue().size() ; i++)
				entry.getValue().get(i).estaMuerta();
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
		for(Map.Entry<String,List<CartaMonstruo>> entry : cartasMonstruo.entrySet() ){
			for (int i = 0; i < entry.getValue().size() ; i++)
				if(cartaMenorAtaque.getAtaque() >= entry.getValue().get(i).getAtaque()) {
					cartaMenorAtaque = entry.getValue().get(i);
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

	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		if (fusion){
			CartaDeFusion cartaDeFusion = new CartaDeFusion(mazoDeFusiones);
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