package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class Exodia extends CartaMonstruo {

    private static String nombre = "Exodia";
    private static int defensa = 1000;
    private static int ataque = 1000;
    private static int estrellas = 3;
    private static Image imagen = new Image("file:src/modelo/Cartas/exodia.jpg");
    private static Text datos = new Text("Nombre: Exodia\n" +
            "Ataque: 1000\n" +
            "Defensa: 1000\n" +
            "Estrellas: 3");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    public Exodia() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }

}
