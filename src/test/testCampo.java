package test;

import static org.junit.Assert.*;

import org.junit.Test;
import src.*;

public class testCampo {

	@Test
	public void testColocarCartaMonstruoEnAtaque() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		//jugador1.agregarCartaAlMazo();
		CartaMonstruo carta = new CartaMonstruo("Dragon negro de Ojos Rojos",2400,2700);
		Campo campoPrueba = new Campo(jugador1, jugador2);
		//jugador1.posicionarCartaEnLado(jugador1.seleccionarCartaDeLaMano("Dragon negro de Ojos Rojos","Boca Arriba","Ataque"));
		//jugador1.seleccionarCartaDelCampo("Dragon negro de Ojos Rojos").atacarA(jugador2);
		long vidaEsperada = 5300;
		//assertEquals(vidaEsperada, jugador2.puntosDeVida);
	}

}
