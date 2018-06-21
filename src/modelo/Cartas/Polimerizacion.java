package modelo.Cartas;

import modelo.CartaMagica;
import modelo.Lado;

public class Polimerizacion extends CartaMagica {


    public Polimerizacion(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {
        lado.habilitarFusion();

    }
}
