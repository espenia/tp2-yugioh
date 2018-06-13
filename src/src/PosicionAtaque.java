package src;

public class PosicionAtaque extends DecoradorDeEstado {

    public PosicionAtaque(Estado estadoDecorado){
        super(estadoDecorado);
    }

    @Override
    public boolean bocaArriba(){
        return estado.bocaArriba();

    }

    @Override
    public boolean bocaAbajo(){
        setPosicionAtaque(estado);
        return estado.bocaAbajo();

    }

    private void setPosicionAtaque(Estado estadoDecorado){
        System.out.println("Carta Monstruo En Posicion De Ataque");

    }

}
