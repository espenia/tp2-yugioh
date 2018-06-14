package src;

public abstract class CartaDeUtilidad implements Carta {

    private String nombre;
    private Estado estado;

    public CartaDeUtilidad(String nombreDeCarta) {
    	this.nombre = nombreDeCarta;
    }
    
    public abstract void activarEfecto(Jugador jugador);

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
