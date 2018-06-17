package modelo;

import java.util.HashMap;
import java.util.Map;

public class Mano {

    private Map<String, Carta> manoDeCartas;



    public Mano(){
        manoDeCartas = new HashMap<>();


    }

    public void agregarCarta(Carta carta){
        manoDeCartas.put(carta.getNombre(),carta);

    }

    public Carta devolverCarta(String nombreDeLaCarta){ //agregar excepcion carta no existe
        return manoDeCartas.get(nombreDeLaCarta);

    }

}
