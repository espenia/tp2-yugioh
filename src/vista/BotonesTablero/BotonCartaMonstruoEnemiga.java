package vista.BotonesTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaMonstruo;
import modelo.Cartas.MonstruoNulo;
import modelo.Jugador;
import vista.Datos;

public class BotonCartaMonstruoEnemiga extends Button {


    private Jugador jugador;
    private CartaMonstruo carta;
    private Datos dato;

    public BotonCartaMonstruoEnemiga(Jugador enemigoActual, CartaMonstruo cartaMonstruo, Datos datos) {
        jugador = enemigoActual;
        carta = cartaMonstruo;
        dato = datos;
        if (cartaMonstruo instanceof MonstruoNulo)
            setearGrafico(cartaMonstruo);
        else
            setearGrafico((CartaMonstruo)(cartaMonstruo.estadoDeCarta()));

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (carta instanceof MonstruoNulo)
                    dato.mostrarDatosDeCarta(carta);
                else {
                    dato.mostrarDatosDeCarta(carta.estadoDeCarta());
                }
            }
        });


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
