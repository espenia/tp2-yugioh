package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Jugador;

public class BotonjugarCartaMonstruo extends Button {


    private Jugador jugador;
    private ManoDeJugador manoDeJugador;
    private Carta carta;
    private Tablero tablero;

    public BotonjugarCartaMonstruo(Stage stage, Tablero tablero, ManoDeJugador manoDeJugador, Jugador jugador, Carta carta) {
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;
        this.manoDeJugador = manoDeJugador;

        this.setText("Jugar Carta Monstruo");
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws AccionInvalidaEnFaseException{
                try {
                    if (carta instanceof CartaMonstruo){
                        jugador.jugarCartaMonstruoEnLado((CartaMonstruo)carta);
                        colocarEnEstado();
                        stage.close();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Tipo De Carta Incorrecta",ButtonType.CLOSE);
                        alert.setHeight(40);
                        alert.setWidth(50);
                        alert.showAndWait();
                        if (alert.getResult()==ButtonType.CLOSE)
                            stage.close();
                    }
                }
                catch (AccionInvalidaEnFaseException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Acccion Invalida en Fase Actual",ButtonType.CLOSE);
                    alert.setHeight(40);
                    alert.setWidth(50);
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.CLOSE)
                        stage.close();
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
        gridPane.setMinSize(1000,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique la accion que desea Realizar Con esta Carta"),1,1);
        gridPane.add(posicionDeAtaque(stage),1,2);
        gridPane.add(posicionDeDefensa(stage),2,2);
        Scene scene = new Scene(gridPane,1000,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();
    }

    private Button posicionDeDefensa(Stage stage) {
        Button posicionDeDefensa = new Button("Posicion De Defensa");
        posicionDeDefensa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionDefensa((CartaMonstruo) carta);
                stage.close();
            }
        });
        return posicionDeDefensa;
    }

    private Button posicionDeAtaque(Stage stage) {
        Button posicionDeAtaque = new Button("Posicion De Ataque");
        posicionDeAtaque.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnPosicionAtaque((CartaMonstruo) carta);
                stage.close();
            }
        });
        return posicionDeAtaque;
    }

    private void colocarEnEstado() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(1000,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique la accion que desea Realizar Con esta Carta"),1,1);
        gridPane.add(bocaAbajo(stage),1,2);
        gridPane.add(bocaArriba(stage),2,2);
        Scene scene = new Scene(gridPane,1000,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();

    }

    private Button bocaArriba(Stage stage) {
        Button bocaArriba = new Button("Estado Boca Arriba");
        bocaArriba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnEstadoBocaArriba(carta);
                colocarEnPosicion();
                stage.close();
            }
        });
        return bocaArriba;
    }

    private Button bocaAbajo(Stage stage) {
        Button bocaAbajo = new Button("Estado Boca Abajo");
        bocaAbajo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnEstadoBocaAbajo(carta);
                colocarEnPosicion();
                stage.close();
            }
        });
        return bocaAbajo;

    }

    public void setearGrafico(ImageView grafico) {
        this.setGraphic(grafico);
    }
}
