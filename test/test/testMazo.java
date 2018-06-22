package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import modelo.*;
import modelo.Cartas.*;

public class testMazo {

    @Test
    public void test01AgregarYExtraerCartasDelMazoLuegoComprobarQueElMazoEstaVacio(){

        Mazo mazo = new Mazo();
        Carta carta2 = new Fisura();
        Carta carta1 = new Conedragon();
        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        Carta cartaPrueba2 = mazo.extraerCarta();
        Carta cartaPrueba1 = mazo.extraerCarta();
        assertEquals(cartaPrueba2, carta2);
        assertEquals(cartaPrueba1, carta1);
        assertEquals(0, mazo.cantidadDeCartas());
    }

/*
    @Test
    public void testArmarMazo(){
        Mazo mazo = new Mazo();
        Stack<Carta> cartas = new Stack<>();
        cartas.add(new CartaMonstruo("Dragon blanco de Ojos Azules",2500, 3000));
        cartas.add(new CartaMonstruo("Dragon negro de Ojos Rojos",2400,2700));
        cartas.add(new CartaMonstruo("Dragon blanco de Ojos Azules",2500, 3000));
        cartas.add(new CartaMonstruo("Dragon negro de Ojos Rojos",2400,2700));
        mazo.armarMazo(cartas);
        assertEquals(4,mazo.cantidadDeCartas());

    }
*/
}
