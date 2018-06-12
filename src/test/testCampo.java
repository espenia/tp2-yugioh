package test;

import static org.junit.Assert.*;

import org.junit.Test;
import src.*;

public class testCampo {

	@Test
	public void testColocarCartaMonstruoEnAtaque() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Campo campoPrueba = new Campo(jugador1, jugador2);
		jugador1.mano.add(new Monstruo("Dragon negro de Ojos Rojos",2400,2700));
		jugador1.posicionarCartaEnLado(jugador1.seleccionarCartaDeLaMano());
		jugador1.seleccionarCartaDelCampo().atacarA(jugador2);
		long vidaEsperada = 5300;
		assertEquals(vidaEsperada, jugador2.lifePoints);
	}

}
