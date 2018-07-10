package vista;



import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private Text puntosDeVidaJuan;
    private Text puntosDeVidaCarlos;
    private Text faseActual;

    public JuegoScene(Jugador jugador1, Jugador jugador2,Stage stage) {
        primaryStage = stage;
        juan = jugador1;
        carlos = jugador2;
        juego = new Juego(juan,carlos);
        configurarPanel();
        //while (juego.getPartidaEnCurso())
            //actualizarPane();


    }


    private void configurarPanel() {

        //Image background = new Image("file:src/vista/fondo15.jpg");
        //BackgroundImage imagenDeFondo = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        this.setId("pantallas-juego");
        barraDeMenu = new BarraDeMenu(this.primaryStage);
        this.setTop(barraDeMenu);

        datosDeCartas = new Datos();
        setearIzquierda();
        this.setRight(datosDeCartas);

        tablero = new Tablero(juan,carlos,juego.getActual(),datosDeCartas);
        this.setCenter(tablero);


        mano = new ManoDeJugador(juego.getActual(),tablero,datosDeCartas);
        this.setBottom(mano);


       // this.setBackground(new Background(imagenDeFondo));


    }

    private void setearIzquierda() {
    	if(this.getLeft() instanceof VBox) {
    		((VBox) this.getLeft()).getChildren().clear();
    	}
        puntosDeVidaJuan = new Text("JUAN:\n" + getPuntosDeVida(juan));
        puntosDeVidaJuan.setFont(Font.font(20));
        puntosDeVidaJuan.setStroke(Color.WHITE);
        puntosDeVidaCarlos = new Text("CARLOS:\n" + getPuntosDeVida(carlos));
        puntosDeVidaCarlos.setFont(Font.font(20));
        puntosDeVidaCarlos.setStroke(Color.WHITE);

        Button siguienteFase = new Button("Siguiente Fase");
        SiguienteFaseEventaHandler siguienteFaseEventaHandler = new SiguienteFaseEventaHandler(juego, this);
        siguienteFase.setOnAction(siguienteFaseEventaHandler);
        faseActual = new Text(this.getFaseActual());
        faseActual.setFont(Font.font(25));
        faseActual.setStroke(Color.WHITE);
        Button siguienteTurno = new Button("Siguiente Turno");
        SiguienteTurnoEventaHandler siguienteTurnoEventaHandler = new SiguienteTurnoEventaHandler(juego,this);
        siguienteTurno.setOnAction(siguienteTurnoEventaHandler);

        VBox botones = new VBox();
        botones.getChildren().addAll(puntosDeVidaCarlos,siguienteFase,faseActual,siguienteTurno,puntosDeVidaJuan);
        botones.setSpacing(100);
        this.setLeft(botones);
    }

    private String getPuntosDeVida(Jugador juan) {
        Float aux = (float)juan.getPuntosDeVida();
        return aux.toString();


    }
    
    private String getFaseActual() {
    	return this.juego.getFase().obtenerFase();
    }
    
    private void actualizarPanel() {
    	setearIzquierda();

    }


	public void cambiarFase() {
		actualizarPanel();
	}
}
