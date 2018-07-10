package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaDeUtilidad;
import modelo.Jugador;

public class BotonCartaDeUtilidad extends Button {
    private  Jugador jugador;
    private  CartaDeUtilidad carta;
    private  Datos dato;

    public BotonCartaDeUtilidad(Jugador jugadorActual, CartaDeUtilidad utilidad, Datos datos) {
        jugador = jugadorActual;
        carta = utilidad;
        dato = datos;
        ImageView imageView = new ImageView(carta.getImagen());
        imageView.setFitWidth(50);
        imageView.setFitHeight(100);
        this.setGraphic(imageView);


        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dato.mostrarDatosDeCarta(carta);
            }
        });
    }

}
