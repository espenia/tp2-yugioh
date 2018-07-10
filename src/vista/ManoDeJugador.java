package vista;


import javafx.scene.control.ScrollPane;
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
        this.setId("carta-mano-jugador");
        actualizarMano();
    }

    public void actualizarMano() {
        cartasDeLaMano.getChildren().clear();
        mano = jugador.devolverMano();
        for (Carta i : mano){
            ImageView imagen = new ImageView(i.getImagen());
            imagen.setFitHeight(150);
            imagen.setFitWidth(100);
            BotonCartaEnMano botonCartaEnMano = new BotonCartaEnMano(imagen,jugador,i,datos,tablero,this);
            botonCartaEnMano.setPrefSize(150, 100);
            cartasDeLaMano.getChildren().add(botonCartaEnMano);
        }
        this.setContent(cartasDeLaMano);
        //this.setPrefSize(10*150,2*100);

    }




}
