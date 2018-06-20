package modelo;

import modelo.Cartas.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lado {

	private Map<String, CartaDeUtilidad> cartasTrampaOMagicas;
	private Map<String, CartaMonstruo> cartasMonstruo;
	private Mazo mazo;
	private Map<String, Carta> cementerio;
	private Jugador jugador;
	private CartaDeCampo cartaDeCampo;



	public Lado(Mazo unMazo){
		cartasMonstruo = new HashMap<>();
		cartasTrampaOMagicas = new HashMap<>();
		cementerio = new HashMap<>();
		mazo = unMazo;
		cartaDeCampo = new SinCartaDeCampo("sincarta");
	}


	public void asignarJugador(Jugador unJugador){
		jugador = unJugador;

	}


	public Stack<Carta> extraerDelMazo(int cantidad){
		return mazo.extraer(cantidad);

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

    public void notificarDanio(int resultadoDelConflicto){
	    jugador.recibeDanio(resultadoDelConflicto);

    }

	public void mandarCartaMonstruoAlCementerio(String nombreDeLaCarta){
	    CartaMonstruo carta = cartasMonstruo.remove(nombreDeLaCarta);
	    cementerio.put(nombreDeLaCarta,carta);

    }

    public void mandarCartaDeUtilidadAlCementerio(String nombreDeLaCarta){
        CartaDeUtilidad carta = cartasTrampaOMagicas.remove(nombreDeLaCarta);
        cementerio.put(nombreDeLaCarta,carta);

    }

    public Carta seleccionarCartaEnCementerio(String nombreDeLaCarta){
	    return cementerio.get(nombreDeLaCarta);

    }
    
    public void mandarCastasMonstruosAlCementerio() {
    	
    	for (Map.Entry<String, CartaMonstruo> entry : cartasMonstruo.entrySet())
    		this.mandarCartaMonstruoAlCementerio(entry.getKey());

	
    }


	public boolean activarTrampaConAtaque(CartaMonstruo miCarta) {
		boolean pasador = false;
		for (Map.Entry<String, CartaDeUtilidad> entry : cartasTrampaOMagicas.entrySet()){
			mandarCartaDeUtilidadAlCementerio(entry.getValue().getNombre());
			pasador = entry.getValue().activarTrampaDeAtaque(this.jugador, miCarta);
		}
		return pasador;


	}


	public Jugador obtenerJugador() {
		return jugador;
	}

	public void darMazo(Mazo unMazo) {
		this.mazo = unMazo;
	}

	public int cantidadDeCartasEnMazo() {
		return mazo.cantidadDeCartas();

	}
}