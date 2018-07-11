package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.CartaDeUtilidad;
import modelo.Cartas.UtilidadNula;
import modelo.Jugador;

public class BotonCartaDeUtilidad extends Button {
    private  Jugador jugador;
    private  CartaDeUtilidad carta;
    private  Datos dato;

    public BotonCartaDeUtilidad(Jugador jugadorActual, CartaDeUtilidad utilidad, Datos datos, Tablero tablero, JuegoScene juegoScene) {
        jugador = jugadorActual;
        carta = utilidad;
        dato = datos;
        if (utilidad instanceof UtilidadNula)
            setearGrafico(utilidad);
        else
            setearGrafico((CartaDeUtilidad) (utilidad.estadoDeCarta()));

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dato.mostrarDatosDeCarta(carta);
                activarEfecto();
                juegoScene.configurarPanel();
            }
        });




    }

    private void activarEfecto() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique la accion donde que quiere Realizar"),1,1);
        gridPane.add(botonActivarEfecto(stage, jugador, carta),1,2);
        gridPane.add(cancelar(stage),2,2);
        Scene scene = new Scene(gridPane,300,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();

    }

    private Button cancelar(Stage stage) {
        Button boton = new Button("Cancelar");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
        return boton;
    }

    private Button botonActivarEfecto(Stage stage, Jugador jugador, CartaDeUtilidad carta) {
        Button boton = new Button("Activar Efecto");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador.colocarEnEstadoBocaArriba(carta);
                stage.close();
            }
        });
        return boton;
    }

    private void setearGrafico(CartaDeUtilidad utilidad) {
        ImageView imageView = new ImageView(utilidad.getImagen());
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);
    }
}
