package Cartas;

import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Lado;

public class Wasteland extends CartaDeCampo {

    private int buffDeDefensa = 300;
    private int buffDeAtaque = 200;
    private Lado lado;
    private Lado ladoEnemigo;
    private int aux = 1;

    public Wasteland(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {


    }

    @Override
    public void asignarLado(Lado unLado){
        if(aux == 1) {
            lado = unLado;
            aux+=1;
        }
        else ladoEnemigo = unLado;
    }

    @Override
    public void aplicarBuff(CartaMonstruo carta,Lado unLado) {
        if(lado == unLado)
            aplicarBuffPrincipal(carta);
        else aplicarBuffDelLadoEnemigo(carta);

    }

    private void aplicarBuffPrincipal(CartaMonstruo carta){
        carta.aplicarBuff(0,buffDeAtaque);

    }

    private void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(buffDeDefensa,0);

    }


}
