package vista;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.Jugador;


public class JuegoScene extends BorderPane {

    private Aplicacion aplication;
    private Jugador enimigo;
    private Jugador actual;
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
    private AudioClip sound;

    public JuegoScene(Jugador jugador1, Jugador jugador2, Stage stage, Aplicacion aplicacion, AudioClip newSound) {
        sound = newSound;
        primaryStage = stage;
        juan = jugador1;
        carlos = jugador2;
        aplication = aplicacion;
        juego = new Juego(juan,carlos);
        configurarPanel();


    }


    public void configurarPanel() {
        actual = juego.getActual();
        if (actual == juan)
            enimigo = carlos;
        else enimigo = juan;

        this.setId("pantallas-juego");
        barraDeMenu = new BarraDeMenu(this.primaryStage,aplication);
        this.setTop(barraDeMenu);

        datosDeCartas = new Datos();
        setearIzquierda();
        this.setRight(datosDeCartas);

        tablero = new Tablero(juan,carlos,juego.getActual(),datosDeCartas,this);
        this.setCenter(tablero);


        mano = new ManoDeJugador(juego.getActual(),tablero,datosDeCartas);
        this.setBottom(mano);

        if (!juego.getPartidaEnCurso())
            gano(juego.getGanador());


    }

    private void gano(Jugador ganador) {
        if (ganador == carlos)
            primaryStage.setScene( pantallaGanador(new Image("file:src/vista/pantalla_Ganador_carlos.jpg"),carlos));
        else primaryStage.setScene( pantallaGanador(new Image("file:src/vista/pantalla_ganador_juan.jpg"),juan));
        primaryStage.setTitle("GAME OVER");
        primaryStage.show();
    }

    private Scene pantallaGanador(Image image, Jugador ganador){


        BackgroundImage imagenDeFondo = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);

        GridPane gridPane = new GridPane();
        setid(ganador,gridPane);
        gridPane.setMinSize(image.getWidth(), image.getHeight());

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add("file:src/vista/style.css");
        gridPane.setVgap(5);
        gridPane.setHgap(5);


        gridPane.setAlignment(Pos.CENTER);

        Button cerrar = new Button("Cerrar");
        cerrar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    sound.stop();
                    aplication.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gridPane.add(cerrar,5,100);


        gridPane.setBackground(new Background(imagenDeFondo));
        return scene;
    }

    private void setid(Jugador ganador, GridPane gridPane) {
        if (ganador == carlos)
            gridPane.setId("pantalla-victoria-carlos");
        else gridPane.setId("pantalla-victoria-juan");
    }

    public void rendirse() {
        gano(enimigo);
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
        if (actual == carlos)
            botones.getChildren().addAll(puntosDeVidaJuan,siguienteFase,faseActual,siguienteTurno,puntosDeVidaCarlos);
        else botones.getChildren().addAll(puntosDeVidaCarlos,siguienteFase,faseActual,siguienteTurno,puntosDeVidaJuan);
        botones.setSpacing(70);
        this.setLeft(botones);
    }

    private String getPuntosDeVida(Jugador juan) {
        Float aux = (float)juan.getPuntosDeVida();
        return aux.toString();


    }
    
    private String getFaseActual() {
    	return this.juego.getFase().obtenerFase();
    }
    



	public void cambiarFase() {
		configurarPanel();
	}

}
