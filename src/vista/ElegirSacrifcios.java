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


public class ElegirSacrifcios {
    private ArrayList cartas;
    private ArrayList seleccionadas = new ArrayList();

    public ElegirSacrifcios(int i, Tablero tablero, CartaMonstruo carta, Jugador jugador) {
        cartas = (ArrayList) jugador.getCartasMonstruos();
        for (int j = 0; j < i; j++) {
            ArrayList<CartaMonstruo> seleccionada = new Posiciones(jugador.getCartasMonstruos(), "Indique la posicion del\n monstruo que quiere sacrificar");
            if (!seleccionada.isEmpty())
                seleccionadas.add(seleccionada.get(0));
        }
        if (!seleccionadas.isEmpty()){
            if (i == 3)
                jugador.jugarCartaEnLadoConTresSacrificio(carta, (CartaMonstruo) seleccionadas.get(0), (CartaMonstruo) seleccionadas.get(1), (CartaMonstruo) seleccionadas.get(2));
            if (i == 2)
                jugador.jugarCartaEnLadoConDosSacrificio(carta, (CartaMonstruo) seleccionadas.get(0), (CartaMonstruo) seleccionadas.get(1));
            if (i == 1)
                jugador.jugarCartaEnLadoConUnSacrificio(carta, (CartaMonstruo) seleccionadas.get(0));

            new colocarEnEstado(jugador, carta);
        }

    }

}