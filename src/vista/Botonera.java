package vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import modelo.Juego;


public class Botonera extends GridPane {

    private Button siguienteTurno;
    private Button siguienteFase;
    private Juego juego;

    public Botonera(Juego juego){//manejo de fases
        this.juego = juego;

        this.setMinSize(600,20 );

        this.setPadding(new Insets(10, 10, 10, 10));

        siguienteFase = new Button("Siguiente Fase");
        SiguienteFaseEventaHandler siguienteFaseEventaHandler = new SiguienteFaseEventaHandler(this.juego);
        siguienteFase.setOnAction(siguienteFaseEventaHandler);
        siguienteTurno = new Button("Siguiente Turno");
        SiguienteTurnoEventaHandler siguienteTurnoEventaHandler = new SiguienteTurnoEventaHandler(this.juego);
        siguienteTurno.setOnAction(siguienteTurnoEventaHandler);

        this.add(siguienteFase,1,5);
        this.add(siguienteTurno,1,6);

    }
}
