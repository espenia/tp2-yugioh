package modelo;

public class FaseIncial implements Fase {

    private Jugador jugador;
    private Juego juego;

    public FaseIncial(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;
        if(jugador.cantidadDeCartasEnMazo() == 0){
            juego.perdio(jugador);
            juego.terminarJuego();
        }
        else jugador.extraerCartasDelMazo();

        if(jugador.tieneExodiaEnMano()) {
            juego.gano(jugador);
            juego.terminarJuego();
        }
    }


    @Override
    public Fase cambiarFase() throws NoHayMasFasesException {
        return new FasePrincipal(jugador,juego);
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
