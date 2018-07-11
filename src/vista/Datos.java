package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modelo.Carta;
import modelo.Jugador;
import modelo.Mazo;

import java.util.Stack;


public class Datos extends GridPane{


    public Datos(){//datos de cartas que fue clickeada



    	this.setId("datos-carta");
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(5);
        this.setHgap(5);
        this.setAlignment(Pos.CENTER);

    }

    public void mostrarDatosDeCarta(Carta carta){

        this.getChildren().clear();
        Image imagen = carta.getImagen();
        ImageView imageView = new ImageView(imagen);
        imageView.setFitHeight(300);
        imageView.setFitWidth(200);
        this.add(imageView,1,1);
        StackPane stackPane = new StackPane();
        Rectangle rectangle = new Rectangle(300,200,300,200);
        rectangle.setFill(Color.BLACK);
        Text text = carta.getDatos();
        text.setFont(Font.font(14));
        text.setStroke(Color.WHITE);
        this.setId("texto-carta");
        stackPane.getChildren().addAll(rectangle,text);
        this.add(stackPane,1,2);
    }


}
