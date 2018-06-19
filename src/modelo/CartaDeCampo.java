package modelo;

public abstract class CartaDeCampo implements Carta{

    private String nombre;

    public CartaDeCampo(String nombreDeCarta){
        this.nombre = nombreDeCarta;
        
    }

    public String getNombre(){
        return nombre;
    }

    public void activarEfecto(){

    }
}

