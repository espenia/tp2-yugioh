package modelo;

import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.util.List;

public interface Carta {


    void colocarEn(EstadoDeCarta unEstado);
    void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo);
    String getNombre();

    Image getImagen();
    Text getDatos();
}
