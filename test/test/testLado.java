package test;

import modelo.*;
import modelo.Cartas.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testLado {

    //tests sin assert buscan que no hayan excepciones

    @Test
    public void testJugarMonstruo(){
        CartaMonstruo carta = new DragonBlancoDeOjosAzules();
        Lado lado = new Lado(new Mazo());
        lado.jugarCartaMonstruo(carta);
        carta.enPosicion(new PosicionAtaque());
        lado.verificarSiCartaMonstruoEstaEnLado(carta);


    }


    @Test
    public void testJugarCartaMagicaBocaAbajo(){
        CartaMagica cartaMagica = new OllaDeLaCodicia();
        Lado lado = new Lado(new Mazo());
        lado.jugarCartaMagica(cartaMagica);
        cartaMagica.colocarEn(new EstadoBocaAbajo());
        lado.verificarSiCartaDeUtilidadEstaEnLado(cartaMagica);


    }

    @Test
    public void testJugarCartaTrampa(){
        CartaTrampa cartaTrampa = new CartaTrampaCilindroMagico();
        Lado lado = new Lado(new Mazo());
        lado.jugarCartaTrampa(cartaTrampa,lado,new Lado(new Mazo()));
        lado.verificarSiCartaDeUtilidadEstaEnLado(cartaTrampa);


    }

    @Test
    public void testJugarCartaDeCampo(){
        CartaDeCampo cartaDeCampo = new Wasteland();
        Lado lado = new Lado(new Mazo());
        CartaMonstruo carta2 = new DragonBlancoDeOjosAzules();
        lado.jugarCartaMonstruo(carta2);
        carta2.enPosicion(new PosicionAtaque());
        lado.jugarCartaDeCampo(cartaDeCampo);
        CartaMonstruo carta = new AcechadorDelCraneo();
        lado.jugarCartaMonstruo(carta);
        carta.enPosicion(new PosicionAtaque());
        assertEquals(3200,carta2.getAtaque());
        assertEquals(1100,carta.getAtaque());


    }
}
