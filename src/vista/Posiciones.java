package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.CartaMonstruo;

import java.util.ArrayList;
import java.util.List;

public class Posiciones extends ArrayList<CartaMonstruo> {

    private ArrayList cartas;

    public Posiciones(List<CartaMonstruo> cartasMonstruos, String texto) {
        cartas = (ArrayList) cartasMonstruos;
        Stage nuevoStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000, 100);
        //gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text(texto), 1, 1);
        gridPane.add(posicionUno(nuevoStage), 1, 2);
        gridPane.add(posicionDos(nuevoStage), 2, 2);
        gridPane.add(posicionTres(nuevoStage), 3, 2);
        gridPane.add(posicionCuatro(nuevoStage), 4, 2);
        gridPane.add(posicionCinco(nuevoStage), 5, 2);
        gridPane.add(cancelar(nuevoStage),6,2);
        Scene scene = new Scene(gridPane, 1000, 100);
        nuevoStage.setScene(scene);
        nuevoStage.showAndWait();
    }

    private Button cancelar(Stage nuevoStage) {
        Button button = new Button("Cancelar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoStage.close();
            }
        });
        return button;
    }


    private Button posicionCinco(Stage nuevoStage)
    {
        Button boton = new Button("Posicion Cinco ( 5 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seleccionarCarta(5);
                nuevoStage.close();
            }
        });

        return boton;
    }

    private Button posicionCuatro(Stage nuevoStage)
    {
        Button boton = new Button("Posicion Cuatro ( 4 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seleccionarCarta(4);
                nuevoStage.close();
            }
        });

        return boton;
    }

    private Button posicionTres(Stage nuevoStage) {
        Button boton = new Button("Posicion Tres ( 3 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seleccionarCarta(3);
                nuevoStage.close();
            }
        });
        return boton;
    }

    private Button posicionDos(Stage nuevoStage) {
        Button boton = new Button("Posicion Dos ( 2 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoStage.close();
                seleccionarCarta(2);
            }
        });
        return boton;
    }

    private Button posicionUno(Stage nuevoStage)
    {
        Button boton = new Button("Posicion Uno ( 1 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoStage.close();
                seleccionarCarta(1);
            }
        });
        return boton;
    }

    private void seleccionarCarta(int i) {
        this.add((CartaMonstruo)cartas.get(i - 1));
    }

}
