package modelo.Cartas;

import java.util.List;

import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Fusion;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class Polimerizacion extends CartaMagica {


    public Polimerizacion() {
        super("Polimerizacion");
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion) {
    	fusion = fusion.habilitarFusion();

    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
