package modelo.Cartas;

import java.util.List;

import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Jugador;
import modelo.Mazo;

public class Wasteland extends CartaDeCampo {

    private int buffDeDefensa = 300;
    private int buffDeAtaque = 200;

    public Wasteland() {
        super("Wasteland");

    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    }



    public void aplicarBuffPrincipal(CartaMonstruo carta){
        carta.aplicarBuff(0,buffDeAtaque);

    }

    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(buffDeDefensa,0);

    }

    @Override
    public void revertirBuffDelLadoEnemigo(CartaMonstruo carta) {
        carta.aplicarBuff(-buffDeDefensa,0);
    }

    @Override
    public void revertirBuffPrincipal(CartaMonstruo carta) {
        carta.aplicarBuff(0,-buffDeAtaque);
    }


}
