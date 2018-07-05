package modelo;

import java.util.List;

public abstract class CartaDeCampo implements Carta{

    private Lado lado;
    private boolean aux = false;
    private String nombre;

    public CartaDeCampo(String nombreDeCarta){
        this.nombre = nombreDeCarta;
        
    }


    public void asignarLado(Lado unLado){
        if(aux == false) {
            lado = unLado;
            aux = true;
        }
    }

    public void aplicarBuff(CartaMonstruo carta,Lado unLado) {
        if(lado == unLado)
            aplicarBuffPrincipal(carta);
        else aplicarBuffDelLadoEnemigo(carta);

    }

    public abstract void aplicarBuffPrincipal(CartaMonstruo carta);

    public abstract void aplicarBuffDelLadoEnemigo(CartaMonstruo carta);

    public void revertirBuff(CartaMonstruo carta, Lado lado){
        if (this.lado == lado)
            revertirBuffPrincipal(carta);
        else revertirBuffDelLadoEnemigo(carta);

    }

    public abstract void revertirBuffDelLadoEnemigo(CartaMonstruo carta);

    public abstract void revertirBuffPrincipal(CartaMonstruo carta);



    @Override
    public String getNombre(){
        return nombre;

    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Fusion fusion, Jugador enemigo) {


    }



}
