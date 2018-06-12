package test;


import src.*;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class testMazo {

    @Test
    public void testExtraerCartasDelMazo(){

        Mazo mazo = new Mazo();
        Monstruo carta2 = new Monstruo("Dragon blanco de Ojos Azules",2500, 3000);
        Monstruo carta1 = new Monstruo("Dragon negro de Ojos Rojos",2400,2700);
        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        mazo.extraer(2);
        assertEquals(0,mazo.cantidadDeCartas());

    }

    @Test
    public void testExtraerCartasDelMazoDevuelveLasCartasComoUnaPila(){
        Mazo mazo = new Mazo();
        Monstruo carta2 = new Monstruo("Dragon blanco de Ojos Azules",2500, 3000);
        Monstruo carta1 = new Monstruo("Dragon negro de Ojos Rojos",2400,2700);
        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        Stack<Carta> cartas = mazo.extraer(2);
        assertEquals(carta1,cartas.pop());
        assertEquals(carta2,cartas.pop());
    }

    @Test
    public void testArmarMazo(){
        Mazo mazo = new Mazo();
        Stack<Carta> cartas = new Stack<>();
        cartas.add(new Monstruo("Dragon blanco de Ojos Azules",2500, 3000));
        cartas.add(new Monstruo("Dragon negro de Ojos Rojos",2400,2700));
        cartas.add(new Monstruo("Dragon blanco de Ojos Azules",2500, 3000));
        cartas.add(new Monstruo("Dragon negro de Ojos Rojos",2400,2700));
        mazo.armarMazo(cartas);
        assertEquals(4,mazo.cantidadDeCartas());

    }

}
