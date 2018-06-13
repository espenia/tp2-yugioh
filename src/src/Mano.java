package src;

import java.util.HashMap;
import java.util.Map;

public class Mano {

    private Map<String,Carta> manoDeCartas;



    public Mano(){
        manoDeCartas = new HashMap<>();


    }

    public void agregarCarta(Carta carta){
        manoDeCartas.put(carta.getNombre(),carta);

    }

    public Carta devolverCarta(String nombreDeLaCarta){
    	//agregar excepcion carta no existe
        return manoDeCartas.get(nombreDeLaCarta);

    }


    public void jugarMonstruo(String nombreDelaCarta, String modoDeCarta, String posicionDeCarta) {
    	// excepcio carta no existe, excepcion carta no es monstruo, excepcion string no validos, o un supuesto
        //campo.jugarMonstruoJugadorUno((CartaMonstruo) manoDeCartas.get(nombreDelaCarta),modoDeCarta,posicionDeCarta);

    }
}
