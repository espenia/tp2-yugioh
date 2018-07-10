package modelo;

import modelo.Cartas.CartaBocaAbajo;
import modelo.Cartas.CartaBocaAbajoDeUtilidad;

public class EstadoBocaAbajo implements EstadoDeCarta{


    @Override
    public Carta estadoDeCarta(Carta carta) {
        if (carta instanceof CartaMonstruo)
            return new CartaBocaAbajo();
        else return new CartaBocaAbajoDeUtilidad();

    }
}
