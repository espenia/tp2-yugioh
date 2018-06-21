package modelo;

import modelo.Cartas.*;
import java.util.Collections;
import java.util.Stack;

public class Mazo {

    protected Stack<Carta> cartasEnMazo;

    public Mazo () {
        this.cartasEnMazo = new Stack<>();
    }

    public void agregarCarta(Carta carta) {
    	this.cartasEnMazo.add(carta);

    }

    public Stack<Carta> extraer(int cantidad) {
        Stack<Carta> cartas = new Stack<>();
        for (int i = 0 ; i < cantidad ; i++) {
            cartas.add(this.cartasEnMazo.pop());
        }
        return cartas;
    }

    public int cantidadDeCartas(){
        return this.cartasEnMazo.size();
    }

    public void armarMazo(Stack<Carta> cartas) {
	int cantidad = cartas.size();
        for (int i = 0; i < cantidad; i++)
            cartasEnMazo.add(cartas.pop());

        Collections.shuffle(this.cartasEnMazo);
    }

}
