package modelo.Cartas;

import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Lado;

public class Wasteland extends CartaDeCampo {

    private int buffDeDefensa = 300;
    private int buffDeAtaque = 200;

    public Wasteland(String nombreDeCarta) {
        super(nombreDeCarta);

    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {


    }



    public void aplicarBuffPrincipal(CartaMonstruo carta){
        carta.aplicarBuff(0,buffDeAtaque);

    }

    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(buffDeDefensa,0);

    }


}
