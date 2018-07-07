package modelo;

import java.util.ArrayList;
import java.util.Collections;

import modelo.Exceptions.NoHayMasFasesException;

public class Juego {

    private Jugador primero;
    private Jugador segundo;
    private Jugador actual;
    private Jugador ganador;
    private Jugador perdedor;
    private Fase fase;
    private Fase noEsTuTurno;
    private boolean partidaEnJuego;

    public Juego (Jugador jugador1, Jugador jugador2){

        Lado ladoJugador1 = new Lado(new Mazo());
        Lado ladoJugador2 = new Lado(new Mazo());
        jugador1.asignarLadosYJugadores(ladoJugador1,ladoJugador2,jugador2);
        jugador2.asignarLadosYJugadores(ladoJugador2,ladoJugador1,jugador1);
        primeroYSegundo(jugador1,jugador2);
        this.primero = jugador1; //TODO solo tests
        this.segundo = jugador2;
        this.partidaEnJuego = true;
        this.actual = primero;
        this.fase = new FaseIncial(this.primero,this);
        siguenteFase();
        this.noEsTuTurno = new NoEsTuTurno(segundo,this);
        segundo.asignarFase(noEsTuTurno);

    }

    private void primeroYSegundo(Jugador jugador1, Jugador jugador2) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Collections.shuffle(jugadores);
        this.primero = jugadores.get(0);// el juego notifica quien va primero o segundo
        this.segundo = jugadores.get(1);

    }

    public void siguenteFase() {
        try {
            this.fase = this.fase.cambiarFase();
            actual.asignarFase(fase);
        }
        catch (NoHayMasFasesException ex){
            siguienteTurno();
        }



    }



    public void siguienteTurno(){
        primero.refrescarAtaques();
        segundo.refrescarAtaques();

        if(this.primero.getPuntosDeVida() == 0 && this.segundo.getPuntosDeVida() == 0)
            empate();

        if(this.actual.getPuntosDeVida() == 0)
            perdio(this.actual);

        if(this.actual == this.primero){
            this.actual = this.segundo;
            primero.asignarFase(noEsTuTurno);
        }

        else{
            this.actual = this.primero;
            segundo.asignarFase(noEsTuTurno);
        }

        this.fase = new FaseIncial(this.actual,this);
        this.actual.asignarFase(this.fase);
        siguenteFase();

    }

    public void gano(Jugador jugador) {
    	this.ganador = jugador;

    }

    public void empate() {
    	this.ganador = null;

    }

    public void perdio(Jugador jugador) {
    	this.perdedor = jugador;


    }

    public Jugador getGanador(){
        return this.ganador;

    }

    public Jugador getPerdedor(){
        return this.perdedor;

    }

	public boolean getPartidaEnCurso() {
		return this.partidaEnJuego;
	}

	public void terminarJuego() {
		this.partidaEnJuego = false;
	}

    public Jugador getActual() {
        return actual;
    }

    //supongo que se manejara la parte grafica
}
