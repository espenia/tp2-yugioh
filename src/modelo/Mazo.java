package modelo;

import modelo.Cartas.DragonBlancoDeOjosAzules;
import modelo.Exceptions.ElMazoEstaVacioException;

import java.util.Collections;
import java.util.Stack;

public class Mazo {

    protected Stack<Carta> cartasEnMazo;

    public Mazo () {
        this.cartasEnMazo = new Stack<>();
        //agregarCarta(new DragonBlancoDeOjosAzules());//TODO solo tests
        //agregarCarta(new DragonBlancoDeOjosAzules());
        //agregarCarta(new DragonBlancoDeOjosAzules());
        armarMazo(new MazoEstandar());
    }

    public void agregarCarta(Carta carta) {
    	this.cartasEnMazo.add(carta);
    }

    public Carta extraerCarta(){
        if(cartasEnMazo.empty())
        	throw new ElMazoEstaVacioException();
        return cartasEnMazo.pop();
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
