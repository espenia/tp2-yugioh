package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.*;


public class testGenerales {

    private static final double DELTA = 1e-2;
/* IMPORTANTE, LAS CARTAS MONSTRUO DEPENDIENDO LAS ESTRELLAS QUE TENGAN REQUIEREN QUE SE SACRIGIQUEN OTRAS CARTAS MONSTRUO ANTES PARA PODER SER INVOCADAS*/

    @Test
    public void test01ColocarMonstruoEnModoAtaque(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Juego juego = new Juego(jugador1, jugador2);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        jugador1.darCarta(cartaPrueba);
        jugador1.posicionarCartaEnLado(jugador1.seleccionarCartaDeLaMano("Abismo Reluciente"),
        "Boca Arriba", "Ataque");
        CartaMonstruo cartaSeleccionada = jugador1.seleccionarCartaDelCampo("Abismo Reluciente");
        jugador1.atacarAlEnemigo(cartaSeleccionada);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, jugador2.getPuntosDeVida(), DELTA);
    }

    @Test // TODO (expected = NoPuedeAtacarEnModoDefensaExcepcion.class) 
    public void test02ColocarMontruoEnModoDefensa() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Juego juego = new Juego(jugador1, jugador2);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        jugador1.darCarta(cartaPrueba);
        jugador1.posicionarCartaEnLado(jugador1.seleccionarCartaDeLaMano("Abismo Reluciente"),
        "Boca Arriba", "Defensa");
        CartaMonstruo cartaSeleccionada = jugador1.seleccionarCartaDelCampo("Abismo Reluciente");
        assertEquals(cartaPrueba, cartaSeleccionada);
    }

    @Test
    public void test03ColocarCartaMagicaBocaAbajo() {//SE DEBEN IMPLEMENTAR LAS CARTAS MAGICAS
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        juan.darCarta(cartaPrueba);
        juan.darCarta("Agujero Oscuro");
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Agujero Oscuro"), "Boca Abajo", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Abismo Reluciente");
        juan.atacarAlJugador(cartaSeleccionada);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }

    @Test
    public void test04ColocarCartaTrampaBocaAbajo() {//SE DEBEN IMPLEMENTAR LAS CARTAS TRAMPA
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        juan.darCarta(cartaPrueba);
        carlos.darCarta("Cilindro magico");
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Cilindro magico"), "Boca Abajo", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Abismo Reluciente");
        juan.atacarAlJugador(cartaSeleccionada);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }

    @Test
    public void test05MandarCartaAlCementerio() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        juan.darCarta(cartaPrueba);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
    }

    @Test
    public void test06AtacarMonstruoQueTengaMenorAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Abismo Reluciente");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Acechador Del Craneo");
        juan.atacarAlMonstruoEnemigo(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test07AtacarMonstruoQueTengaMayorAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Acechador Del Craneo");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Abismo Reluciente");
        juan.atacarAlMonstruoEnemigo(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test08AtacarMonstruoQueTengaIgualAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Abismo Reluciente");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Abismo Reluciente");
        juan.atacarAlMonstruoEnemigo(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test09AtacarMonstruoConMenorDefensa(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta2);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Abismo Reluciente");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Acechador Del Craneo");
        juan.atacarAlMonstruoEnemigo(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test10AtacarMonstruoConMayorDefensa(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta2);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Acechador Del Craneo");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Abismo Reluciente");
        juan.atacarAlMonstruoEnemigo(cartaSeleccionada, cartaEnemiga);
        assertEquals(0, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test11AgujeroNegroDestruyeMonstruos(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta("Agujero Oscuro");
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Agujero Oscuro"), "Boca Arriba", estadoDeCarta1);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test12MonstruoRequiereUnSacrificio() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AligatorCibertech();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta);
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        juan.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Aligator Cibertech"), "Boca Arriba", estadoDeCarta1);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
    }
    
    @Test
    public void test13MonstruoRequiereDosSacrificios() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMonstruo cartaPrueba3 = new Conedragon();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.darCarta(cartaPrueba3);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta);
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        juan.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Conedragon"), "Boca Arriba", estadoDeCarta1);
        assertEquals(2, juan.cantidadEnCementerio, DELTA);
    }
}
