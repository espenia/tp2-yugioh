package vista;

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
import modelo.Exceptions.HayUnMonstruoEnElCaminoException;
import modelo.Exceptions.MonstruoNoPuedeAtacarDosVecesEnUnTurnoException;

public class BotonAtacarJugadorEnemigo extends Button {
	
	private Jugador jugador;
    private Carta carta;
    private Tablero tablero;
    
    
    public BotonAtacarJugadorEnemigo(Stage stage, Jugador jugador, Carta carta, Tablero tablero) {
        this.carta = carta;
        this.jugador = jugador;
        this.tablero = tablero;

        this.setText("Jugador Enemigo");
        this.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) throws AccionInvalidaEnFaseException{
	        	try {
	                if (carta instanceof CartaMonstruo){
	                    try{
	                    	jugador.atacar((CartaMonstruo) carta, jugador.getJugadorEnemigo());
	                    }
	                    catch (HayUnMonstruoEnElCaminoException e) {
	                    	Alert alert = new Alert(Alert.AlertType.ERROR,"Hay Monstruos enemigos en el camino!",ButtonType.CLOSE);
	    	                alert.setHeight(40);
	    	                alert.setWidth(50);
	    	                alert.showAndWait();
	    	                if (alert.getResult()==ButtonType.CLOSE)
	    	                    stage.close();
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
	
	            BotonAtacarJugadorEnemigo.this.tablero.actualizarTablero();
        	}
        });
    }
}
