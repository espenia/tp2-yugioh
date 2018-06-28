package modelo;

import java.util.List;

public abstract class CartaDeCampo implements Carta{

    private Lado lado;
    private Lado ladoEnemigo; 
    private boolean aux = false;
    private String nombre;

    public CartaDeCampo(String nombreDeCarta){
        this.nombre = nombreDeCarta;
        
    }
    @Override
    public String getNombre(){
        return nombre;

    }


    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion) {


    }

    public void asignarLado(Lado unLado){
        if(aux == false) {
            lado = unLado;
            aux = true;
        }
        else ladoEnemigo = unLado;
    }

    public void aplicarBuff(CartaMonstruo carta,Lado unLado) {
        if(lado == unLado)
            aplicarBuffPrincipal(carta);
        else aplicarBuffDelLadoEnemigo(carta);

    }

    public abstract void aplicarBuffPrincipal(CartaMonstruo carta);

    public abstract void aplicarBuffDelLadoEnemigo(CartaMonstruo carta);


}
