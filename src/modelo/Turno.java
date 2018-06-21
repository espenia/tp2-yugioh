package modelo;

public class Turno {

    private Jugador jugador;
    private Juego juego;
    private boolean skipBattle;


    public Turno(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;

    }



    public void faseIncial(){
        if(jugador.extraerCartasDelMazo(1) == false){
        	juego.gano(jugador.ladoEnemigo.obtenerJugador());
        	juego.perdio(jugador);
        	juego.terminarJuego();
        }
        if(jugador.tieneExodiaEnMano()) {
            juego.gano(jugador);
        	juego.perdio(jugador.ladoEnemigo.obtenerJugador());
        	juego.terminarJuego();
        }
        fasePrincipal();
    }

    public void fasePrincipal(){//excepcion trata de atacar cuando esta aca
        //mostraria que cosas se pueden hacer (invocar jugar cartas magicas etc

    }

    public void skipFaseBatalla() { //excepciones trata de hacer algo que no es atacar
        skipBattle = true;
    }

    public void faseBatalla() {
        if (skipBattle == true) {
            skipBattle = false;
            juego.siguienteTurno();
        }



        //aca se admite declarar Ataques

    }

    public void terminarTurno(Jugador jugador1, Jugador jugador2){
        if(jugador1.getPuntosDeVida() == 0 && jugador2.getPuntosDeVida() == 0)
            juego.empate();

        if(jugador.getPuntosDeVida() == 0)
            juego.perdio(jugador);

        if(jugador == jugador1){
            jugador = jugador2;
            faseIncial();

        }
        else {
            jugador = jugador1;
            faseIncial();

        }

    }



}
