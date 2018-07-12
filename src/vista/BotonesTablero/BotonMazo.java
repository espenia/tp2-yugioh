package vista.BotonesTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Jugador;
import modelo.Mazo;
import modelo.MazoEstandar;
import vista.Datos;

public class BotonMazo extends Button {


    private final Jugador jugador;
    private final Mazo carta;
    private final Datos dato;

    public BotonMazo(Jugador jugadorActual, Mazo cartas, Datos datos) {
        jugador = jugadorActual;
        carta = cartas;
        dato = datos;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);        

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rendirse();
            }
        });


    }

    private void rendirse() {
        //hacer un boton que te vuelva  a la pantalla principal (ventana con un boton)
    }
}
