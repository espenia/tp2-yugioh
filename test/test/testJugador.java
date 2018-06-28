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
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo1);
        assertEquals(true,jugador.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo1));

    }

    @Test
    public void testJugarCartaMagica(){
        Jugador jugador = new Jugador();
        Lado lado = new Lado(new Mazo());
        Lado ladoEnemigo = new Lado(new Mazo());
        jugador.asignarLados(lado,ladoEnemigo);
        CartaMagica cartaMagica = new OllaDeLaCodicia("olla");
        jugador.darCarta(cartaMagica);
        jugador.jugarCartaMagicaEnLado(cartaMagica);
        jugador.colocarEnEstadoBocaAbajo(cartaMagica);
        assertEquals(true ,jugador.verificarSiCartaDeUtilidadEstaEnLado(cartaMagica));

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
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo);
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo1);
        jugador.jugarCartaEnLadoConDosSacrificio(cartaMonstruo3,cartaMonstruo1, cartaMonstruo);
        assertEquals(true,jugador.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo3));

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
        jugador.jugarCartaMonstruoEnLado(cartaMonstruo);
        cartaMonstruo1.enPosicion(new PosicionAtaque());
        ladoEnemigo.jugarCartaMonstruo(cartaMonstruo1);
        cartaMonstruo.enPosicion(new PosicionAtaque());
        jugador.atacarAMonstruo(cartaMonstruo,cartaMonstruo1);
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, jugador.getPuntosDeVida(),DELTA);


    }







}
