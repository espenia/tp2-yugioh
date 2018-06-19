package modelo;

public abstract class CartaDeUtilidad implements Carta {

    private String nombre;
    private EstadoDeCarta estado;

    public CartaDeUtilidad(String nombreDeCarta) {
    	this.nombre = nombreDeCarta;
    }
    
    //public abstract void activarEfecto(Jugador jugador);
    public abstract void activarTrampa(Jugador jugador, CartaMonstruo carta);

    @Override
    public String getNombre(){
       return nombre;
    }

    public void colocarEn(EstadoDeCarta unEstado){
        estado = unEstado;
    }

    public boolean verificarSiEstaBocaArriba(){
        return estado.bocaArriba();
    }

    public boolean verificarSiEstaBocaAbajo(){
        return estado.bocaAbajo();
    }

}
