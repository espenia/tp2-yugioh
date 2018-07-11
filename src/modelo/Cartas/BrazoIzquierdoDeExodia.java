package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class BrazoIzquierdoDeExodia extends CartaMonstruo {
    private static String nombre = "Brazo Izquierdo De Exodia";
    private static int defensa = 300;
    private static int ataque = 200;
    private static int estrellas = 1;
    private Image imagen = new Image(getClass().getResourceAsStream("Brazo izquierdo del prohibido.jpg"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Brazo Izquierdo\n" +
    		"De Exodia El Prohibido" +
            "Ataque: 200\n" +
            "Defensa: 300\n" +
            "Estrellas: 1");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    public BrazoIzquierdoDeExodia() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }

}
