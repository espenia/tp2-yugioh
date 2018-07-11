package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;

import java.util.List;

public class CartaBocaAbajoDeUtilidad extends CartaDeUtilidad {

    public CartaBocaAbajoDeUtilidad() {
        super("nulo");
    }

    @Override
    public void activarTrampa(Lado lado, Lado ladoEnemigo) {

    }

    @Override
    public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo miCarta) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {

    }

    @Override
    public Image getImagen() { return new Image(getClass().getResourceAsStream("facedown.jpg"));
        //return new Image("file:src/vista/");
    }

    @Override
    public Text getDatos() {
        return new Text("Carta Boca Abajo");
    }
}
