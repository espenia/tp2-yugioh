package modelo.Cartas;

import java.util.List;

import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;
import modelo.Exceptions.LadoNoContieneCartaException;
import modelo.Mazo;

public class Fisura extends CartaMagica {

	
    public Fisura() {
        super("Fisura");
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    	if(monstruosEnemigos.isEmpty()) {
    		throw new LadoNoContieneCartaException();
    	}
    	CartaMonstruo monstruoDeMenorAtaque = monstruosEnemigos.get(0);
    	for (int i = 1; i < monstruosEnemigos.size(); i++) {
    	    CartaMonstruo actual = monstruosEnemigos.get(i); {
			if(actual.getAtaque() < monstruoDeMenorAtaque.getAtaque())
				monstruoDeMenorAtaque = actual;
    	    }
		}
    	monstruoDeMenorAtaque.estaMuerta();   	
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
