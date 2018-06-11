package src;

public class CartaDeTrampa implements CartaDeUtilidad{

    private String nombre;
    private Efecto efecto;
    private Campo campo;

    public CartaDeTrampa(String nombreDeCarta, Efecto efectoDeCarta){
        this.nombre = nombreDeCarta;
        this.efecto = efectoDeCarta;
        
    }
    
    public void activarEfecto(){
    	//Aplica un efecto sobre el campo
    	this.efecto.activarEfecto(this.campo);
    }
    
    public void setCampo(Campo campo){
    	this.campo = campo;
    }

}
