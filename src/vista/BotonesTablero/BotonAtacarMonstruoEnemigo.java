package vista.BotonesTablero;

import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Exceptions.AccionInvalidaEnFaseException;
import modelo.Exceptions.MonstruoNoPuedeAtacarDosVecesEnUnTurnoException;
import vista.JuegoScene;
import vista.Posiciones;
import vista.Tablero;

public class BotonAtacarMonstruoEnemigo extends Button {
	
	public BotonAtacarMonstruoEnemigo(Stage stage, Jugador jugador, Carta carta, Tablero tablero, JuegoScene juegoScene) {

        this.setText("Monstruo Enemigo");
        this.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) throws AccionInvalidaEnFaseException{
	        	try {
	                if (carta instanceof CartaMonstruo){
	                    try{
	                    	ArrayList<CartaMonstruo> seleccionada = new Posiciones(jugador.getJugadorEnemigo().getCartasMonstruos(), "Indique la posicion del\n monstruo que quiere atacar");
	                        if (!seleccionada.isEmpty()){
								seleccionada.add(seleccionada.get(0));
	                        	jugador.atacarAMonstruo((CartaMonstruo)carta, seleccionada.get(0));
	                        }
	                    }
	                    catch (MonstruoNoPuedeAtacarDosVecesEnUnTurnoException e) {
	                    	Alert alert = new Alert(Alert.AlertType.ERROR,"No se puede atacar dos veces con el mismo Monstruo!",ButtonType.CLOSE);
	    	                alert.setHeight(40);
	    	                alert.setWidth(50);
	    	                alert.showAndWait();
	    	                if (alert.getResult()==ButtonType.CLOSE)
	    	                    stage.close();
	                    }
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
	                Alert alert = new Alert(Alert.AlertType.ERROR,"Accion Invalida en Fase Actual",ButtonType.CLOSE);
	                alert.setHeight(40);
	                alert.setWidth(50);
	                alert.showAndWait();
	                if (alert.getResult()==ButtonType.CLOSE)
	                    stage.close();
	            }
	
	            juegoScene.configurarPanel();
        	}
        });
    }
}
