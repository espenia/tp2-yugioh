package test;

import modelo.*;
import modelo.Cartas.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testLado {


    @Test
    public void testJugarMonstruo(){
        CartaMonstruo carta = new DragonBlancoDeOjosAzules();
        Lado lado = new Lado(new Mazo());
        lado.jugarCartaMonstruo(carta);
        carta.enPosicion(new PosicionAtaque());
        assertEquals(carta,lado.seleccionarCartaMonstruo(carta.getNombre()));


    }


    @Test
    public void testJugarCartaMagicaBocaAbajo(){
        CartaMagica cartaMagica = new OllaDeLaCodicia("olla de la codicia");
        Lado lado = new Lado(new Mazo());
        lado.jugarCartaMagica(cartaMagica);
        cartaMagica.colocarEn(new EstadoBocaAbajo());
        assertEquals(cartaMagica,lado.seleccionarCartaDeUtilidad("olla de la codicia"));


    }

    @Test
    public void testJugarCartaTrampa(){
        CartaTrampa cartaTrampa = new CartaTrampaCilindroMagico("cilindro");
        Lado lado = new Lado(new Mazo());
        lado.jugarCartaTrampa(cartaTrampa,lado,new Lado(new Mazo()));
        assertEquals(cartaTrampa,lado.seleccionarCartaDeUtilidad("cilindro"));


    }

    @Test
    public void testJugarCartaDeCampo(){
        CartaDeCampo cartaDeCampo = new Wasteland("wasteland");
        Lado lado = new Lado(new Mazo());
        CartaMonstruo carta2 = new DragonBlancoDeOjosAzules();
        lado.jugarCartaMonstruo(carta2);
        carta2.enPosicion(new PosicionAtaque());
        lado.jugarCartaDeCampo(cartaDeCampo);
        CartaMonstruo carta = new AcechadorDelCraneo();
        lado.jugarCartaMonstruo(carta);
        carta.enPosicion(new PosicionAtaque());
        assertEquals(3200,lado.seleccionarCartaMonstruo("Dragon Blanco De Ojos Azules").getAtaque());
        assertEquals(1100,lado.seleccionarCartaMonstruo("Acechador Del Craneo").getAtaque());


    }
}
