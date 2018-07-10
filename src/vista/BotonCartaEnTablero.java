package vista;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Carta;
import modelo.Jugador;

public class BotonCartaEnTablero extends Button{
	
	public BotonCartaEnTablero(ImageView imagen, Jugador jugador, Carta carta, Tablero tablero) {
		BotonCartaEnTableroHandler handler = new BotonCartaEnTableroHandler(jugador, carta, tablero);
        this.setOnAction(handler);
        this.setGraphic(imagen);
	}

}
