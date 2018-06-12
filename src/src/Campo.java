package src;

import java.util.Stack;

public class Campo {
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Lado ladoJugadorUno;
    private Lado ladoJugadorDos;


    public Campo(Jugador elJugadorUno,Jugador elJugadorDos){
        jugadorDos = elJugadorDos;
        jugadorUno = elJugadorUno;
        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();
        ladoJugadorUno = new Lado(mazo1);
        ladoJugadorDos = new Lado(mazo2);

    }

    public void jugarCartaUtilidad(CartaDeUtilidad unaCarta,String posicionDeLaCarta){

    }

    public void jugarCartaMonstruo(CartaMonstruo unaCarta,String posicionDeLaCarta,String modeDeLaCarta){

    }

    public Stack<Carta> extraerDelMazo(int cantidad) {
        return null;
    }
}
