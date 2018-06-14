package src;

public class CartaMonstruo implements Carta{ //hasta ahora no utiliza nada de la interfaz carta

    private String nombre;
    private int defensa;
    private int ataque;
    private Estado estado;
    //private Efecto efecto;

    //public Monstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo, Efecto efecto){
    public CartaMonstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo ){
        this.nombre = nombreDelMonstruo;
        this.defensa = defensaDelMonstruo;
        this.ataque = ataqueDelMonstruo;
        estado = new SinPosicion(new SinEstado());
        //this.efecto = efecto;
        //efecto.setEfecto(this);

    }

    public String getNombre(){
        return nombre;
    }

    public void actualizarDatos(int nuevaDefensa, int nuevoAtaque){ //para buff y debuffs
        this.defensa = nuevaDefensa;
        this.ataque = nuevoAtaque;
    }

    public int compararAtaqueDeMonstruo(CartaMonstruo cartaMonstruo){
        return cartaMonstruo.compararAtaque(this.ataque);
    }

    private int compararAtaque(int unAtaque){
        return unAtaque - this.ataque;
    }

    public int compararDefensaDeMonstruo(CartaMonstruo cartaMonstruo){
        return cartaMonstruo.compararDefensaConAtaque(this.ataque);
    }
    private int compararDefensaConAtaque(int unAtaque){
        return unAtaque - this.defensa;
    }

    public void colocarEn(DecoradorDeEstado unEstado){
        estado = unEstado;

    }

    public boolean verificarSiEstaBocaArriba(){
        return estado.bocaArriba();
    }

    public boolean verificarSiEstaBocaAbajo(){
        return estado.bocaAbajo();
    }

    public void atacarA(Jugador jugador) {
        jugador.recibeDanio(this.ataque);
    }

}
