package modelo;


import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.Exceptions.CartaMuertaNoPuedeAtacarException;
import modelo.Exceptions.MonstruoNoPuedeAtacarDosVecesEnUnTurnoException;

import java.util.List;

public class CartaMonstruo implements Carta {

    private String nombre;
    private int defensa;
    private int ataque;
    private EstadoDeCarta estado;
    private PosicionDeCarta posicion;
    private VidaDeCarta vidaDeCarta;
    private boolean yaAtacoEsteTurno;


    public CartaMonstruo(String nombreDelMonstruo,int defensaDelMonstruo, int ataqueDelMonstruo, int estrellasDelMonstruo){
        this.nombre = nombreDelMonstruo;
        this.defensa = defensaDelMonstruo;
        this.ataque = ataqueDelMonstruo;
        yaAtacoEsteTurno = false;
        estado = new SinEstado();
        posicion = new SinPosicion();
        vidaDeCarta = new Vivo();
    }




    public void aplicarBuff(int nuevaDefensa, int nuevoAtaque){
        this.defensa += nuevaDefensa;
        this.ataque += nuevoAtaque;

    }

    public int atacarAMonstruo(CartaMonstruo cartaMonstruo) throws CartaMuertaNoPuedeAtacarException, MonstruoNoPuedeAtacarDosVecesEnUnTurnoException {
        estado = new EstadoBocaArriba();
        posicion = new PosicionAtaque();
        if (yaAtacoEsteTurno)
            throw new MonstruoNoPuedeAtacarDosVecesEnUnTurnoException();
        yaAtacoEsteTurno = true;
        vidaDeCarta.atacar();
        return cartaMonstruo.recibeAtaque(this.ataque,this);
    }

    private int recibeAtaque(int unAtaque, CartaMonstruo carta){
        vidaDeCarta.atacar();
        estado = new EstadoBocaArriba();
        activarEfectoAlRecibirAtaque(carta);
        int resultado = posicion.recibirAtaque(ataque, defensa, unAtaque, this, carta);
        return resultado;

    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado){
        estado = unEstado;

    }

    public void atacarA(Jugador jugador) throws MonstruoNoPuedeAtacarDosVecesEnUnTurnoException{
        if (yaAtacoEsteTurno)
            throw new MonstruoNoPuedeAtacarDosVecesEnUnTurnoException();
        yaAtacoEsteTurno = true;
        estado = new EstadoBocaArriba();
        posicion = new PosicionAtaque();
        jugador.recibeDanio(this.ataque);

    }

    public void refrescarAtaque() {
        yaAtacoEsteTurno = false;

    }

    public void enPosicion(PosicionDeCarta unaPosicion) {
        posicion = unaPosicion;

    }

    public void estaMuerta() {
        vidaDeCarta = new Muerto();

    }



    public boolean posicionDeDefensa() {
        return posicion.posicionDeDefensa();
    }


    public boolean estadoMuerto() {
        return vidaDeCarta.estaMuerta();
    }


    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    @Override
    public String getNombre(){
        return nombre;

    }

    @Override
    public Image getImagen() {
        return null;
    }

    @Override
    public Text getDatos() {
        return null;
    }


    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
	}

    public void activarEfectoAlRecibirAtaque(CartaMonstruo carta) {
    }


    public  boolean esFusionDe(List<CartaMonstruo> cartas){
        return false;
    }


    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {

    }

    public Carta estadoDeCarta() {
        return estado.estadoDeCarta(this);
    }
}
