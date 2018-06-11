package src;

import java.util.List;

public class Jugador {
    private int lifePoints;
    private int cantidadDeCartasMano;
    private int cantidadDeCartasMazo;
    private int cantidadDeCartasCementerio;
    private List<Carta> mano;
    private Mazo mazo;
    private List<Carta> cementerio;

    public Jugador () { //Multiton 2
    	this.lifePoints = 8000;
    	this.cantidadDeCartasMano = 7; // No me acuerdo con cuantas empezas
    	this.cantidadDeCartasMazo = 30;
    	this.cantidadDeCartasCementerio = 0;
    	this.mazo = new Mazo();
        //Mazo.armarMazo(); // supongo que vamos a tener 2 mazos estandar para testear
        //Mazo.draw(7);
    }

}
