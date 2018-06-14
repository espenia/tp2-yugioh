package src;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lado {

	private Map<String,CartaDeUtilidad> cartasTrampaOMagicas;
	private Map<String,CartaMonstruo> cartasMonstruo;
	private Mazo mazo;
	private Map<String, Carta> cementerio;
	private Campo campo;
	private Jugador jugador;



	public Lado(Mazo unMazo, Campo unCampo, Jugador unJugador){
		cartasMonstruo = new HashMap<>();
		cartasTrampaOMagicas = new HashMap<>();
		cementerio = new HashMap<>();
		mazo = unMazo;
		campo = unCampo;
		jugador = unJugador;
	}



	public Stack<Carta> extraerDelMazo(int cantidad){
		return mazo.extraer(cantidad);

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
			carta.setLado(this);
			carta.activarEfecto();
		}
		if (posicionDeLaCarta == "Boca Arrbia"){
			carta.colocarEn(new BocaAbajo());
			carta.setLado(this);
			carta.activarEfecto();

		}

	cartasTrampaOMagicas.put(carta.getNombre(),carta);
	}

	public void jugarCartaTrampa(CartaDeUtilidad carta){

		carta.colocarEn(new BocaAbajo());
		carta.setLado(this);
		carta.activarEfecto();
		cartasTrampaOMagicas.put(carta.getNombre(),carta);

	}

	public CartaDeUtilidad seleccionarCartaDeUtilidad(String nombreDeLaCarta){

		return cartasTrampaOMagicas.get(nombreDeLaCarta);
	}

	public CartaMonstruo seleccionarCartaMonstruo(String nombreDeLaCarta){

		return cartasMonstruo.get(nombreDeLaCarta);
	}

	public void resolverConflicto( int resultadoDelConflicto, CartaMonstruo cartaAtacante, CartaMonstruo cartaDefendiente){
	    if(resultadoDelConflicto < 0){
            mandarCartaMonstruoAlCementerio(cartaAtacante.getNombre());
            jugador.recibeDanio(-resultadoDelConflicto);
        }

	    if(resultadoDelConflicto > 0)
            campo.notificarMandarCartaMonstruoAlCementerioAlOtroLado(resultadoDelConflicto,cartaDefendiente,this);



	    if (resultadoDelConflicto == 0) {
            mandarCartaMonstruoAlCementerio(cartaAtacante.getNombre());
            campo.notificarMandarCartaMonstruoAlCementerioAlOtroLado(resultadoDelConflicto,cartaDefendiente,this);
        }


    }

    public void notificarConflicto(int resultadoDelConflicto, CartaMonstruo cartaAfectada){
	    jugador.recibeDanio(resultadoDelConflicto);
	    mandarCartaMonstruoAlCementerio(cartaAfectada.getNombre());

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
}