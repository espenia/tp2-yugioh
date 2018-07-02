package test;

import modelo.*;
import modelo.Cartas.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testJugador {

    private static final double DELTA = 1e-2;

    //tests sin assert buscan que no hayan excepciones

    @Test
    public void testJugarMonstruo(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLadosYJugadores(lado,ladoEnemigo,new Jugador());
        CartaMonstruo cartaMonstruo1 = new AbismoReluciente();
        jugador.darCarta(cartaMonstruo1);
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo1);
        jugador.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo1);

    }

    @Test
    public void testJugarCartaMagica(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLadosYJugadores(lado,ladoEnemigo,new Jugador());
        CartaMagica cartaMagica = new OllaDeLaCodicia();
        jugador.darCarta(cartaMagica);
        jugador.jugarCartaMagicaEnLado(cartaMagica);
        jugador.colocarEnEstadoBocaAbajo(cartaMagica);
        jugador.verificarSiCartaDeUtilidadEstaEnLado(cartaMagica);

    }


    @Test
    public void testJugarMonstruoConDosSacrificio(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLadosYJugadores(lado,ladoEnemigo,new Jugador());
        CartaMonstruo cartaMonstruo = new AcechadorDelCraneo();
        CartaMonstruo cartaMonstruo1 = new AbismoReluciente();
        CartaMonstruo cartaMonstruo3 = new DragonBlancoDeOjosAzules();
        jugador.darCarta(cartaMonstruo);
        jugador.darCarta(cartaMonstruo1);
        jugador.darCarta(cartaMonstruo3);
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo);
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo1);
        jugador.jugarCartaEnLadoConDosSacrificio(cartaMonstruo3,cartaMonstruo1, cartaMonstruo);
        jugador.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo3);

    }

    @Test
    public void testAtacarAUnMonstruoConMayorAtaque(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLadosYJugadores(lado,ladoEnemigo,new Jugador());
        CartaMonstruo cartaMonstruo = new AcechadorDelCraneo();
        CartaMonstruo cartaMonstruo1 = new AbismoReluciente();
        jugador.darCarta(cartaMonstruo);
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo);
        cartaMonstruo1.enPosicion(new PosicionAtaque());
        ladoEnemigo.jugarCartaMonstruo(cartaMonstruo1);
        cartaMonstruo.enPosicion(new PosicionAtaque());
        jugador.atacarAMonstruo(cartaMonstruo,cartaMonstruo1);
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, jugador.getPuntosDeVida(),DELTA);


    }



}
