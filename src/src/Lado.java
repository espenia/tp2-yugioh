package src;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lado {

	private Map<String,CartaDeUtilidad> cartasTrampaOMagicas;
	private Map<String,CartaMonstruo> cartasMonstruo;
	private Mazo mazo;
	private Cementerio cementerio;
	private Campo campo;



	public Lado(Mazo unMazo, Campo unCampo){
		cartasMonstruo = new HashMap<>();
		cartasTrampaOMagicas = new HashMap<>();
		cementerio = new Cementerio();
		mazo = unMazo;
		campo = unCampo;
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

		cartasMonstruo.put(carta.getNombre(),(CartaMonstruo)carta);

	}

	public CartaMonstruo seleccionarCartaMonstruo(String nombreDeLaCarta){
		return cartasMonstruo.get(nombreDeLaCarta);
	}
}
