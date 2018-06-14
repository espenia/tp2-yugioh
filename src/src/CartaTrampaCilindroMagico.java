package src;

public class CartaTrampaCilindroMagico extends CartaTrampa {

    public CartaTrampaCilindroMagico(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta) {
        // TODO Auto-generated method stub

    }

    public void activarEfecto(Jugador jugador) {};

    public void activarTrampa(Jugador jugador, CartaMonstruo carta) {
        jugador.aplicarDanioDirecto(carta.getAtaque());
    }
}
