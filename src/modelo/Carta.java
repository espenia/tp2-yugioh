package modelo;

import java.util.List;

public interface Carta {


    void colocarEn(EstadoDeCarta unEstado);
    void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo);
    String getNombre();
}
