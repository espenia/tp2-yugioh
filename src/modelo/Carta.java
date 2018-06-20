package modelo;

public interface Carta {


    void colocarEn(EstadoDeCarta unEstado);
    void activarEfecto(Lado lado,Lado ladoEnemigo);
    String getNombre();
}
