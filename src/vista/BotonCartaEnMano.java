package vista;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Carta;
import modelo.Jugador;

public class BotonCartaEnMano extends Button{

    public BotonCartaEnMano(ImageView imagen, Jugador jugador, Carta carta,Datos datos){

        BotonCartaEnManoHandler handler = new BotonCartaEnManoHandler(jugador,carta,datos);
        this.setOnAction(handler);
        this.setGraphic(imagen);

    }
}
