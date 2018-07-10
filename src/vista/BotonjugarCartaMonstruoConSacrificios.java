package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.Jugador;

public class BotonjugarCartaMonstruoConSacrificios extends Button {


    private  Tablero tablero;
    private  Jugador jugador;
    private CartaMonstruo carta;

    public BotonjugarCartaMonstruoConSacrificios(Stage stage, Tablero tablero, ManoDeJugador manoDeJugador, Jugador jugador, Carta carta) {
        this.setText("Jugar Monstruo Con Sacrificios");
        this.tablero = tablero;
        this.jugador = jugador;
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws AccionInvalidaEnFaseException {
                try {
                    if (carta instanceof CartaMonstruo){
                        definirCarta(carta);
                        cantidadDeSacrificios();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Tipo De Carta Incorrecta", ButtonType.CLOSE);
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
                manoDeJugador.actualizarMano();
            }

        });

    }

    private void cantidadDeSacrificios() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        //gridPane.setId("pantalla-principal");
        gridPane.setMinSize(1000,100 );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Text("Indique la Cantidad De sacrificios que quiere Realizar"),1,1);
        gridPane.add(unSacrificio(stage),1,2);
        gridPane.add(dosSacrificio(stage),2,2);
        gridPane.add(tresSacrificios(stage),3,2);
        Scene scene = new Scene(gridPane,1000,100);
        stage.setTitle("Accion");
        stage.setScene(scene);
        stage.showAndWait();

    }

    private void definirCarta(Carta carta) {
        this.carta = (CartaMonstruo) carta;
    }



    private Button unSacrificio(Stage nuevoStage)
    {
        Button boton = new Button("un Sacrificio ( 1 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                verificarCantidadDeSacrificios(1,nuevoStage);
                new ElegirSacrifcios(1,tablero,carta,jugador);
                nuevoStage.close();
            }
        });

        return boton;
    }


    private Button dosSacrificio(Stage nuevoStage)
    {
        Button boton = new Button("dos Sacrificios ( 2 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                verificarCantidadDeSacrificios(2,nuevoStage);
                new ElegirSacrifcios(2,tablero,carta,jugador);
                nuevoStage.close();
            }
        });

        return boton;
    }

    private Button tresSacrificios(Stage nuevoStage) {
        Button boton = new Button("tres Sacrificios ( 3 )");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                verificarCantidadDeSacrificios(3,nuevoStage);
                new ElegirSacrifcios(3,tablero,carta,jugador);
                nuevoStage.close();
            }
        });
        return boton;
    }

    private void verificarCantidadDeSacrificios(int i, Stage nuevoStage) throws CantidadDeSacrificiosIncorrectaException{
        try {
            carta.verificarCantidadDeSacrificios(i);
        }
        catch (CantidadDeSacrificiosIncorrectaException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Cantidad Invalida de Sacrificios",ButtonType.CLOSE);
            alert.setHeight(40);
            alert.setWidth(50);
            alert.showAndWait();
            if (alert.getResult()==ButtonType.CLOSE)
                nuevoStage.close();
        }

    }

}
