package src;

public abstract class CartaDeUtilidad implements Carta {


    private String nombre;
    private Estado estado;
    private Lado lado;


    public abstract void activarEfecto();


    public  void setLado(Lado unLado){
        lado = unLado;

    }

    @Override
    public String getNombre(){
       return nombre;
    }

    public void colocarEn(Estado unEstado){
        estado = unEstado;

    }

    public boolean verificarSiEstaBocaArriba(){
        return estado.bocaArriba();

    }

    public boolean verificarSiEstaBocaAbajo(){
        return estado.bocaAbajo();

    }

}
