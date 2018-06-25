package test;

import modelo.*;
import modelo.Cartas.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testJugador {

    private static final double DELTA = 1e-2;

    @Test
    public void testJugarMonstruo(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLados(lado,ladoEnemigo);
        CartaMonstruo cartaMonstruo1 = new AbismoReluciente();
        jugador.darCarta(cartaMonstruo1);
        jugador.jugarCartaMonstruoEnLado("Abismo Reluciente");
        assertEquals(cartaMonstruo1,jugador.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente"));

    }

    @Test
    public void testJugarCartaMagica(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLados(lado,ladoEnemigo);
        CartaMagica cartaMagica = new OllaDeLaCodicia("olla");
        jugador.darCarta(cartaMagica);
        jugador.jugarCartaMagicaEnLado("olla");
        jugador.colocarEnEstadoBocaAbajo(cartaMagica);
        assertEquals(cartaMagica,jugador.seleccionarCartaDeUtilidadDeMiLado("olla"));

    }


    @Test
    public void testJugarMonstruoConDosSacrificio(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLados(lado,ladoEnemigo);
        CartaMonstruo cartaMonstruo = new AcechadorDelCraneo();
        CartaMonstruo cartaMonstruo1 = new AbismoReluciente();
        CartaMonstruo cartaMonstruo3 = new DragonBlancoDeOjosAzules();
        jugador.darCarta(cartaMonstruo);
        jugador.darCarta(cartaMonstruo1);
        jugador.darCarta(cartaMonstruo3);
        jugador.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        jugador.jugarCartaMonstruoEnLado("Abismo Reluciente");
        jugador.jugarCartaEnLadoConDosSacrificio("Dragon Blanco De Ojos Azules","Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(cartaMonstruo3,jugador.seleccionarCartaMonstruoDeMiLado("Dragon Blanco De Ojos Azules"));

    }

    @Test
    public void testAtacarAUnMonstruoConMayorAtaque(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLados(lado,ladoEnemigo);
        CartaMonstruo cartaMonstruo = new AcechadorDelCraneo();
        CartaMonstruo cartaMonstruo1 = new AbismoReluciente();
        jugador.darCarta(cartaMonstruo);
        jugador.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        cartaMonstruo1.enPosicion(new PosicionAtaque());
        ladoEnemigo.jugarCartaMonstruo(cartaMonstruo1);
        cartaMonstruo.enPosicion(new PosicionAtaque());
        jugador.atacarAMonstruo("Acechador Del Craneo","Abismo Reluciente");
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, jugador.getPuntosDeVida(),DELTA);


    }







}
