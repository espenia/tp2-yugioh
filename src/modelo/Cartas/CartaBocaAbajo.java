package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;

import java.util.List;

public class CartaBocaAbajo extends CartaMonstruo {
    public CartaBocaAbajo() {
        super("nulo", 0, 0, 1);
    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {

    }

    @Override
    public String getNombre() {
        return "Oculta";
    }

    @Override
    public Image getImagen() {
        return new Image("file:src/vista/facedown.jpg");
    }

    @Override
    public Text getDatos() {
        return new Text("Carta Boca Abajo");
    }
}
