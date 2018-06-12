package src;

public class BocaAbajo implements Estado{

    @Override
    public boolean bocaArriba(){
        return false;

    }

    @Override
    public boolean bocaAbajo(){
        return true;

    }
}
