package test;

import static org.junit.Assert.*;
import org.junit.Test;
import src.*;

import java.util.Stack;

public class testLado {


    @Test
    public void testJugarMonstruo(){
        Mazo mazo = new Mazo();
        mazo.agregarCarta(new CartaMonstruo("Dragon negro de Ojos Rojos",2400,2700));
        Lado lado = new Lado(mazo);
        Stack<Carta> cartas = lado.extraerDelMazo(1);
        Carta carta = cartas.pop();
        lado.jugarCartaMonstruo((CartaMonstruo)carta,"Boca Arriba","Ataque");
        assertEquals(carta,lado.seleccionarCartaMonstruo("Dragon negro de Ojos Rojos"));


    }

    @Test
    public void testJugarMonstruoEnModoAtaqueBocaArriba(){
        Mazo mazo = new Mazo();
        mazo.agregarCarta(new CartaMonstruo("Dragon negro de Ojos Rojos",2400,2700));
        Lado lado = new Lado(mazo);
        Stack<Carta> cartas = lado.extraerDelMazo(1);
        Carta carta = cartas.pop();
        lado.jugarCartaMonstruo((CartaMonstruo)carta,"Boca Arriba","Ataque");
        assertEquals(false,lado.seleccionarCartaMonstruo("Dragon negro de Ojos Rojos").verificarSiEstaBocaAbajo());
        assertEquals(true,lado.seleccionarCartaMonstruo("Dragon negro de Ojos Rojos").verificarSiEstaBocaArriba());


    }


}
