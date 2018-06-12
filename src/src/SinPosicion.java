package src;

public class SinPosicion extends DecoradorDeEstado {

    public SinPosicion(Estado estadoDecorado){
        super(estadoDecorado);
    }

    @Override
    public boolean bocaArriba(){
        return estado.bocaArriba();

    }

    @Override
    public boolean bocaAbajo(){
        return estado.bocaAbajo();

    }
}
