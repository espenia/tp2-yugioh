package modelo;

import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Exceptions.NoHayMasFasesException;

public class FaseFinal implements Fase {

    private Jugador jugador;
    private Juego juego;



    public FaseFinal(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;
        jugador = unJugador;
    }


    @Override
    public Fase cambiarFase() throws NoHayMasFasesException {
        throw new NoHayMasFasesException();

    }

    @Override
    public void jugarCartaMonstruo() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }

    @Override
    public void jugarCartaDeUtilidad() throws AccionInvalidaEnFaseException {

    }

    @Override
    public void jugarCartaDeCampo() throws AccionInvalidaEnFaseException {

    }


    @Override
    public void atacar() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }

    @Override
    public void activarCartaMagica() throws AccionInvalidaEnFaseException {

    }


}
