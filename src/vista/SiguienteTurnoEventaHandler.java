package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.Juego;

public class SiguienteTurnoEventaHandler implements EventHandler<ActionEvent> {

    private Juego juego;

    public SiguienteTurnoEventaHandler(Juego juego,BorderPane pane){
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
