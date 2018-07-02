package modelo;


import java.util.List;

public class CartaMonstruo implements Carta {

    private String nombre;
    private int defensa;
    private int ataque;
    private EstadoDeCarta estado;
    private PosicionDeCarta posicion;
    private boolean muerto;
    private int estrellas;


    public CartaMonstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo, int estrellasDelMonstruo){
        //estrellas = numeroDeEstrellas;
        this.nombre = nombreDelMonstruo;
        this.defensa = defensaDelMonstruo;
        this.ataque = ataqueDelMonstruo;
        this.estrellas = estrellasDelMonstruo;
        estado = new SinEstado();
        posicion = new SinPosicion();
        muerto = false;

    }


    public String getNombre(){
        return nombre;

    }


    public void aplicarBuff(int nuevaDefensa, int nuevoAtaque){ //para buff y debuffs
        this.defensa += nuevaDefensa;
        this.ataque += nuevoAtaque;

    }

    public int atacarAMonstruo(CartaMonstruo cartaMonstruo) throws CartaMuertaNoPuedeAtacarException {
        estado = new EstadoBocaArriba();
        posicion = new PosicionAtaque();
        if (cartaMonstruo.estadoMuerto())
            throw new CartaMuertaNoPuedeAtacarException();
        return cartaMonstruo.recibeAtaque(this.ataque,this);
    }

    private int recibeAtaque(int unAtaque, CartaMonstruo carta){
        estado = new EstadoBocaArriba();
        activarEfectoAlRecibirAtaque(carta);
        int resultado = posicion.recibirAtaque(ataque, defensa, unAtaque, this, carta);
        return resultado;

    }

    public void activarEfectoAlRecibirAtaque(CartaMonstruo carta) {
    }


    @Override
    public void colocarEn(EstadoDeCarta unEstado){
        estado = unEstado;

    }

    public void atacarA(Jugador jugador) {
        estado = new EstadoBocaArriba();
        posicion = new PosicionAtaque();
        jugador.recibeDanio(this.ataque);

    }

    public void enPosicion(PosicionDeCarta unaPosicion) {
        posicion = unaPosicion;

    }

    public  boolean esFusionDe(List<CartaMonstruo> cartas){
        return false;
    }

    public void estaMuerta() {
        muerto = true;
    }


    public boolean posicionDeDefensa() {
        return posicion.posicionDeDefensa();
    }


    public boolean estadoMuerto() {
        return muerto;
    }


    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion) {
	}

}
