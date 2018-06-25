package test;

import modelo.CartaMonstruo;
import modelo.Cartas.AcechadorDelCraneo;
import modelo.Cartas.DragonBlancoDeOjosAzules;
import modelo.PosicionAtaque;
import modelo.PosicionDefensa;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testCarta {


    @Test
    public void testAtacarAMonstruoEnPosicionAtaque(){

    	CartaMonstruo carta2 = new AcechadorDelCraneo();
    	carta2.enPosicion(new PosicionAtaque());
    	CartaMonstruo carta1 = new DragonBlancoDeOjosAzules();
    	carta1.enPosicion(new PosicionAtaque());
        assertEquals(2100,carta1.atacarAMonstruo(carta2));



    }


    @Test
    public void testAtacarAMonstruoEnPosicionDefensaConMenorDefensaDestruyeAlOtro(){

        CartaMonstruo carta2 = new AcechadorDelCraneo();
        carta2.enPosicion(new PosicionDefensa());
        CartaMonstruo carta1 = new DragonBlancoDeOjosAzules();
        carta1.enPosicion(new PosicionAtaque());
        assertEquals(2200,carta1.atacarAMonstruo(carta2));


    }


}
