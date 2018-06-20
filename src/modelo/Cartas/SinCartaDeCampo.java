package modelo.Cartas;

import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Lado;

public class SinCartaDeCampo extends CartaDeCampo {

    public SinCartaDeCampo(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void aplicarBuff(CartaMonstruo carta, Lado unLado) {

    }

    @Override
    public void aplicarBuffPrincipal(CartaMonstruo carta) {

    }

    @Override
    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta) {

    }

    @Override
    public void asignarLado(Lado unLado) {

    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

}
