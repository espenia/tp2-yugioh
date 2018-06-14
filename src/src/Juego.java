package src;

public class Juego {  //Fachada del juego

    public Juego (Jugador jugador1, Jugador jugador2){
        Lado ladoJugador1 = new Lado(new Mazo(),jugador1);
        Lado ladoJugador2 = new Lado(new Mazo(),jugador2);

    }

    //supongo que se manejara la parte grafica
}
