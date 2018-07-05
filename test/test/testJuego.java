package test;

import modelo.*;
import modelo.Cartas.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testJuego {

    private static final double DELTA = 1e-2;

   @Test(expected = AccionInvalidaEnFaseException.class)
    public void test01FasesPrincipalExceptions(){
       Jugador juan = new Jugador();
       Jugador carlos= new Jugador();
       Juego juego = new Juego(juan,carlos);
       CartaMonstruo cartaPrueba1 = new AbismoReluciente();
       CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
       juan.darCarta(cartaPrueba1);
       juan.darCarta(cartaPrueba2);
       juan.jugarCartaMonstruoEnLado(cartaPrueba1);
       juan.colocarEnPosicionAtaque(cartaPrueba1);
       juan.colocarEnEstadoBocaArriba(cartaPrueba1);
       juan.jugarCartaMonstruoEnLado(cartaPrueba2);


   }

    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test02FasesPrincipalExceptions(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.atacar(cartaPrueba1, carlos);


    }




    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test04FasesBatallaExceptions(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMagica cartaPrueba2 = new CartaMagicaAgujeroOscuro();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juan.atacar(cartaPrueba1, carlos);
        juan.jugarCartaMagicaEnLado(cartaPrueba2);


    }

    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test05FasesBatallaExceptions(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaDeCampo cartaPrueba2 = new Sogen();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juan.atacar(cartaPrueba1, carlos);
        juan.colocarCartaDeCampo(cartaPrueba2);


    }
    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test06FasesBatallaExceptions(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juan.atacar(cartaPrueba1, carlos);
        juan.jugarCartaMonstruoEnLado(cartaPrueba2);


    }

    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test07FasesBatallaExceptions(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMagica cartaPrueba2 = new CartaMagicaAgujeroOscuro();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaMagicaEnLado(cartaPrueba2);
        juan.colocarEnEstadoBocaAbajo(cartaPrueba2);
        juego.siguenteFase();
        juan.atacar(cartaPrueba1, carlos);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);



    }

    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test08FasesFinalExceptions() {
        Jugador juan = new Jugador();
        Jugador carlos = new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMagica cartaPrueba2 = new CartaMagicaAgujeroOscuro();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaMagicaEnLado(cartaPrueba2);
        juan.colocarEnEstadoBocaAbajo(cartaPrueba2);
        juego.siguenteFase();
        juego.siguenteFase();
        juan.atacar(cartaPrueba1, carlos);
    }

    @Test(expected = AccionInvalidaEnFaseException.class)
    public void test09FasesFinalExceptions() {
        Jugador juan = new Jugador();
        Jugador carlos = new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba3 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba3);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juego.siguenteFase();
        juan.jugarCartaMonstruoEnLado(cartaPrueba3);

    }

    @Test(expected = NoEsTuTurnoException.class)
    public void test10NoEsTuTurnoException() {
        Jugador juan = new Jugador();
        Jugador carlos = new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba3 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba3);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba3);

    }

    @Test
    public void test11AtacarEnFaseDeBatalla() {
        Jugador juan = new Jugador();
        Jugador carlos = new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juan.atacar(cartaPrueba1, carlos);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }

    @Test
    public void test12JugarCartaCampoEnFasePrincipal(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaDeCampo cartaPrueba2 = new Sogen();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.colocarCartaDeCampo(cartaPrueba2);
        assertEquals(2100,cartaPrueba1.getDefensa());


    }

    @Test
    public void test13JugarCartaCampoEnFaseFinal(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaDeCampo cartaPrueba2 = new Sogen();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juego.siguenteFase();
        juan.colocarCartaDeCampo(cartaPrueba2);
        assertEquals(2100,cartaPrueba1.getDefensa());


    }

    @Test
    public void test14JugarCartaMagicaEnFaseFinal(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMagica cartaPrueba2 = new CartaMagicaAgujeroOscuro();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juego.siguenteFase();
        juego.siguenteFase();
        juan.jugarCartaMagicaEnLado(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        assertEquals(true,cartaPrueba1.estadoMuerto());

    }

    @Test
    public void test16JugarCartaMagicaEnFasePrincipal(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMagica cartaPrueba2 = new CartaMagicaAgujeroOscuro();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaMagicaEnLado(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        assertEquals(true,cartaPrueba1.estadoMuerto());

    }

    @Test
    public void test17TerminarTurnoInicialElTurnoDelOTroJugador(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        juego.siguenteFase();
        juego.siguenteFase();
        juego.siguenteFase();
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        carlos.darCarta(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba1);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.colocarEnPosicionAtaque(cartaPrueba1);
        juego.siguenteFase();
        carlos.atacar(cartaPrueba1,juan);
        assertEquals(6200,juan.getPuntosDeVida(),DELTA);

    }

    @Test
    public void test18TerminarTurnoAvanzaElTurnoIndmediatamente(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        juego.siguienteTurno();
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        carlos.darCarta(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba1);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.colocarEnPosicionAtaque(cartaPrueba1);
        juego.siguenteFase();
        carlos.atacar(cartaPrueba1,juan);
        assertEquals(6200,juan.getPuntosDeVida(),DELTA);
    }


    @Test(expected = NoEsTuTurnoException.class)
    public void test19TerminarTurnoCambiaElNoEsTuTurnoAlOtroJugador(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan,carlos);
        juego.siguienteTurno();
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba2);
        carlos.darCarta(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba1);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.colocarEnPosicionAtaque(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado(cartaPrueba2);

    }















}
