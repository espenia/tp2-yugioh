package vista;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.Carta;
import modelo.Jugador;

import java.util.ArrayList;
import java.util.List;


public class ManoDeJugador extends ScrollPane{//cartas de la mano del jugador actual

    private Jugador jugador;
    private List<Carta> mano;
    private List<ImageView> imagenesDeCartas = new ArrayList<>();
    private HBox cartasDeLaMano;

    public ManoDeJugador(Jugador jugador){
        cartasDeLaMano = new HBox();
        this.jugador = jugador;
        Image image = new Image("file:src/vista/fondo.jpg");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(10*150);
        imageView.setFitHeight(2*100);
        actualizarMano();


    }

    public void actualizarMano() {
        mano = jugador.devolverMano();
        for (Carta i : mano){
            ImageView imagen = new ImageView(i.getImagen());
            imagen.setFitHeight(150);
            imagen.setFitWidth(100);
            imagenesDeCartas.add(imagen);
        }
        for (ImageView i: imagenesDeCartas)
            cartasDeLaMano.getChildren().add(i);
        this.setContent(cartasDeLaMano);
        this.setPrefSize(10*150,2*100);


    }


}
