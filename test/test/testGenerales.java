package test;

import static org.junit.Assert.assertEquals;

import modelo.Cartas.*;
import org.junit.Test;
import modelo.*;

import java.util.HashMap;
import java.util.Map;
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
        jugador1.jugarCartaMonstruoEnLado(cartaPrueba);
        jugador1.atacar(cartaPrueba,jugador2);
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
        jugador1.jugarCartaMonstruoEnLado(cartaPrueba);
        assertEquals(true, jugador1.verificarSiCartaMonstruoEstaEnLado(cartaPrueba));
    }

    @Test
    public void test03ColocarCartaMagicaBocaAbajo() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaMagicaAgujeroOscuro agujeroOscuro = new CartaMagicaAgujeroOscuro();
        juan.darCarta(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        juan.darCarta(agujeroOscuro);
        juan.colocarEnEstadoBocaArriba(agujeroOscuro);
        juan.jugarCartaMonstruoEnLado(cartaPrueba);
        juan.jugarCartaMagicaEnLado(agujeroOscuro);
        juan.atacar(cartaPrueba,carlos);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }


    @Test
    public void test04ColocarCartaTrampaBocaAbajo() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaTrampa cilindroMagico = new CartaTrampaCilindroMagico();
        juan.darCarta(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        carlos.darCarta(cilindroMagico);
        juan.jugarCartaMonstruoEnLado(cartaPrueba);
        carlos.jugarCartaTrampaEnLado(cilindroMagico);
        carlos.colocarEnEstadoBocaAbajo(cilindroMagico);
        assertEquals(true,carlos.verificarSiCartaDeUtilidadEstaEnLado(cilindroMagico));
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        juan.jugarCartaEnLadoConUnSacrificio(cartaPrueba2,cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        assertEquals(true,cartaPrueba.estadoMuerto());
        assertEquals(true,juan.verificarSiCartaMonstruoEstaEnLado(cartaPrueba2));
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo(cartaPrueba1, cartaPrueba2);
        assertEquals(true,cartaPrueba2.estadoMuerto());
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo(cartaPrueba1, cartaPrueba2);
        assertEquals(true,cartaPrueba1.estadoMuerto());
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo(cartaPrueba1, cartaPrueba2);
        assertEquals(true,cartaPrueba1.estadoMuerto());
        assertEquals(true,cartaPrueba2.estadoMuerto());
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo(cartaPrueba1, cartaPrueba2);
        assertEquals(true,cartaPrueba2.estadoMuerto());
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo(cartaPrueba1, cartaPrueba2);
        assertEquals(true, carlos.verificarSiCartaMonstruoEstaEnLado(cartaPrueba2));
        assertEquals(true, juan.verificarSiCartaMonstruoEstaEnLado(cartaPrueba1));
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
        CartaMagicaAgujeroOscuro agujeroOscuro = new CartaMagicaAgujeroOscuro();
        juan.darCarta(agujeroOscuro);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.jugarCartaMagicaEnLado(agujeroOscuro);
        juan.colocarEnEstadoBocaArriba(agujeroOscuro);
        assertEquals(true,cartaPrueba1.estadoMuerto());
        assertEquals(true,cartaPrueba2.estadoMuerto());

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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaEnLadoConUnSacrificio(cartaPrueba2,cartaPrueba1);
        assertEquals(true,cartaPrueba1.estadoMuerto());
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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado(cartaPrueba2);
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.jugarCartaEnLadoConDosSacrificio(cartaPrueba3, cartaPrueba1,cartaPrueba2);
        juan.colocarEnPosicionAtaque(cartaPrueba3);
        juan.colocarEnEstadoBocaArriba(cartaPrueba3);
        assertEquals(true,cartaPrueba1.estadoMuerto());
        assertEquals(true,cartaPrueba2.estadoMuerto());
    }

    //segunda entrega

    @Test
    public void test14ActivarCartaDeCampoWasteland(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaDeCampo cartaCampo = new Wasteland();
        juan.darCarta(cartaCampo);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarCartaDeCampo(cartaCampo); 
        assertEquals(1100,cartaPrueba1.getAtaque());
        assertEquals(800,cartaPrueba1.getDefensa());
        assertEquals(1900,cartaPrueba2.getDefensa());
        assertEquals(1800,cartaPrueba2.getAtaque());
        CartaMonstruo cartaPrueba3 = new Conedragon();
        carlos.darCarta(cartaPrueba3);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba3);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba3);
        carlos.colocarEnPosicionDefensa(cartaPrueba3);
        assertEquals(3200,cartaPrueba3.getDefensa());
        assertEquals(2950,cartaPrueba3.getAtaque());

    }

    @Test
    public void test15ActivarCartaDeCampoSogen(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaDeCampo cartaCampo = new Sogen();
        juan.darCarta(cartaCampo);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarCartaDeCampo(cartaCampo); 
        assertEquals(900,cartaPrueba1.getAtaque());
        assertEquals(1300,cartaPrueba1.getDefensa());
        assertEquals(1600,cartaPrueba2.getDefensa());
        assertEquals(2000,cartaPrueba2.getAtaque());
        CartaMonstruo cartaPrueba3 = new Conedragon();
        carlos.darCarta(cartaPrueba3);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba3);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba3);
        carlos.colocarEnPosicionDefensa(cartaPrueba3);
        assertEquals(2900,cartaPrueba3.getDefensa());
        assertEquals(3150,cartaPrueba3.getAtaque());

    }

    @Test
    public void test16OllaDeLaCodiciaExtraeDosCartas(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        CartaMonstruo cartaPrueba2 = new AbismoReluciente();
        CartaMonstruo cartaPrueba3 = new Conedragon();
        CartaMagica olla = new OllaDeLaCodicia();
        juan.darCarta(olla);
        Mazo mazo = new Mazo();
        mazo.agregarCarta(cartaPrueba1);
        mazo.agregarCarta(cartaPrueba2);
        mazo.agregarCarta(cartaPrueba3);
        juan.darMazo(mazo);
        juan.jugarCartaMagicaEnLado(olla);
        juan.colocarEnEstadoBocaArriba(olla);
        assertEquals(true,juan.verificarSiCartaEstaEnMano(cartaPrueba2));
        assertEquals(true,juan.verificarSiCartaEstaEnMano(cartaPrueba3));
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
        carlos.jugarCartaMonstruoEnLado(cartaPrueba1);
        carlos.colocarEnPosicionAtaque(cartaPrueba1);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.jugarCartaMagicaEnLado(fisura);
        juan.colocarEnEstadoBocaArriba(fisura);
        assertEquals(true,cartaPrueba1.estadoMuerto());

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
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.jugarCartaMonstruoEnLado(cartaPrueba2);
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        int vidaEsperada = 7500;
        carlos.atacar(cartaPrueba2,juan);
        assertEquals(vidaEsperada,juan.getPuntosDeVida(),DELTA);

    }

    @Test
    public void test19CilindroMagicoHaceEnemigoAtacarseASiMismo(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        CartaTrampa cilindroMagico = new CartaTrampaCilindroMagico();
        carlos.darCarta(cilindroMagico);
        carlos.jugarCartaTrampaEnLado(cilindroMagico);
        juan.atacar(cartaPrueba1,carlos);
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
        Map<String ,CartaMonstruo> mazo = new HashMap<>();
        mazo.put(cartaMonstruo.getNombre(),cartaMonstruo);
        juan.darMazoDeFusiones(mazo);
        juan.jugarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.jugarCartaMonstruoEnLado(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.jugarCartaMonstruoEnLado(cartaPrueba3);
        juan.colocarEnEstadoBocaArriba(cartaPrueba3);
        juan.colocarEnPosicionAtaque(cartaPrueba3);
        CartaMagica polimerizacion = new Polimerizacion();
        juan.darCarta(polimerizacion);
        juan.jugarCartaMagicaEnLado(polimerizacion);
        juan.colocarEnEstadoBocaArriba(polimerizacion);
        juan.fusionDeTresMonstruos(cartaPrueba1,cartaPrueba2,cartaPrueba3);
        assertEquals(true,juan.verificarSiCartaMonstruoEstaEnLado(cartaMonstruo));

    }

    @Test
    public void test23InsectoComeHombreDestruyeUnMonstruoQueLoAtacaCuandoEstaBocaAbajo(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaMonstruo = new InsectoComeHombre();
        CartaMonstruo cartaMonstruo2 = new AcechadorDelCraneo();
        juan.darCarta(cartaMonstruo);
        carlos.darCarta(cartaMonstruo2);
        juan.jugarCartaMonstruoEnLado(cartaMonstruo);
        juan.colocarEnEstadoBocaAbajo(cartaMonstruo);
        juan.colocarEnPosicionAtaque(cartaMonstruo);
        carlos.jugarCartaMonstruoEnLado(cartaMonstruo2);
        carlos.colocarEnEstadoBocaArriba(cartaMonstruo2);
        carlos.colocarEnPosicionAtaque(cartaMonstruo2);
        carlos.atacarAMonstruo(cartaMonstruo,cartaMonstruo2);
        assertEquals(true,cartaMonstruo2.estadoMuerto());


    }

    @Test
    public void test24AlAtacarUnMonstruoReinforcementsDa400PuntosMasDeAtaqueAlMonstruoAtacado(){
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaMonstruo = new AcechadorDelCraneo();
        CartaMonstruo cartaMonstruo2 = new AcechadorDelCraneo();
        CartaTrampa reinforcements = new Reinforcements();
        juan.darCarta(reinforcements);
        juan.darCarta(cartaMonstruo);
        carlos.darCarta(cartaMonstruo2);
        juan.jugarCartaMonstruoEnLado(cartaMonstruo);
        juan.colocarEnEstadoBocaAbajo(cartaMonstruo);
        juan.colocarEnPosicionAtaque(cartaMonstruo);
        carlos.jugarCartaMonstruoEnLado(cartaMonstruo2);
        carlos.colocarEnEstadoBocaArriba(cartaMonstruo2);
        carlos.colocarEnPosicionAtaque(cartaMonstruo2);
        juan.jugarCartaTrampaEnLado(reinforcements);
        carlos.atacarAMonstruo(cartaMonstruo2,cartaMonstruo);
        assertEquals(true,cartaMonstruo2.estadoMuerto());
        assertEquals(8000,juan.getPuntosDeVida(),DELTA);
        assertEquals(7600,carlos.getPuntosDeVida(),DELTA);



    }


}
