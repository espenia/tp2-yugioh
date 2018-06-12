package test;

import src.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testJuego {

    private static final double DELTA = 1e-2;

    @Test
    public void testInicial(){

        Juego juego = new Juego(new Jugador(),new Jugador());
        //test graficos supongo?

    }
    
    @Test
    public void testColocarUnaCartaEnPosicionAtaque() {
    	Jugador juan = new Jugador();
    	String estadoDeCarta = "Ataque";
    	Jugador carlos= new Jugador();
    	Juego juego = new Juego(juan, carlos);
    	juego.nuevoJuegoSoloMonstruos();
    	juan.posicionarCartaEnLado(juan.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos"), "Boca Arriba", estadoDeCarta);
    	CartaMonstruo cartaSeleccionada = juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos");
    	juan.atacar(cartaSeleccionada, carlos);
    	long vidaEsperada = 5300;
    	assertEquals(vidaEsperada, carlos.puntosDeVida, DELTA);
    }


}
