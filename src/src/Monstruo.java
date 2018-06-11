package src;

public class Monstruo implements Carta{ //hasta ahora no utiliza nada de la interfaz carta

    private String nombre;
    private int defensa;
    private int ataque;


    public Monstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo ){
        nombre = nombreDelMonstruo;
        defensa = defensaDelMonstruo;
        ataque = ataqueDelMonstruo;

    }

    public void actualizarDatos(int nuevaDefensa, int nuevoAtaque){ //para buff y debuffs
        defensa = nuevaDefensa;
        ataque = nuevoAtaque;
    }

    public int compararAtaqueDeMonstruo(Monstruo monstruo){
        return monstruo.compararAtaque(ataque);
    }

    private int compararAtaque(int unAtaque){
        return unAtaque - ataque;
    }

    public int compararDefensaDeMonstruo(Monstruo monstruo){
        return monstruo.compararDefensaConAtaque(ataque);
    }
    private int compararDefensaConAtaque(int unAtaque){
        return unAtaque - defensa;
    }
}
