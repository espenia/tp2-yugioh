package modelo;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Cartas.*;

public class Juego {//esto quiza deberia ir en la parte grafica despues

    private Jugador primero;
    private Jugador segundo;
    private Jugador ganador;
    private Jugador perdedor;
    private Turno turno;

    public Juego (Jugador jugador1, Jugador jugador2){

        Lado ladoJugador1 = new Lado(new Mazo());
        Lado ladoJugador2 = new Lado(new Mazo());
        ladoJugador1.asignarJugador(jugador1);
        ladoJugador2.asignarJugador(jugador2);
        jugador1.asignarLados(ladoJugador1,ladoJugador2);
        jugador2.asignarLados(ladoJugador2,ladoJugador1);
        //primeroYSegundo(jugador1,jugador2); //TODO comentar para tests
        primero = jugador1; //TODO solo tests
        segundo = jugador2;
        //primerTurno(); // NO APLICABLE PARTA LOS TESTS

    }

    private void primeroYSegundo(Jugador jugador1, Jugador jugador2) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Collections.shuffle(jugadores);
        primero = jugadores.get(0);// el juego notifica quien va primero o segundo
        segundo = jugadores.get(1);

    }

    private void primerTurno(){
        turno = new Turno(primero,this);
        turno.skipFaseBatalla();
        turno.faseIncial();


    }

    public void faseBatalla(){//excepcion si ya hizo la fase batalla
        turno.faseBatalla();


    }

    public void siguienteTurno(){
        turno.terminarTurno(primero,segundo);


    }

    public void gano(Jugador jugador) {
        ganador = jugador;

    }

    public void empate() {
        ganador = null;

    }

    public void perdio(Jugador jugador) {
        perdedor = jugador;


    }

    public Jugador getGanador(){
        return ganador;

    }

    public Jugador getPerdedor(){
        return perdedor;

    }

    //supongo que se manejara la parte grafica
}
