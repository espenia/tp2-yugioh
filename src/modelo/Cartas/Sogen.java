package modelo.Cartas;

import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Lado;

public class Sogen extends CartaDeCampo {

    private int buffDeDefensa = 500;
    private int buffDeAtaque = 200;
    private Lado lado;
    private Lado ladoEnemigo;
    private int aux = 1;

    public Sogen(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {


    }

    public void aplicarBuffPrincipal(CartaMonstruo carta){
        carta.aplicarBuff(buffDeDefensa,0);

    }

    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(0, buffDeAtaque);

    }


}