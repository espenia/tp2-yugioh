package modelo;

public class EstadoBocaAbajo implements EstadoDeCarta{


    @Override
    public boolean bocaArriba(){
        return false;

    }

    @Override
    public boolean bocaAbajo(){
        return true;

    }
}
