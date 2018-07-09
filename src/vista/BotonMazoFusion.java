package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.Jugador;

import java.util.Map;

public class BotonMazoFusion extends Button {

    private  Datos dato;
    private  Jugador jugador;
    private  Map mazoDeFusion;

    public BotonMazoFusion(Jugador jugadorActual, Map mazoDeFusion, Datos datos) {
        jugador = jugadorActual;
        this.mazoDeFusion = mazoDeFusion;
        dato = datos;

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //dato.mostrarDatosDeCarta();
            }
        });


    }
}
