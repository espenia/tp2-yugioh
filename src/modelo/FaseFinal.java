package modelo;

public class FaseFinal implements Fase {

    private Jugador jugador;
    private Juego juego;



    public FaseFinal(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;
    }


    @Override
    public Fase cambiarFase(){
        juego.siguienteTurno();
        return null;

    }

    @Override
    public void jugarCartaMonstruo() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }

    @Override
    public void jugarCartaDeUtilidad() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }

    @Override
    public void jugarCartaDeCampo() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }


    @Override
    public void atacar() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }

    @Override
    public void activarCartaMagica() throws AccionInvalidaEnFaseException {
        throw new AccionInvalidaEnFaseException();
    }


}
