package test;

import static org.junit.Assert.assertEquals;

import modelo.Cartas.*;
import org.junit.Test;
import modelo.*;

import java.util.Stack;


public class testGenerales {

    private static final double DELTA = 1e-2;

    @Test
    public void test01ColocarMonstruosEnModoAtaqueYRealizarUnAtaque(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Juego juego = new Juego(jugador1, jugador2);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        jugador1.darCarta(cartaPrueba);
        jugador1.colocarEnPosicionAtaque(cartaPrueba);
        jugador1.colocarEnEstadoBocaArriba(cartaPrueba);
        jugador1.jugarCartaMonstruoEnLado("Abismo Reluciente");
        jugador1.atacar("Abismo Reluciente",jugador2);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, jugador2.getPuntosDeVida(), DELTA);
    }

    @Test 
    public void test02ColocarMontruoEnModoDefensa() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Juego juego = new Juego(jugador1, jugador2);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        jugador1.darCarta(cartaPrueba);
        jugador1.colocarEnPosicionAtaque(cartaPrueba);
        jugador1.colocarEnEstadoBocaArriba(cartaPrueba);
        jugador1.jugarCartaMonstruoEnLado("Abismo Reluciente");
        CartaMonstruo cartaSeleccionada = jugador1.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente");
        assertEquals(cartaPrueba, cartaSeleccionada);
    }

    @Test
    public void test03ColocarCartaMagicaBocaAbajo() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaMagicaAgujeroOscuro agujeroOscuro = new CartaMagicaAgujeroOscuro("Agujero Oscuro");
        juan.darCarta(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        juan.darCarta(agujeroOscuro);
        juan.colocarEnEstadoBocaArriba(agujeroOscuro);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        juan.jugarCartaMagicaEnLado("Agujero Oscuro");
        juan.atacar("Abismo Reluciente",carlos);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }


    @Test
    public void test04ColocarCartaTrampaBocaAbajo() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaTrampa cilindroMagico = new CartaTrampaCilindroMagico("Cilindro magico");
        juan.darCarta(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        carlos.darCarta(cilindroMagico);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.jugarCartaTrampaEnLado("Cilindro magico");
        carlos.colocarEnEstadoBocaAbajo(cilindroMagico);
        assertEquals(cilindroMagico,carlos.seleccionarCartaDeUtilidadDeMiLado("Cilindro magico"));
    }

    @Test
    public void test05AtacarUnMonstruoConMenorAtaqueMataAlOtroMonstruo() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        juan.jugarCartaEnLadoConUnSacrificio("Acechador Del Craneo","Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").estadoMuerto());
        assertEquals(cartaPrueba2,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo"));
    }

    @Test
    public void test06AtacarMonstruoQueTengaMenorAtaque(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Abismo Reluciente", "Acechador Del Craneo");
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test07AtacarMonstruoQueTengaMayorAtaque(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test08AtacarMonstruoQueTengaIgualAtaque(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Abismo Reluciente", "Abismo Reluciente");
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").estadoMuerto());
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").estadoMuerto());
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test09AtacarMonstruoConMenorDefensa(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Abismo Reluciente", "Acechador Del Craneo");
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test10AtacarMonstruoConMayorDefensa(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(cartaPrueba2, carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente"));
        assertEquals(cartaPrueba1, juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo"));
        int vidaEsperada = 7300;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }
    
    @Test
    public void test11AgujeroNegroDestruyeMonstruos(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMagicaAgujeroOscuro agujeroOscuro = new CartaMagicaAgujeroOscuro("Agujero Oscuro");
        juan.darCarta(agujeroOscuro);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.jugarCartaMagicaEnLado("Agujero Oscuro");
        juan.colocarEnEstadoBocaArriba(agujeroOscuro);
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").estadoMuerto());
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());

    }
    
    @Test
    public void test12MonstruoRequiereUnSacrificio() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AligatorCibertech();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaEnLadoConUnSacrificio("Aligator Cibertech","Acechador Del Craneo");
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
    }
    
    @Test
    public void test13MonstruoRequiereDosSacrificios() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMonstruo cartaPrueba3 = new Conedragon();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.darCarta(cartaPrueba3);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado("Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.jugarCartaEnLadoConDosSacrificio("ConeDragon", "Acechador Del Craneo","Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba3);
        juan.colocarEnEstadoBocaArriba(cartaPrueba3);
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").estadoMuerto());
        assertEquals(true,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
    }

    //segunda entrega

    @Test
    public void test14ActivarCartaDeCampoWasteland(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaDeCampo cartaCampo = new Wasteland("Weasteland");
        juan.darCarta(cartaCampo);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarCartaDeCampo(cartaCampo); 
        assertEquals(1100,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").getAtaque());
        assertEquals(800,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").getDefensa());
        assertEquals(1900,carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").getDefensa());
        assertEquals(1800,carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").getAtaque());
        CartaMonstruo cartaPrueba3 = new Conedragon();
        carlos.darCarta(cartaPrueba3);
        carlos.jugarCartaMonstruoEnLado("ConeDragon");
        carlos.colocarEnEstadoBocaArriba(cartaPrueba3);
        carlos.colocarEnPosicionDefensa(cartaPrueba3);
        assertEquals(3200,carlos.seleccionarCartaMonstruoDeMiLado("ConeDragon").getDefensa());
        assertEquals(2950,carlos.seleccionarCartaMonstruoDeMiLado("ConeDragon").getAtaque());

    }

    @Test
    public void test15ActivarCartaDeCampoSogen(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaDeCampo cartaCampo = new Sogen("Sogen");
        juan.darCarta(cartaCampo);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarCartaDeCampo(cartaCampo); 
        assertEquals(900,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").getAtaque());
        assertEquals(1300,juan.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").getDefensa());
        assertEquals(1600,carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").getDefensa());
        assertEquals(2000,carlos.seleccionarCartaMonstruoDeMiLado("Abismo Reluciente").getAtaque());
        CartaMonstruo cartaPrueba3 = new Conedragon();
        carlos.darCarta(cartaPrueba3);
        carlos.jugarCartaMonstruoEnLado("ConeDragon");
        carlos.colocarEnEstadoBocaArriba(cartaPrueba3);
        carlos.colocarEnPosicionDefensa(cartaPrueba3);
        assertEquals(2900,carlos.seleccionarCartaMonstruoDeMiLado("ConeDragon").getDefensa());
        assertEquals(3150,carlos.seleccionarCartaMonstruoDeMiLado("ConeDragon").getAtaque());

    }

    @Test
    public void test16OllaDeLaCodiciaExtraeDosCartas(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMonstruo cartaPrueba3 = new Conedragon();
        CartaMagica olla = new OllaDeLaCodicia("Olla De La Codicia");
        juan.darCarta(olla);
        Mazo mazo = new Mazo();
        mazo.agregarCarta(cartaPrueba1);
        mazo.agregarCarta(cartaPrueba2);
        mazo.agregarCarta(cartaPrueba3);
        juan.darMazo(mazo);
        juan.jugarCartaMagicaEnLado("Olla De La Codicia");
        juan.colocarEnEstadoBocaArriba(olla);
        assertEquals(cartaPrueba2,juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        assertEquals(cartaPrueba3,juan.seleccionarCartaDeLaMano("ConeDragon"));
        assertEquals(1, juan.cantidadDeCartasEnMazo());

    }

    @Test
    public void test17FisuraMataMonstruoEnemigoDeMenorAtaque(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMagica fisura = new Fisura();
        juan.darCarta(fisura);
        carlos.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        carlos.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        carlos.colocarEnPosicionAtaque(cartaPrueba1);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Abismo Reluciente");
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.jugarCartaMagicaEnLado("Fisura");
        juan.colocarEnEstadoBocaArriba(fisura);
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());

    }

    @Test
    public void test18CartaJinzoPuedeAtacarDirectoAunqueHayaMonstruosDelLadoEnemigo(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new Jinzo7();
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado("Jinzo #7");
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        int vidaEsperada = 7500;
        carlos.atacar("Jinzo #7",juan);
        assertEquals(vidaEsperada,juan.getPuntosDeVida(),DELTA);

    }

    @Test
    public void test19CilindroMagicoHaceEnemigoAtacarseASiMismo(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        CartaTrampa cilindroMagico = new CartaTrampaCilindroMagico("Cilindro magico");
        carlos.darCarta(cilindroMagico);
        carlos.jugarCartaTrampaEnLado("Cilindro magico");
        juan.atacar("Acechador Del Craneo",carlos);
        int vidaEsperada = 7100;
        assertEquals(vidaEsperada,juan.getPuntosDeVida(),DELTA);


    }

    @Test
    public void test20Tener0CartasEnElMazoCausaPerderElJuegoAlFinalDeTuTurno(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        Mazo mazo = new Mazo();
        Mazo mazo2 = new Mazo();
        mazo.agregarCarta(cartaPrueba1);
        mazo2.agregarCarta(cartaPrueba1);
        juan.darMazo(mazo);
        carlos.darMazo(mazo2);
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        assertEquals(false, juego.getPartidaEnCurso());
        assertEquals(carlos,juego.getPerdedor());
    }

    @Test
    public void test21TenerLas5cartasDeExodiaEnLaManoGanaElJuego(){
        Jugador carlos= new Jugador();
        Jugador juan = new Jugador();
        Juego juego = new Juego(carlos,juan);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba3 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba4 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba5 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba6 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba7 = new AcechadorDelCraneo();
        CartaMonstruo exodiaPieIzq = new PieIzquierdoDeExodia();
        CartaMonstruo exodiaPieDer = new PieDerechoDeExodia();
        CartaMonstruo exodiaManoIzq = new BrazoIzquierdoDeExodia();
        CartaMonstruo exodiaManoDer = new BrazoDerechoDeExodia();
        CartaMonstruo exodiaCabeza = new Exodia();
        Mazo mazo = new Mazo();
        Mazo mazo2 = new Mazo();
        mazo.agregarCarta(cartaPrueba1);
        mazo.agregarCarta(cartaPrueba2);
        mazo.agregarCarta(cartaPrueba3);
        mazo.agregarCarta(cartaPrueba4);
        mazo.agregarCarta(cartaPrueba5);
        mazo.agregarCarta(cartaPrueba6);
        mazo.agregarCarta(cartaPrueba7);
        Stack<Carta> cartas = new Stack<>();
        cartas.add(exodiaCabeza);
        cartas.add(exodiaManoDer);
        cartas.add(exodiaManoIzq);
        cartas.add(exodiaPieDer);
        cartas.add(exodiaPieIzq);
        mazo2.armarMazo(cartas);
        juan.darMazo(mazo);
        carlos.darMazo(mazo2);
        while(juego.getPartidaEnCurso() == true)
        	juego.siguienteTurno();
        assertEquals(false, juego.getPartidaEnCurso());
        assertEquals(carlos,juego.getGanador());

    }

    @Test
    public void test22InvocarTresDragonesBlancosDeOjosAzulesYLuegoSacrificarlosInvocaAlDragonBlancoDefinitivoDeOjosAzules(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new DragonBlancoDeOjosAzules();
        CartaMonstruo cartaPrueba2 = new DragonBlancoDeOjosAzules();
        CartaMonstruo cartaPrueba3 = new DragonBlancoDeOjosAzules();
        CartaMonstruo cartaMonstruo = new DragonBlancoDefinitivoDeOjosAzules();
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.darCarta(cartaPrueba3);
        Mazo mazo = new Mazo();
        mazo.agregarCarta(cartaMonstruo);
        juan.darMazoDeFusiones(mazo);
        juan.jugarCartaMonstruoEnLado("Dragon Blanco De Ojos Azules");
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado("Dragon Blanco De Ojos Azules");
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado("Dragon Blanco De Ojos Azules");
        juan.colocarEnEstadoBocaArriba(cartaPrueba3);
        juan.colocarEnPosicionAtaque(cartaPrueba3);
        CartaMagica polimerizacion = new Polimerizacion("Polimerizacion");
        juan.darCarta(polimerizacion);
        juan.jugarCartaMagicaEnLado("Polimerizacion");
        juan.colocarEnEstadoBocaArriba(polimerizacion);
        juan.fusionDeTresMonstruos("Dragon Blanco De Ojos Azules","Dragon Blanco De Ojos Azules","Dragon Blanco De Ojos Azules");
        assertEquals(cartaPrueba1,juan.seleccionarCartaMonstruoDeMiLado("Dragon Blanco De Ojos Azules"));
        assertEquals(cartaPrueba2,juan.seleccionarCartaMonstruoDeMiLado("Dragon Blanco De Ojos Azules"));
        assertEquals(cartaPrueba3,juan.seleccionarCartaMonstruoDeMiLado("Dragon Blanco De Ojos Azules"));

    }
/*
    @Test
    public void test23InsectoComeHombreDestruyeUnMonstruoQueLoAtacaCuandoEstaBocaAbajo(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaMonstruo = new InsectoComeHombre();
        CartaMonstruo cartaMonstruo2 = new AcechadorDelCraneo();
        juan.darCarta(cartaMonstruo);
        carlos.darCarta(cartaMonstruo2);
        juan.jugarCartaMonstruoEnLado("Insecto Come-Hombre");
        juan.colocarEnEstadoBocaAbajo(cartaMonstruo);
        juan.colocarEnPosicionAtaque(cartaMonstruo);
        carlos.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        carlos.colocarEnEstadoBocaArriba(cartaMonstruo2);
        carlos.colocarEnPosicionAtaque(cartaMonstruo2);
        carlos.atacarAMonstruo("Acechador Del Craneo","Insecto Come-Hombre");
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
        assertEquals(8000,juan.getPuntosDeVida(),DELTA);


    }

    @Test
    public void test24AlAtacarUnMonstruoReinforcementsDa400PuntosMasDeAtaqueAlMonstruoAtacado(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaMonstruo = new AcechadorDelCraneo();
        CartaMonstruo cartaMonstruo2 = new AcechadorDelCraneo();
        CartaTrampa reinforcements = new Reinforcements("Reinforcements");
        juan.darCarta(reinforcements);
        juan.darCarta(cartaMonstruo);
        carlos.darCarta(cartaMonstruo2);
        juan.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        juan.colocarEnEstadoBocaAbajo(cartaMonstruo);
        juan.colocarEnPosicionAtaque(cartaMonstruo);
        carlos.jugarCartaMonstruoEnLado("Acechador Del Craneo");
        carlos.colocarEnEstadoBocaArriba(cartaMonstruo2);
        carlos.colocarEnPosicionAtaque(cartaMonstruo2);
        juan.jugarCartaTrampaEnLado("Reinforcements");
        carlos.atacarAMonstruo("Acechador Del Craneo","Acechador Del Craneo");
        assertEquals(true,carlos.seleccionarCartaMonstruoDeMiLado("Acechador Del Craneo").estadoMuerto());
        assertEquals(7600,carlos.getPuntosDeVida(),DELTA);


    }*/


}
