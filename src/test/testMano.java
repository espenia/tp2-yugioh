package test;

import src.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testMano {

    @Test
    public void testAgregarCartaAMano(){
        Mazo mazo = new Mazo();
        Monstruo carta1 = new Monstruo("Dragon negro de Ojos Rojos",2400,2700);
        mazo.agregarCarta(carta1);
        Mano mano = new Mano(mazo,new Campo());
        mano.extraerCarta();
        assertEquals(carta1,mano.devolverCarta("Dragon negro de Ojos Rojos"));


    }



}
