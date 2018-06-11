package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Mano {

    private Campo campo;
    private Mazo mazo;
    private Map<String,Carta> manoDeCartas;



    public Mano(Mazo unMazo, Campo unCampo){
        mazo  = unMazo;
        campo = unCampo;
        manoDeCartas = new HashMap<>();

    }

    public void extraerCarta(){
        Stack<Carta> cartas = mazo.extraer(1);
        Carta carta = cartas.pop();
        manoDeCartas.put(carta.getNombre(),carta);

    }

    public Carta devolverCarta(String nombreDeLaCarta){
    	//agregar excepcion carta no existe
        return manoDeCartas.get(nombreDeLaCarta);

    }


    public void jugarMonstruo(String nombreDelaCarta, String modoDeCarta, String posicionDeCarta) {
    	// excepcio carta no existe, excepcion carta no es monstruo, excepcion string no validos, o un supuesto
        campo.jugarMonstruoJugadorUno((CartaMonstruo) manoDeCartas.get(nombreDelaCarta),modoDeCarta,posicionDeCarta);

    }
}
