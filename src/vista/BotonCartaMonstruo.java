package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
        ImageView imageView = new ImageView(carta.getImagen());
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dato.mostrarDatosDeCarta(carta);
            }
        });




    }
}
