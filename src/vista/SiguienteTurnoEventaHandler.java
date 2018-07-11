package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.Juego;

public class SiguienteTurnoEventaHandler implements EventHandler<ActionEvent> {

    private  JuegoScene juegoScene;
    private Juego juego;

    public SiguienteTurnoEventaHandler(Juego juego,JuegoScene juegoScene){
        this.juego = juego;
        this.juegoScene = juegoScene;
    }

    @Override
    public void handle(ActionEvent event) {
        juego.siguienteTurno();
        juegoScene.configurarPanel();

    }
}
