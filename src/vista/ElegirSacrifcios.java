package vista;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.CartaMonstruo;
import modelo.Jugador;




    public class ElegirSacrifcios
    {
        private ArrayList<CartaMonstruo> cartas;
        private ArrayList<CartaMonstruo> seleccionadas = new ArrayList();

        public ElegirSacrifcios(int i, Tablero tablero, CartaMonstruo carta, Jugador jugador)
        {
            cartas = ((ArrayList)jugador.getCartasMonstruos());
            for (int j = 0; j <= i; j++) {
                seleccionadas.clear();
                Stage nuevoStage = new Stage();
                GridPane gridPane = new GridPane();
                gridPane.setMinSize(1000.0D, 100.0D);
                gridPane.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
                gridPane.setVgap(5.0D);
                gridPane.setHgap(5.0D);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.add(new Text("Indique la posicion del monstruo que quiere sacrificar"), 1, 1);
                gridPane.add(posicionUno(nuevoStage), 1, 2);
                gridPane.add(posicionDos(nuevoStage), 2, 2);
                gridPane.add(posicionTres(nuevoStage), 3, 2);
                gridPane.add(posicionCuatro(nuevoStage), 4, 2);
                gridPane.add(posicionCinco(nuevoStage), 5, 2);
                gridPane.add(cancelar(nuevoStage),6,2);
                Scene scene = new Scene(gridPane, 200.0D, 200.0D);
                nuevoStage.setScene(scene);
                nuevoStage.showAndWait();
            }
            switch (i) {
                case 3:  jugador.jugarCartaEnLadoConTresSacrificio(carta, (CartaMonstruo)seleccionadas.get(0), (CartaMonstruo)seleccionadas.get(1), (CartaMonstruo)seleccionadas.get(2));
                    break;
                case 2:  jugador.jugarCartaEnLadoConDosSacrificio(carta, (CartaMonstruo)seleccionadas.get(0), (CartaMonstruo)seleccionadas.get(1));
                    break;
                case 1:  jugador.jugarCartaEnLadoConUnSacrificio(carta, (CartaMonstruo)seleccionadas.get(0));
                    break;
            }

            new colocarEnEstado(jugador, carta);
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
                    seleccionarCarta(2);
                    nuevoStage.close();
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
                    seleccionarCarta(1);
                    nuevoStage.close();
                }
            });
            return boton;
        }

        private void seleccionarCarta(int i) {
            seleccionadas.add((CartaMonstruo)cartas.get(i - 1));
        }
    }
