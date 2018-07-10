package modelo;

public abstract class CartaDeUtilidad implements Carta {

    private String nombre;
    private EstadoDeCarta estado;

    public CartaDeUtilidad(String nombreDeCarta) {
    	this.nombre = nombreDeCarta;
    }
    
    public abstract void activarTrampa(Lado lado, Lado ladoEnemigo);

    @Override
    public String getNombre(){
       return nombre;
    }

    public void colocarEn(EstadoDeCarta unEstado){
        estado = unEstado;
    }


	public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
	}

    public Carta estadoDeCarta(){
       return estado.estadoDeCarta(this);
    }
}
