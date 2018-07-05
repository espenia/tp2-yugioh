package modelo;

import modelo.Cartas.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mano {

    private List<Carta> manoDeCartas;



    public Mano(){
        manoDeCartas = new ArrayList<>();


    }

    public void agregarCarta(Carta carta){
        manoDeCartas.add(carta);

    }

    public void removerCarta(Carta carta) throws ManoNoContieneCartaException{
        if (!manoDeCartas.remove(carta))
            throw new ManoNoContieneCartaException();


    }

    public boolean verificarSiCartaEstaEnMano(Carta carta){
        return manoDeCartas.contains(carta);

    }

    public boolean contieneExodia() {
        boolean brazoDerecho = false;
        boolean brazoIzquierdo = false;
        boolean piernaDerecho = false;
        boolean piernaIzquierda = false;
        boolean exodia = false;

        for (Carta i : this.manoDeCartas){
            if (i instanceof BrazoDerechoDeExodia)
                brazoDerecho = true;
            if (i instanceof BrazoDerechoDeExodia)
                brazoIzquierdo = true;
            if (i instanceof BrazoDerechoDeExodia)
                piernaDerecho = true;
            if (i instanceof BrazoDerechoDeExodia)
                piernaIzquierda = true;
            if (i instanceof BrazoDerechoDeExodia)
                exodia = true;
        }

        if (exodia && piernaDerecho && piernaIzquierda && brazoDerecho && brazoIzquierdo)
            return true;
        return false;


    }

}
