package test;

import src.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testCarta {


    @Test
    public void compararAtaqueDeMonstruos(){

        Monstruo carta2 = new Monstruo("Dragon blanco de Ojos Azules",2500, 3000);
        Monstruo carta1 = new Monstruo("Dragon negro de Ojos Rojos",2400,2700);
        assertEquals(-300,carta1.compararAtaqueDeMonstruo(carta2));


    }

    @Test
    public void compararDefensaConAtaqueDeMonstruos(){
        Monstruo carta2 = new Monstruo("Dragon blanco de Ojos Azules",2500, 3000);
        Monstruo carta1 = new Monstruo("Dragon negro de Ojos Rojos",2400,2700);
        assertEquals(200,carta1.compararDefensaDeMonstruo(carta2));

    }

}
