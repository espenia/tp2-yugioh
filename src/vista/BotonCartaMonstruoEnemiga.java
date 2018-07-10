package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaMonstruo;
import modelo.Cartas.MonstruoNulo;
import modelo.Jugador;

public class BotonCartaMonstruoEnemiga extends Button {


    private Jugador jugador;
    private CartaMonstruo carta;
    private Datos dato;

    public BotonCartaMonstruoEnemiga(Jugador enemigoActual, CartaMonstruo cartaMonstruo, Datos datos) {
        jugador = enemigoActual;
        carta = cartaMonstruo;
        dato = datos;
        ImageView imageView = new ImageView(carta.getImagen());
        imageView.setFitWidth(50);
        imageView.setFitHeight(100);
        this.setGraphic(imageView);

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
}
