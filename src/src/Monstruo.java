package src;

public class Monstruo implements Carta{ //hasta ahora no utiliza nada de la interfaz carta

    private String nombre;
    private int defensa;
    private int ataque;
    //private Efecto efecto;

    //public Monstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo, Efecto efecto){
    public Monstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo ){
        this.nombre = nombreDelMonstruo;
        this.defensa = defensaDelMonstruo;
        this.ataque = ataqueDelMonstruo;
        //this.efecto = efecto;
        //efecto.setEfecto(this);

    }

    public void actualizarDatos(int nuevaDefensa, int nuevoAtaque){ //para buff y debuffs
    	this.defensa = nuevaDefensa;
    	this.ataque = nuevoAtaque;
    }

    public int compararAtaqueDeMonstruo(Monstruo monstruo){
        return monstruo.compararAtaque(this.ataque);
    }

    private int compararAtaque(int unAtaque){
        return unAtaque - this.ataque;
    }

    public int compararDefensaDeMonstruo(Monstruo monstruo){
        return monstruo.compararDefensaConAtaque(this.ataque);
    }
    private int compararDefensaConAtaque(int unAtaque){
        return unAtaque - this.defensa;
    }
}
