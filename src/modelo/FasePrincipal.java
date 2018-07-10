package modelo;

import modelo.Exceptions.AccionInvalidaEnFaseException;

public class FasePrincipal implements Fase {

    private Jugador jugador;
    private Juego juego;
    private String nombreFase;

    public FasePrincipal(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;
        this.nombreFase = "Fase Principal";
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

    @Override
	public String obtenerFase() {
		return this.nombreFase;
	}



}
