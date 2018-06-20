package modelo;

public abstract class CartaDeCampo implements Carta{

    private Lado lado;
    private Lado ladoEnemigo;
    private int aux = 1;
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
    public void activarEfecto(Lado lado, Lado ladoEnemigo) {


    }

    public void asignarLado(Lado unLado){
        if(aux == 1) {
            lado = unLado;
            aux+=1;
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
