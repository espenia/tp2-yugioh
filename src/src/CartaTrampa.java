package src;

public class CartaTrampa extends CartaDeUtilidad{

    private String nombre;
    private Efecto efecto;
    private Campo campo;

    public CartaTrampa(String nombreDeCarta, Efecto efectoDeCarta){
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

    @Override
    public String getNombre() {
        return null;
    }
}
