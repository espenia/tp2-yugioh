package src;

public class PosicionDefensa extends DecoradorDeEstado {

    public PosicionDefensa(Estado estadoDecorado){
        super(estadoDecorado);

    }

    @Override
    public boolean bocaArriba(){
        return estado.bocaArriba();

    }

    @Override
    public boolean bocaAbajo(){
        setPosicionDefensa(estado);
        return estado.bocaAbajo();

    }


    private void setPosicionDefensa(Estado estadoDecorado){
        System.out.println("Carta Monstruo En Posicion De Defensa");

    }

}
