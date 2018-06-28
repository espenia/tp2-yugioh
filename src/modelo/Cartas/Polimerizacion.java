package modelo.Cartas;

import java.util.List;

import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class Polimerizacion extends CartaMagica {


    public Polimerizacion(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, boolean fusion) {
        fusion = true;

    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
