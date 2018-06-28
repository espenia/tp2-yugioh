package modelo.Cartas;

import java.util.List;

import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Jugador;
import modelo.Mazo;

public class Sogen extends CartaDeCampo {

    private int buffDeDefensa = 500;
    private int buffDeAtaque = 200;

    public Sogen(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, boolean fusion) {


    }

    public void aplicarBuffPrincipal(CartaMonstruo carta){
        carta.aplicarBuff(buffDeDefensa,0);

    }

    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(0, buffDeAtaque);

    }


}