package vista.BotonesTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaDeUtilidad;
import modelo.CartaMonstruo;
import modelo.Cartas.MonstruoNulo;
import modelo.Cartas.UtilidadNula;
import modelo.Jugador;
import vista.Datos;

public class BotonCartaDeUtilidadEnemiga extends Button {
    private Jugador jugador;
    private CartaDeUtilidad carta;
    private Datos dato;

    public BotonCartaDeUtilidadEnemiga(Jugador enemigoActual, CartaDeUtilidad utilidad, Datos datos) {
        jugador = enemigoActual;
        carta = utilidad;
        dato = datos;
        if (utilidad instanceof UtilidadNula)
            setearGrafico(utilidad);
        else
            setearGrafico((CartaDeUtilidad)(carta.estadoDeCarta()));

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (carta instanceof UtilidadNula)
                    dato.mostrarDatosDeCarta(carta);
                else {
                    dato.mostrarDatosDeCarta(carta.estadoDeCarta());
                }
            }
        });


    }

    private void setearGrafico(CartaDeUtilidad carta) {
        ImageView imageView = new ImageView(carta.getImagen());
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);
    }
}
