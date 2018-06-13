package src;

public class CartaTrampa extends CartaDeUtilidad{

    private String nombre;
    private Estado estado;
    private Efecto efecto;
    private Lado lado;

    public CartaTrampa(String nombreDeCarta, Efecto efectoDeCarta){
    	this.nombre = nombreDeCarta;
    	this.estado = new SinEstado();
    	this.efecto = efectoDeCarta;
        
    }
    
    public void activarEfecto(){
    	//Aplica un efecto sobre el campo
    	this.efecto.activarEfecto(this.lado);
    }




}
