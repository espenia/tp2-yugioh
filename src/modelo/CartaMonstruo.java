package modelo;


public class CartaMonstruo implements Carta { //hasta ahora no utiliza nada de la interfaz carta

    private String nombre;
    private int defensa;
    private int ataque;
    private EstadoDeCarta estado;
    private PosicionDeCarta posicion;
    private int estrellas;
    //private Efecto efecto;

    //public Monstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo, Efecto efecto){
    public CartaMonstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo, int estrellasDelMonstruo){
        //estrellas = numeroDeEstrellas;
        this.nombre = nombreDelMonstruo;
        this.defensa = defensaDelMonstruo;
        this.ataque = ataqueDelMonstruo;
        this.estrellas = estrellasDelMonstruo;
        estado = new SinEstado();
        posicion = new SinPosicion();

        //this.efecto = efecto;
        //efecto.setEfecto(this);

    }


    public String getNombre(){
        return nombre;

    }

    public int getAtaque() {
        return ataque;

    }

    public int getDefensa(){
        return defensa;
    }

    public void aplicarBuff(int nuevaDefensa, int nuevoAtaque){ //para buff y debuffs
        this.defensa += nuevaDefensa;
        this.ataque += nuevoAtaque;
    }

    public int compararAtaqueDeMonstruo(CartaMonstruo cartaMonstruo){
        estado = new EstadoBocaArriba();
        posicion = new PosicionAtaque();
        return cartaMonstruo.compararAtaque(this.ataque);
    }

    private int compararAtaque(int unAtaque){
        estado = new EstadoBocaArriba();
        return posicion.recibirAtaque(ataque, defensa, unAtaque);

    }


    @Override
    public void colocarEn(EstadoDeCarta unEstado){
        estado = unEstado;

    }

    @Override
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {

    }

    public void atacarA(Jugador jugador) {
        estado = new EstadoBocaArriba();
        posicion = new PosicionAtaque();
        jugador.recibeDanio(this.ataque);

    }

    public void enPosicion(PosicionDeCarta unaPosicion) {
        posicion = unaPosicion;

    }


    public boolean posicionDeDefensa(){
        return posicion.estaDefendiendo();


    }

    /*
	@Override
	public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta) {
		lado.jugarCartaMonstruo(this, posicionDeLaCarta, modoDeLaCarta);
	}*/
}
