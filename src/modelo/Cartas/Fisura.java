package modelo.Cartas;

import modelo.CartaMagica;
import modelo.Lado;

public class Fisura extends CartaMagica {

	public static String nombreDeCarta = "Fisura";
	
    public Fisura() {
        super(nombreDeCarta);
    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {
    	ladoEnemigo.matarMenorAtaque();
    }
}
