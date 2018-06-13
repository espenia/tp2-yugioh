package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.*;


public class testGenerales {

    private static final double DELTA = 1e-2;
/* IMPORTANTE, LAS CARTAS MONSTRUO DEPENDIENDO LAS ESTRELLAS QUE TENGAN REQUIEREN QUE SE SACRIGIQUEN OTRAS CARTAS MONSTRUO ANTES PARA PODER SER INVOCADAS*/

    @Test
    public void test01ColocarMonstruoEnModoAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        juan.darCarta(cartaPrueba);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        juan.atacar(cartaSeleccionada, carlos);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
/*
    @Test (expected = NoPuedeAtacarEnModoDefensaExcepcion.class)
    public void test02ColocarMontruoEnModoDefensa() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        juan.darCarta(cartaPrueba);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        juan.atacar(cartaSeleccionada, carlos);
    }

    @Test
    public void test03ColocarCartaMagicaBocaAbajo() {//SE DEBEN IMPLEMENTAR LAS CARTAS MAGICAS
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        juan.darCarta(cartaPrueba);
        juan.darCarta("Agujero Oscuro");
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Agujero Oscuro"), "Boca Abajo", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        juan.atacar(cartaSeleccionada, carlos);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }

    @Test
    public void test04ColocarCartaTrampaBocaAbajo() {//SE DEBEN IMPLEMENTAR LAS CARTAS TRAMPA
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        juan.darCarta(cartaPrueba);
        carlos.darCarta("Cilindro magico");
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Cilindro magico"), "Boca Abajo", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        juan.atacar(cartaSeleccionada, carlos);
        int vidaEsperada = 5300;
        assertEquals(vidaEsperada, juan.puntosDeVida, DELTA);
    }

    @Test
    public void test05MandarCartaAlCementerio() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        juan.darCarta(cartaPrueba);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"));
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
    }

    @Test
    public void test06AtacarMonstruoQueTengaMenorAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 2400, 2000);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Dragon blanco de Ojos Azules");
        juan.atacar(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 7300;
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
    
    @Test
    public void test07AtacarMonstruoQueTengaMayorAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 2400, 3500);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Dragon blanco de Ojos Azules");
        juan.atacar(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
        int vidaEsperada = 7200;
        assertEquals(vidaEsperada, juan.puntosDeVida, DELTA);
    }
    
    @Test
    public void test08AtacarMonstruoQueTengaIgualAtaque(){
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 2400, 2700);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Dragon blanco de Ojos Azules");
        juan.atacar(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, juan.puntosDeVida, DELTA);
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
    
    @Test
    public void test09AtacarMonstruoConMenorDefensa(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 2400, 2700);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta2);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Dragon blanco de Ojos Azules");
        juan.atacar(cartaSeleccionada, cartaEnemiga);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
    
    @Test
    public void test10AtacarMonstruoConMayorDefensa(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 3000, 2700);
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta2);
        CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
        CartaMonstruo cartaEnemiga = carlos.seleccionarCartaDelCampo("Dragon blanco de Ojos Azules");
        juan.atacar(cartaSeleccionada, cartaEnemiga);
        assertEquals(0, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
    
    @Test
    public void test11AgujeroNegroDestruyeMonstruos(){
        Jugador juan = new Jugador();
        String estadoDeCarta1 = "Ataque";
        String estadoDeCarta2 = "Defensa";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 3000, 2700);
        juan.darCarta("Agujero Oscuro");
        juan.darCarta(cartaPrueba1);
        carlos.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta1);
        carlos.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Agujero Oscuro"), "Boca Arriba", estadoDeCarta1);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
        assertEquals(1, carlos.cantidadEnCementerio, DELTA);
        int vidaEsperada = 8000;
        assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
        assertEquals(vidaEsperada, juan.puntosDeVida, DELTA);
    }
    
    @Test
    public void test12MonstruoRequiereUnSacrificio() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 3000, 2700);
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"));
        juan.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta1);
        assertEquals(1, juan.cantidadEnCementerio, DELTA);
    }
    
    @Test
    public void test13MonstruoRequiereDosSacrificios() {
        Jugador juan = new Jugador();
        String estadoDeCarta = "Ataque";
        Jugador carlos= new Jugador();
        Juego juego = new Juego(juan, carlos);
        CartaMonstruo cartaPrueba1 = new CartaMonstruo("Dragon negro de Ojos Rojos", 2400, 2700);
        CartaMonstruo cartaPrueba2 = new CartaMonstruo("Dragon blanco de Ojos Azules", 3000, 2700);
        CartaMonstruo cartaPrueba3 = new CartaMonstruo("Dragon dorado de Ojos Carmesi", 15000, 15000);
        juan.darCarta(cartaPrueba1);
        juan.darCarta(cartaPrueba2);
        juan.darCarta(cartaPrueba3);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
        juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"), "Boca Arriba", estadoDeCarta);
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"));
        juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Dragon blanco de Ojos Azules"));
        juan.posicionarCartaEnLado(carlos.seleccionarCartaDeLaMano("Dragon dorado de Ojos Carmesi"), "Boca Arriba", estadoDeCarta1);
        assertEquals(2, juan.cantidadEnCementerio, DELTA);
    }*/
}
