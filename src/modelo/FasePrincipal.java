package modelo;

public class FasePrincipal implements Fase {

    private Jugador jugador;
    private Juego juego;

    public FasePrincipal(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;

    }

    private boolean monstruoJugado = false;


    @Override
    public Fase cambiarFase() {
        return new FaseBatalla(jugador,juego);
    }

    @Override
    public void jugarCartaMonstruo() throws AccionInvalidaEnFaseException {
        if (monstruoJugado)
            throw new AccionInvalidaEnFaseException();
        monstruoJugado = true;

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
