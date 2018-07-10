package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Juego;

public class SiguienteFaseEventaHandler  implements EventHandler<ActionEvent>{

    private Juego juego;
	private JuegoScene juegoScene;

    public SiguienteFaseEventaHandler(Juego juego, JuegoScene juegoScene){
        this.juego = juego;
        this.juegoScene = juegoScene;
    }


    @Override
    public void handle(ActionEvent event) {
    	this.juego.siguienteFase();
    	this.juegoScene.cambiarFase();
    }
}
