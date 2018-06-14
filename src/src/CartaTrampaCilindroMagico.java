package src;

public class CartaTrampaCilindroMagico extends CartaTrampa {

    public CartaTrampaCilindroMagico(String nombreDeCarta) {
        super(nombreDeCarta);
    }

    @Override
    public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta) {
        lado.jugarCartaTrampa(this);
    }

    public void activarEfecto(Jugador jugador) {};

    public void activarTrampa(Jugador jugador, CartaMonstruo carta) {
        jugador.recibeDanio(carta.getAtaque());
    }
}
