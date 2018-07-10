package modelo;

import modelo.Cartas.CartaBocaAbajo;

public class EstadoBocaAbajo implements EstadoDeCarta{


    @Override
    public Carta estadoDeCarta(Carta carta) {
        return new CartaBocaAbajo();

    }
}
