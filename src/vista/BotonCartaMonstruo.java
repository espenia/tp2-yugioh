package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Cartas.MonstruoNulo;
import modelo.Jugador;

public class BotonCartaMonstruo extends Button {

    private Jugador jugador;
    private CartaMonstruo carta;
    private Datos dato;

    public BotonCartaMonstruo(Jugador jugadorActual, CartaMonstruo cartaMonstruo, Datos datos) {
        jugador = jugadorActual;
        carta = cartaMonstruo;
        dato = datos;
        if (cartaMonstruo instanceof MonstruoNulo)
            setearGrafico(cartaMonstruo);
        else
            setearGrafico((CartaMonstruo)(cartaMonstruo.estadoDeCarta()));//rompe

        this.setOnAction(new BotonCartaEnTableroHandler(this.jugador, this.carta));




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
