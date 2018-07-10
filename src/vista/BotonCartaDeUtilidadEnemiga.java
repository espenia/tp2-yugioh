package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaDeUtilidad;
import modelo.Cartas.MonstruoNulo;
import modelo.Cartas.UtilidadNula;
import modelo.Jugador;

public class BotonCartaDeUtilidadEnemiga extends Button {
    private Jugador jugador;
    private CartaDeUtilidad carta;
    private Datos dato;

    public BotonCartaDeUtilidadEnemiga(Jugador enemigoActual, CartaDeUtilidad utilidad, Datos datos) {
        jugador = enemigoActual;
        carta = utilidad;
        dato = datos;
        ImageView imageView = new ImageView(carta.getImagen());
        imageView.setFitWidth(50);
        imageView.setFitHeight(100);
        this.setGraphic(imageView);

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (carta instanceof UtilidadNula)
                    dato.mostrarDatosDeCarta(carta);
                else {
                    dato.mostrarDatosDeCarta(carta.estadoDeCarta());
                }
            }
        });
    }
}
