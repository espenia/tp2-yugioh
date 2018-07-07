package vista;



import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.Jugador;

public class JuegoScene extends BorderPane {

    private Juego juego;
    private Jugador juan;
    private Jugador carlos;
    private Stage primaryStage;
    private MenuBar barraDeMenu;
    private ManoDeJugador mano;
    private Tablero tablero;
    private Datos datosDeCartas;
    private Botonera botonera;

    public JuegoScene(Jugador jugador1, Jugador jugador2,Stage stage) {
        primaryStage = stage;
        juan = jugador1;
        carlos = jugador2;
        juego = new Juego(juan,carlos);
        configurarPane();
        //while (juego.getPartidaEnCurso())
            //actualizarPane();


    }


    private void configurarPane() {

        Image background = new Image("file:src/vista/fondo15.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);


        this.setMinSize(background.getWidth(), background.getHeight());

        barraDeMenu = new BarraDeMenu();
        this.setTop(barraDeMenu);

        mano = new ManoDeJugador(juego.getActual());
        this.setBottom(mano);

        tablero = new Tablero(juan,carlos,juego.getActual());
        this.setCenter(tablero);

        datosDeCartas = new Datos();
        this.setRight(datosDeCartas);

        botonera = new Botonera(juego);
        this.setLeft(botonera);






        this.setBackground(new Background(imagenDeFondo));



    }

    private void actualizarPane() {


    }
}
