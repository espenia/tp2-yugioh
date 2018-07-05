package modelo.Cartas;

import java.util.List;

import modelo.*;

public class Polimerizacion extends CartaMagica {


    public Polimerizacion() {
        super("Polimerizacion");
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    	jugador.habilitarFusion(new Fusion());

    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
