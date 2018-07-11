package modelo;

import modelo.Cartas.*;
import modelo.Exceptions.ManoNoContieneCartaException;

import java.util.ArrayList;
import java.util.List;

public class Mano {

    private List<Carta> manoDeCartas;



    public Mano(){
        manoDeCartas = new ArrayList<>();


    }

    public void agregarCarta(Carta carta){
        manoDeCartas.add(carta);

    }

    public void removerCarta(Carta carta) throws ManoNoContieneCartaException {
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
            if (i instanceof BrazoIzquierdoDeExodia)
                brazoIzquierdo = true;
            if (i instanceof PieDerechoDeExodia)
                piernaDerecho = true;
            if (i instanceof PieIzquierdoDeExodia)
                piernaIzquierda = true;
            if (i instanceof Exodia)
                exodia = true;
        }

        if (exodia && piernaDerecho && piernaIzquierda && brazoDerecho && brazoIzquierdo)
            return true;
        return false;


    }

    public List<Carta> getCartasEnMano() {
        return manoDeCartas;
    }
}
