package modelo;

public class Juego {  //Fachada del juego

    public Juego (Jugador jugador1, Jugador jugador2){

        Lado ladoJugador1 = new Lado(new Mazo());
        Lado ladoJugador2 = new Lado(new Mazo());
        ladoJugador1.asignarJugador(jugador1);
        ladoJugador2.asignarJugador(jugador2);
        jugador1.asignarLados(ladoJugador1,ladoJugador2);
        jugador2.asignarLados(ladoJugador2,ladoJugador1);

    }

    //supongo que se manejara la parte grafica
}
