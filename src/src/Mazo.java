package src;



import java.util.Collections;
import java.util.Stack;

public class Mazo {

    private Stack<Carta> cartasEnMazo;
    private int cantidadDeCartas;


    public Mazo (){
        cantidadDeCartas = 0;
        cartasEnMazo = new Stack<>();
    }

    public void agregarCarta(Carta carta){
        cartasEnMazo.add(carta);
        cantidadDeCartas+=1;

    }

    public Stack<Carta> extraer(int cantidad){
        Stack<Carta> cartas = new Stack<>();
        for (int i = 0 ; i < cantidad ; i++){
            cartas.add(cartasEnMazo.pop());
            cantidadDeCartas-=1;
        }
        return cartas;
    }

    public int cantidadDeCartas(){
        return cantidadDeCartas;
    }

    public void armarMazo(Stack<Carta> cartas){
        for (Carta i : cartas)
            cartas.add(cartas.pop());
        
        Collections.shuffle(cartasEnMazo);
    }

}
