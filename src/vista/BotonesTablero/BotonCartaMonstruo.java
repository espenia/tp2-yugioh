package vista.BotonesTablero;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaMonstruo;
import modelo.Cartas.MonstruoNulo;
import modelo.Jugador;
import vista.Datos;
import vista.JuegoScene;
import vista.Tablero;

public class BotonCartaMonstruo extends Button {

    private Jugador jugador;
    private CartaMonstruo carta;
    private Datos dato;

    public BotonCartaMonstruo(Jugador jugadorActual, CartaMonstruo cartaMonstruo, Datos datos, Tablero tablero, JuegoScene juegoScene) {
        jugador = jugadorActual;
        carta = cartaMonstruo;
        dato = datos;
        if (cartaMonstruo instanceof MonstruoNulo)
            setearGrafico(cartaMonstruo);
        else
            setearGrafico((CartaMonstruo)(cartaMonstruo.estadoDeCarta()));

        this.setOnAction(new BotonCartaEnTableroHandler(this.jugador, this.carta,tablero,dato,juegoScene));




    }

    private void setearGrafico(CartaMonstruo cartaMonstruo) {
        ImageView imageView = new ImageView(cartaMonstruo.getImagen());
        if (carta.posicionDeDefensa()){
            imageView.setRotate(90);
            imageView.setFitWidth(150);
            imageView.setFitHeight(100);
        }
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);
    }
}
