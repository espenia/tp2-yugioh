package modelo;

import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Exceptions.NoHayMasFasesException;

public class FaseFinal implements Fase {

    private Jugador jugador;
    private Juego juego;
    private String nombreFase;


    public FaseFinal(Jugador unJugador, Juego elJuego){
        juego = elJuego;
        jugador = unJugador;
        nombreFase = "Fase Final";
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


	@Override
	public String obtenerFase() {
		return this.nombreFase;
	}


}
