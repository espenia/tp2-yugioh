package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Juego;

public class SiguienteTurnoEventaHandler implements EventHandler<ActionEvent> {

    private Juego juego;

    public SiguienteTurnoEventaHandler(Juego juego){
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
