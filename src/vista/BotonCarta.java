package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Carta;
import modelo.Cartas.SinCartaDeCampo;
import modelo.Jugador;

public class BotonCarta extends Button {


    private final Datos dato;
    private Carta carta;
    private Jugador jugador;

    public BotonCarta(Jugador jugadorActual, Carta carta, Datos datos) {
        jugador = jugadorActual;
        this.carta = carta;
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
