package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.CartaDeUtilidad;
import modelo.CartaMonstruo;
import modelo.Cartas.MonstruoNulo;
import modelo.Cartas.UtilidadNula;
import modelo.Jugador;

public class BotonCartaDeUtilidad extends Button {
    private  Jugador jugador;
    private  CartaDeUtilidad carta;
    private  Datos dato;

    public BotonCartaDeUtilidad(Jugador jugadorActual, CartaDeUtilidad utilidad, Datos datos) {
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
            }
        });




    }

    private void setearGrafico(CartaDeUtilidad utilidad) {
        ImageView imageView = new ImageView(utilidad.getImagen());
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        this.setGraphic(imageView);
    }
}
