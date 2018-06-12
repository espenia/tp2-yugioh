package test;

import src.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testJuego {

    private static final double DELTA = 1e-2;

    @Test
    public void testInicial(){

        Juego juego = new Juego();
        //test graficos supongo?

    }
    
    @Test
    public void testColocarUnaCartaEnPosicionAtaque() {
    	Jugador juan;
    	Jugador carlos;
    	Juego juego = new Juego(juan, carlos);
    	juego.nuevoJuegoSoloMonstruos();
    	juan.jugarCarta("Dragon negro de Ojos Rojos", this.ataque);
    	juan.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos").atacarA(carlos);
    	long vidaEsperada = 5300;
    	assertEquals(vidaEsperada, carlos.lifePoints, DELTA);
    }


}
