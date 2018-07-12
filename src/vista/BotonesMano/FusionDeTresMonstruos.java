package vista.BotonesMano;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Exceptions.NoAdmiteFusionException;
import modelo.Jugador;
import vista.Posiciones;

import java.util.ArrayList;

public class FusionDeTresMonstruos {


    private  ArrayList<CartaMonstruo> seleccionados;
    private  Jugador jugador;
    private  Carta carta;

    public FusionDeTresMonstruos(Jugador jugador) throws NoAdmiteFusionException{
        seleccionados = new ArrayList<>();
        this.jugador = jugador;
        for (int i = 0; i < 3 ; i++){
            ArrayList<CartaMonstruo> seleccionado = new Posiciones(jugador.getCartasMonstruos(),"Indique la carta que quiere\n sacrificar Para Formar una Fusion\n De Su Mazo De Fusiones");
            if (seleccionado.isEmpty())
                break;
            seleccionados.add(seleccionado.get(0));
        }
        try {
            if (seleccionados.size() == 3)
                jugador.fusionDeTresMonstruos(seleccionados.get(0),seleccionados.get(1),seleccionados.get(2));
        }
        catch (NoAdmiteFusionException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Esos monstruos no Admiten Fusion", ButtonType.CLOSE);
            alert.setHeight(40);
            alert.setWidth(50);
            alert.showAndWait();
        }


    }
}
