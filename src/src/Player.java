package src;

import java.util.List;

public class Player {
    private int LifePoints;
    private int CantidadDeCartasMano;
    private int CantidadDeCartasMazo;
    private int CantidadDeCartasCementerio;
    private List<Cards> Hand;
    private Deck Mazo;
    private List<Cards> Cementery;

    public Player () { //Multiton 2
        LifePoints = 8000;
        CantidadDeCartasMano = 7; // No me acuerdo con cuantas empezas
        CantidadDeCartasMazo = 30;
        CantidadDeCartasCementerio = 0;
        Mazo = new Deck();
        //Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
        //Mazo.draw(7);
    }

}
