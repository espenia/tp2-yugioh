package modelo;

public interface PosicionDeCarta {

    int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante, CartaMonstruo cartaDefendiente, CartaMonstruo cartaAtacante);

    boolean posicionDeDefensa();
}
