package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Jugador;

public class BotonjugarCartaMonstruo extends Button {


    private Jugador jugador;
    private ManoDeJugador manoDeJugador;
    private Carta carta;
    private Tablero tablero;

    public BotonjugarCartaMonstruo(Tablero tablero, ManoDeJugador manoDeJugador, Jugador jugador, Carta carta) {
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;
        this.manoDeJugador = manoDeJugador;


        this.setText("Jugar Carta Monstruo");
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (carta instanceof CartaMonstruo){
                    jugador.jugarCartaMonstruoEnLado((CartaMonstruo)carta);
                    colocarEnEstado();
                    colocarEnPosicion();
                }
                else {
                    //Alert alert = new Alert();  alerta de error
                }
                tablero.actualizarTablero();
                manoDeJugador.actualizarMano();//puede que rompa
            }

        });

    }

    private void colocarEnPosicion() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(200,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new TextField("Indique la accion que desea Realizar Con esta Carta"),1,1);
        gridPane.add(posicionDeAtaque(),1,2);
        gridPane.add(posicionDeDefensa(),2,2);
        Scene scene = new Scene(gridPane,200,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.show();
    }

    private Button posicionDeDefensa() {
        Button posicionDeDefensa = new Button("Posicion De Defensa");
        posicionDeDefensa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionDefensa((CartaMonstruo) carta);
            }
        });
        return posicionDeDefensa;
    }

    private Button posicionDeAtaque() {
        Button posicionDeAtaque = new Button("Posicion De Ataque");
        posicionDeAtaque.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionAtaque((CartaMonstruo) carta);
            }
        });
        return posicionDeAtaque;
    }

    private void colocarEnEstado() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(100,30 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new TextField("Indique la accion que desea Realizar Con esta Carta"),1,1);
        gridPane.add(bocaAbajo(),1,2);
        gridPane.add(bocaArriba(),2,2);
        Scene scene = new Scene(gridPane,100,30);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.show();

    }

    private Button bocaArriba() {
        Button bocaArriba = new Button("Estado Boca Abajo");
        bocaArriba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionAtaque((CartaMonstruo) carta);
            }
        });
        return bocaArriba;
    }

    private Button bocaAbajo() {
        Button bocaAbajo = new Button("Estado Boca Arriba");
        bocaAbajo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionAtaque((CartaMonstruo) carta);
            }
        });
        return bocaAbajo;

    }
}
