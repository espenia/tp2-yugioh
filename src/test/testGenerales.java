package test;

import src.*;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testGenerales {

    private static final double DELTA = 1e-2;


    @Test
    public void test01ColocarMonstruoEnModoAtaque(){//hardcodeado its a strart
    	Jugador juan = new Jugador();
    	String estadoDeCarta = "Ataque";
    	Jugador carlos= new Jugador();
    	Juego juego = new Juego(juan, carlos);
    	juan.darCarta("Dragon negro de Ojos Rojos");
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
    	CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
    	juan.atacar(cartaSeleccionada, carlos);
    	long vidaEsperada = 5300;
    	assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
    
    @Test (expected = NoPuedeAtacarEnModoDefensaExcepcion.class)
    public void test02ColocarMontruoEnModoDefensa() {
    	Jugador juan = new Jugador();
    	String estadoDeCarta = "Ataque";
    	Jugador carlos= new Jugador();
    	Juego juego = new Juego(juan, carlos);
    	juan.darCarta("Dragon negro de Ojos Rojos");
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
    	CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
    	juan.atacar(cartaSeleccionada, carlos);
    }
    
    @Test
    public void test03ColocarCartaMagicaBocaAbajo() {
    	Jugador juan = new Jugador();
    	String estadoDeCarta = "Ataque";
    	Jugador carlos= new Jugador();
    	Juego juego = new Juego(juan, carlos);
    	juan.darCarta("Dragon negro de Ojos Rojos");
    	juan.darCarta("Agujero Oscuro");
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Agujero Oscuro"), "Boca Abajo", estadoDeCarta);
    	CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
    	juan.atacar(cartaSeleccionada, carlos);
    	long vidaEsperada = 5300;
    	assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }
    
    @Test
    public void test04ColocarCartaTrampaBocaAbajo() {
    	Jugador juan = new Jugador();
    	String estadoDeCarta = "Ataque";
    	Jugador carlos= new Jugador();
    	Juego juego = new Juego(juan, carlos);
    	juan.darCarta("Dragon negro de Ojos Rojos");
    	carlos.darCarta("Cilindro magico");
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
    	carlos.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Cilindro magico"), "Boca Abajo", estadoDeCarta);
    	CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
    	juan.atacar(cartaSeleccionada, carlos);
    	long vidaEsperada = 5300;
    	assertEquals(vidaEsperada, juan.puntosDeVida, DELTA);
    }
    
    @Test
    public void test05MandarCartaAlCementerio() {
    	Jugador juan = new Jugador();
    	String estadoDeCarta = "Ataque";
    	Jugador carlos= new Jugador();
    	Juego juego = new Juego(juan, carlos);
    	juan.darCarta("Dragon negro de Ojos Rojos");
    	juan.darCarta("Monster Reborn");
    	juan.sacrificarCarta(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"));
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Monster Reborn"), "Boca Arriba", estadoDeCarta);
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
    	CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
    	juan.atacar(cartaSeleccionada, carlos);
    	long vidaEsperada = 5300;
    	assertEquals(vidaEsperada, juan.puntosDeVida, DELTA);
    }
}
