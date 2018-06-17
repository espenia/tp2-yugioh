package modelo;

public interface PosicionDeCarta {

    int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataque);
    boolean estaDefendiendo();
    boolean estaAtacando();

}
