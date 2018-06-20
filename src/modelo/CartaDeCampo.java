package modelo;

public abstract class CartaDeCampo implements Carta{

    private String nombre;

    public CartaDeCampo(String nombreDeCarta){
        this.nombre = nombreDeCarta;
        
    }

    public String getNombre(){
        return nombre;

    }

    @Override
    public void activarEfecto(Lado miLado,Lado ladoEnemigo){


    }

    public abstract void aplicarBuff(CartaMonstruo carta,Lado unLado);

    public abstract void asignarLado(Lado unLado);

}

