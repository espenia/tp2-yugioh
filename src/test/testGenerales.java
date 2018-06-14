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
        jugador1.atacar("Abismo Reluciente",jugador2);
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
        CartaMonstruo cartaSeleccionada = jugador1.seleccionarCartaDeMiLado("Abismo Reluciente");
        assertEquals(cartaPrueba, cartaSeleccionada);
    }
/*
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
        juan.atacar("Abismo Reluciente",carlos);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
*/
/*
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
        juan.atacar("Abismo Reluciente",carlos);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }
*/
    @Test
    public void test05MandarCartaAlCementerio() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba);
        juan.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(cartaPrueba,"Boca Arriba", estadoDeCarta);
        juan.posicionarCartaEnLadoConUnSacrificio(cartaPrueba2,"BocaArrbia","Ataque","Abismo Reluciente");
        assertEquals((Carta)cartaPrueba, juan.seleccionarCartaEnCementerio("Abismo Reluciente"));
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
        juan.atacarAMonstruo("Abismo Reluciente", "Acechador Del Craneo");
        assertEquals(cartaPrueba2,carlos.seleccionarCartaEnCementerio("Acechador Del Craneo"));
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
        juan.atacarAMonstruo("Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(cartaPrueba1,juan.seleccionarCartaEnCementerio("Acechador Del Craneo"));
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
        juan.atacarAMonstruo("Abismo Reluciente", "Abismo Reluciente");
        assertEquals(cartaPrueba1, juan.seleccionarCartaEnCementerio("Abismo Reluciente"));
        assertEquals(cartaPrueba2, carlos.seleccionarCartaEnCementerio("Abismo Reluciente"));
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    /*@Test
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
        juan.atacarAMonstruo("Abismo Reluciente", "Acechador Del Craneo");
        assertEquals(cartaPrueba1, carlos.seleccionarCartaEnCementerio("Abismo Reluciente"));
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }*/
    
   /* @Test
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
        juan.atacarAMonstruo("Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(0, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }*/
    
    @Test
    public void test11AgujeroNegroDestruyeMonstruos(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMagicaAgujeroOscuro agujeroOscuro = new CartaMagicaAgujeroOscuro("agujeroOscuro");
        juan.darCarta(agujeroOscuro);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Acechador Del Craneo"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Abismo Reluciente"), "Boca Arriba", estadoDeCarta2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Agujero Oscuro"), "Boca Arriba", estadoDeCarta1);
        assertEquals(1, juan.cantidadEnCementerio());
        assertEquals(1, carlos.cantidadEnCementerio());
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
        juan.posicionarCartaEnLado(cartaPrueba1, "Boca Arriba", "Ataque");
        juan.posicionarCartaEnLadoConUnSacrificio(cartaPrueba2,"Boca Arriba","Ataque","Acechador Del Craneo");
        assertEquals(cartaPrueba1, juan.seleccionarCartaEnCementerio("Acechador Del Craneo"));
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
        juan.posicionarCartaEnLado(cartaPrueba1, "Boca Arriba","Ataque");
        juan.posicionarCartaEnLado(cartaPrueba2, "Boca Arriba","Ataque");
        juan.posicionarCartaEnLadoConDosSacrificio(cartaPrueba3, "Boca Arriba","Ataque","Acechador Del Craneo","Abismo Reluciente");
        assertEquals(cartaPrueba2,juan.seleccionarCartaEnCementerio("Abismo Reluciente"));
        assertEquals(cartaPrueba1,juan.seleccionarCartaEnCementerio("Acechador Del Craneo"));
    }
}
