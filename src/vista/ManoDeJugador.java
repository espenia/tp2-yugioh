package vista;


import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.Carta;
import modelo.Jugador;
import java.util.List;


public class ManoDeJugador extends ScrollPane{//cartas de la mano del jugador actual

    private Tablero tablero;
    private Jugador jugador;
    private List<Carta> mano;
    private HBox cartasDeLaMano;
    private Datos datos;

    public ManoDeJugador(Jugador jugador, Tablero tablero, Datos datos){
        cartasDeLaMano = new HBox();
        this.jugador = jugador;
        this.datos = datos;
        this.tablero = tablero;
        Image image = new Image("file:src/vista/fondo.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        cartasDeLaMano.setBackground(new Background(backgroundImage));//no funca
        actualizarMano();


    }

    public void actualizarMano() {
        mano = jugador.devolverMano();
        for (Carta i : mano){
            ImageView imagen = new ImageView(i.getImagen());
            imagen.setFitHeight(150);
            imagen.setFitWidth(100);
            BotonCartaEnMano botonCartaEnMano = new BotonCartaEnMano(imagen,jugador,i,datos);
            cartasDeLaMano.getChildren().add(botonCartaEnMano);

        }

        this.setContent(cartasDeLaMano);
        this.setPrefSize(10*150,2*100);


    }


}