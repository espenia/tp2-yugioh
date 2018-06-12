package src;

public abstract class DecoradorDeEstado implements Estado {

    protected Estado estado;

    public DecoradorDeEstado(Estado estadoDecorado){
        estado = estadoDecorado;

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
