package modelo;

public interface Carta {


    void colocarEn(EstadoDeCarta unEstado);
    void activarEfecto();
    String getNombre();
    //public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta);
}
