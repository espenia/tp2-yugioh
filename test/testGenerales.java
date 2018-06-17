
import static org.junit.Assert.assertEquals;

import Cartas.*;
import org.junit.Test;
import modelo.*;


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
        jugador1.colocarEnPosicionAtaque(cartaPrueba);
        jugador1.colocarEnEstadoBocaArriba(cartaPrueba);
        jugador1.posicionarCartaMonstruoEnLado((CartaMonstruo)jugador1.seleccionarCartaDeLaMano("Abismo Reluciente"));
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
        jugador1.colocarEnPosicionAtaque(cartaPrueba);
        jugador1.colocarEnEstadoBocaArriba(cartaPrueba);
        jugador1.posicionarCartaMonstruoEnLado((CartaMonstruo)jugador1.seleccionarCartaDeLaMano("Abismo Reluciente"));
        CartaMonstruo cartaSeleccionada = jugador1.seleccionarCartaDeMiLado("Abismo Reluciente");
        assertEquals(cartaPrueba, cartaSeleccionada);
    }

    @Test
    public void test03ColocarCartaMagicaBocaAbajo() {//SE DEBEN IMPLEMENTAR LAS CARTAS MAGICAS
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        juan.posicionarCartaMagicaEnLado((CartaMagica)juan.seleccionarCartaDeLaMano("Agujero Oscuro"));
        juan.atacar("Abismo Reluciente",carlos);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
    }


    @Test
    public void test04ColocarCartaTrampaBocaAbajo() {//SE DEBEN IMPLEMENTAR LAS CARTAS TRAMPA
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaTrampa cilindroMagico = new CartaTrampaCilindroMagico("Cilindro magico");
        juan.darCarta(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        carlos.darCarta(cilindroMagico);
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        carlos.posicionarCartaTrampaEnLado((CartaTrampa)carlos.seleccionarCartaDeLaMano("Cilindro magico"));
        juan.atacar("Abismo Reluciente",carlos);
        int vidaEsperada = 6200;
        assertEquals(vidaEsperada, juan.getPuntosDeVida(), DELTA);
    }

    @Test
    public void test05MandarCartaAlCementerio() {
        Jugador juan = new Jugador();
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new AbismoReluciente();
        CartaMonstruo cartaPrueba2 = new AcechadorDelCraneo();
        juan.darCarta(cartaPrueba);
        juan.darCarta(cartaPrueba2);
        juan.posicionarCartaMonstruoEnLado(cartaPrueba);
        juan.colocarEnPosicionAtaque(cartaPrueba);
        juan.colocarEnEstadoBocaArriba(cartaPrueba);
        juan.posicionarCartaEnLadoConUnSacrificio(cartaPrueba2,"Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        assertEquals((Carta)cartaPrueba, juan.seleccionarCartaEnCementerio("Abismo Reluciente"));
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.posicionarCartaMonstruoEnLado((CartaMonstruo)carlos.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Abismo Reluciente", "Acechador Del Craneo");
        assertEquals(cartaPrueba2,carlos.seleccionarCartaEnCementerio("Acechador Del Craneo"));
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.posicionarCartaMonstruoEnLado((CartaMonstruo)carlos.seleccionarCartaDeLaMano("Abismo Reluciente"));
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(cartaPrueba1,juan.seleccionarCartaEnCementerio("Acechador Del Craneo"));
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.posicionarCartaMonstruoEnLado((CartaMonstruo)carlos.seleccionarCartaDeLaMano("Abismo Reluciente"));
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Abismo Reluciente", "Abismo Reluciente");
        assertEquals(cartaPrueba1, juan.seleccionarCartaEnCementerio("Abismo Reluciente"));
        assertEquals(cartaPrueba2, carlos.seleccionarCartaEnCementerio("Abismo Reluciente"));
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Abismo Reluciente"));
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.posicionarCartaMonstruoEnLado((CartaMonstruo)carlos.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Abismo Reluciente", "Acechador Del Craneo");
        assertEquals(cartaPrueba2, carlos.seleccionarCartaEnCementerio("Acechador Del Craneo"));
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.posicionarCartaMonstruoEnLado((CartaMonstruo)carlos.seleccionarCartaDeLaMano("Abismo Reluciente"));
        carlos.colocarEnPosicionDefensa(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.atacarAMonstruo("Acechador Del Craneo", "Abismo Reluciente");
        assertEquals(cartaPrueba2, carlos.seleccionarCartaDeMiLado("Abismo Reluciente"));
        assertEquals(cartaPrueba1, juan.seleccionarCartaDeMiLado("Acechador Del Craneo")); //creo que se destruye la carta
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.getPuntosDeVida(), DELTA);
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
        juan.posicionarCartaMonstruoEnLado((CartaMonstruo)juan.seleccionarCartaDeLaMano("Acechador Del Craneo"));
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        carlos.posicionarCartaMonstruoEnLado((CartaMonstruo)carlos.seleccionarCartaDeLaMano("Abismo Reluciente"));
        carlos.colocarEnPosicionAtaque(cartaPrueba2);
        carlos.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(agujeroOscuro);
        juan.posicionarCartaMagicaEnLado((CartaMagica)juan.seleccionarCartaDeLaMano("Agujero Oscuro"));//falta implementar
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
        juan.posicionarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.posicionarCartaEnLadoConUnSacrificio(cartaPrueba2,"Acechador Del Craneo");
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
        juan.posicionarCartaMonstruoEnLado(cartaPrueba1);
        juan.colocarEnPosicionAtaque(cartaPrueba1);
        juan.colocarEnEstadoBocaArriba(cartaPrueba1);
        juan.posicionarCartaMonstruoEnLado(cartaPrueba2);
        juan.colocarEnPosicionAtaque(cartaPrueba2);
        juan.colocarEnEstadoBocaArriba(cartaPrueba2);
        juan.posicionarCartaEnLadoConDosSacrificio(cartaPrueba3, "Acechador Del Craneo","Abismo Reluciente");
        juan.colocarEnPosicionAtaque(cartaPrueba3);
        juan.colocarEnEstadoBocaArriba(cartaPrueba3);
        assertEquals(cartaPrueba2,juan.seleccionarCartaEnCementerio("Abismo Reluciente"));
        assertEquals(cartaPrueba1,juan.seleccionarCartaEnCementerio("Acechador Del Craneo"));
    }
}
