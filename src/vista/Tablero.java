package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.Cartas.MonstruoNulo;
import modelo.Cartas.SinCartaDeCampo;
import modelo.Cartas.UtilidadNula;
import modelo.Jugador;
import modelo.Mazo;
import modelo.MazoEstandar;

public class Tablero extends GridPane {//muestra los lados

    private Datos datos;
    private Jugador jugadorActual;
    private Jugador enemigoActual;
    private HBox monstruosJugadorActual;
    private HBox utilidadJugadorActual;
    private HBox monstruosEnemigoActual;
    private HBox utilidadjEnemigoActual;
    private Button cartaCampo;
    private Button mazo;
    private Button mazoFusion;



    public Tablero(Jugador juan, Jugador carlos, Jugador actual, Datos datos) {
        Image image = new Image("file:src/vista/fondo.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));//no funca

        this.setMinSize(1000,800);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(5);
        this.setHgap(5);
        this.setAlignment(Pos.CENTER);
        this.datos = datos;
        jugadorActual = actual;
        if (actual == juan)
            enemigoActual = carlos;
        else enemigoActual = juan;

        monstruosJugadorActual = new HBox();
        monstruosEnemigoActual = new HBox();
        utilidadJugadorActual = new HBox();
        utilidadjEnemigoActual = new HBox();

        setearLadoDeJugadorActual();
        setearLadoDeEnemigoActual();



    }

    private void setearLadoDeEnemigoActual() {
        for (int i = 0 ; i < 5 ; i++){
            Button cartaMonstruo = new BotonCartaMonstruoEnemiga(enemigoActual,new MonstruoNulo(),datos);
            Button cartaDeUtilidad = new BotonCartaDeUtilidadEnemiga(enemigoActual,new UtilidadNula(),datos);
            monstruosEnemigoActual.getChildren().add(cartaMonstruo);
            utilidadjEnemigoActual.getChildren().add(cartaDeUtilidad);

        }
        monstruosEnemigoActual.setSpacing(10);
        utilidadjEnemigoActual.setSpacing(10);
        this.add(monstruosEnemigoActual,2,2);
        this.add(utilidadjEnemigoActual,2,1);

    }

    private void setearLadoDeJugadorActual() {

        for (int i = 0 ; i < 5 ; i++){
            Button cartaMonstruo = new BotonCartaMonstruo(jugadorActual,new MonstruoNulo(),datos);
            Button cartaDeUtilidad = new BotonCartaDeUtilidad(jugadorActual,new UtilidadNula(),datos);
            monstruosJugadorActual.getChildren().add(cartaMonstruo);
            utilidadJugadorActual.getChildren().add(cartaDeUtilidad);

        }
        monstruosJugadorActual.setSpacing(10);
        utilidadJugadorActual.setSpacing(10);
        this.add(monstruosJugadorActual,2,4);
        this.add(utilidadJugadorActual,2,5);

        cartaCampo = new BotonCarta(jugadorActual,new SinCartaDeCampo(),datos);
        this.add(cartaCampo,1,4);
        mazo = new BotonMazo(jugadorActual,jugadorActual.getMazo(),datos);
        this.add(mazo,3,5);
        mazoFusion = new BotonMazoFusion(jugadorActual,jugadorActual.getMazoDeFusion(),datos);
        this.add(mazoFusion,1,5);


    }
}
