package test;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import modelo.Exceptions.ElMazoEstaVacioException;
import org.junit.Test;
import modelo.*;
import modelo.Cartas.*;

public class testMazo {

	@Test
    public void test01MazoRecienCreadoContieneCeroCartas(){// mazo comienza con 3 cartas son removidas para c/test

        Mazo mazo = new Mazo();
        mazo.extraerCarta();
        mazo.extraerCarta();
        mazo.extraerCarta();
        int cantidadEsperada = 0;
        assertEquals(cantidadEsperada, mazo.cantidadDeCartas());
    }
	
    @Test
    public void test02AgregarYExtraerCartasDelMazoLuegoComprobarQueElMazoEstaVacio(){

        Mazo mazo = new Mazo();
        mazo.extraerCarta();
        mazo.extraerCarta();
        mazo.extraerCarta();
        Carta carta2 = new Fisura();
        Carta carta1 = new Conedragon();
        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        Carta cartaPrueba2 = mazo.extraerCarta();
        Carta cartaPrueba1 = mazo.extraerCarta();
        assertEquals(cartaPrueba2, carta2);
        assertEquals(cartaPrueba1, carta1);
        int cantidadEsperada = 0;
        assertEquals(cantidadEsperada, mazo.cantidadDeCartas());
    }

    @Test (expected = ElMazoEstaVacioException.class)
    public void test03IntentarExtraerCartasDeUnMazoVacio(){
    	
        Mazo mazo = new Mazo();
        mazo.extraerCarta();
        mazo.extraerCarta();
        mazo.extraerCarta();
        mazo.extraerCarta();
    }

    @Test
    public void test04ArmarMazoYComprobar(){
    	
        Mazo mazo = new Mazo();
        mazo.extraerCarta();
        mazo.extraerCarta();
        mazo.extraerCarta();
        Stack<Carta> cartas = new Stack<>();
        cartas.add(new Fisura());
        cartas.add(new Fisura());
        cartas.add(new Fisura());
        cartas.add(new Fisura());
        mazo.armarMazo(cartas);
        int cantidadEsperada = 4;
        assertEquals(cantidadEsperada,mazo.cantidadDeCartas());

    }
    
    @Test
    public void test05AgregarCartasEnVolumen(){

        Mazo mazo = new Mazo();
        mazo.extraerCarta();
        mazo.extraerCarta();
        mazo.extraerCarta();
        for(int i = 0; i < 80; i++) {
        	mazo.agregarCarta(new Conedragon());
        }
        int cantidadEsperada = 80;
        assertEquals(cantidadEsperada, mazo.cantidadDeCartas());
    }

}
