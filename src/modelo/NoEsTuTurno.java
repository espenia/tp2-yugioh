package modelo;

import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Exceptions.NoEsTuTurnoException;

public class NoEsTuTurno implements Fase {


    public NoEsTuTurno(Jugador jugador, Juego juego) {
    }

    @Override
    public Fase cambiarFase() throws NoEsTuTurnoException {
        throw new NoEsTuTurnoException();
    }

    @Override
    public void jugarCartaMonstruo() throws AccionInvalidaEnFaseException, NoEsTuTurnoException{
        throw new NoEsTuTurnoException();

    }

    @Override
    public void jugarCartaDeUtilidad() throws AccionInvalidaEnFaseException, NoEsTuTurnoException{
        throw new NoEsTuTurnoException();
    }

    @Override
    public void jugarCartaDeCampo() throws AccionInvalidaEnFaseException, NoEsTuTurnoException{
        throw new NoEsTuTurnoException();
    }

    @Override
    public void atacar() throws AccionInvalidaEnFaseException, NoEsTuTurnoException{
        throw new NoEsTuTurnoException();
    }

    @Override
    public void activarCartaMagica() throws AccionInvalidaEnFaseException, NoEsTuTurnoException{
        throw new NoEsTuTurnoException();
    }

	@Override
	public String obtenerFase() {
		return null;
	}
}
