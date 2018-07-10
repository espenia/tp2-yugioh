package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaMonstruo;

public class MonstruoNulo extends CartaMonstruo {

    private static String nombre = "nulo";
    private static int ataque = 0;
    private static int defensa = 0;
    private static int estrella = 1;

    private Image image = new Image("file:src/modelo/Cartas/Monstruo_Nulo.png");
    private Text text = new Text("Monstruo No Invocado");


    public MonstruoNulo() {
        super(nombre, ataque, defensa, estrella);
    }

    @Override
    public Image getImagen(){
        return image;
    }

    @Override
    public Text getDatos(){
        return text;
    }


}
