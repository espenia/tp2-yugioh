package src;



import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lado {

	private Map<String,CartaDeUtilidad> cartasTrampaOMagicas;
	private Map<String,CartaMonstruo> cartasMonstruo;
	private Mazo mazo;
	private Map<String, Carta> cementerio;
	private Jugador jugador;



	public Lado(Mazo unMazo){
		cartasMonstruo = new HashMap<>();
		cartasTrampaOMagicas = new HashMap<>();
		cementerio = new HashMap<>();
		mazo = unMazo;
	}


	public void asignarJugador(Jugador unJugador){
		jugador = unJugador;
	}


	public Stack<Carta> extraerDelMazo(int cantidad){
		return mazo.extraer(cantidad);

	}
	
	public void jugarCarta(Carta carta, String posicionDeLaCarta, String modoDeLaCarta){
		carta.jugar(this,posicionDeLaCarta,modoDeLaCarta);
	}
	
	public void jugarCartaMonstruo(CartaMonstruo carta, String posicionDeLaCarta, String modoDeLaCarta) {//quiza se puede hacer de otra forma
		if(posicionDeLaCarta == "Boca Abajo"){
			if(modoDeLaCarta == "Ataque")
				carta.colocarEn(new PosicionAtaque(new BocaAbajo()));
			if(modoDeLaCarta == "Defensa")
				carta.colocarEn(new PosicionDefensa(new BocaAbajo()));
		}

		if(posicionDeLaCarta == "Boca Arriba"){
			if(modoDeLaCarta == "Ataque")
				carta.colocarEn(new PosicionAtaque(new BocaArriba()));
			if(modoDeLaCarta == "Defensa")
				carta.colocarEn(new PosicionDefensa(new BocaArriba()));
		}

		cartasMonstruo.put(carta.getNombre(),carta);

	}

	public void jugarCartaMagica(CartaDeUtilidad carta, String posicionDeLaCarta){
		if(posicionDeLaCarta == "Boca Abajo"){
			carta.colocarEn(new BocaAbajo());
		}
		if (posicionDeLaCarta == "Boca Arriba"){
			carta.colocarEn(new BocaAbajo());
			carta.activarEfecto(this.jugador);

		}

	cartasTrampaOMagicas.put(carta.getNombre(),carta);
	}

	public void jugarCartaTrampa(CartaDeUtilidad carta){

		carta.colocarEn(new BocaAbajo());
		carta.activarEfecto(this.jugador);
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
    	{
    		this.mandarCartaMonstruoAlCementerio(entry.getKey());
    	}
	
    }
    
	public int cantidadEnCementerio() {
		return this.cementerio.size();
	}


	public boolean activarTrampa(CartaMonstruo miCarta) {
		if(cartasTrampaOMagicas.isEmpty()) {
			return false;
		}
		for (Map.Entry<String, CartaDeUtilidad> entry : cartasTrampaOMagicas.entrySet())
    	{
    		entry.getValue().activarTrampa(this.jugador, miCarta);
    	}
		return true;
	}
    
}