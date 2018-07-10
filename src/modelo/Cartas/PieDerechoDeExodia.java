package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class PieDerechoDeExodia extends CartaMonstruo {
    private static String nombre = "Pie Derecho De Exodia";
    private static int defensa = 300;
    private static int ataque = 200;
    private static int estrellas = 1;
    private static Image imagen = new Image("file:src/modelo/Cartas/Pierna_derecha_del_ex.jpg");
    private static Text datos = new Text("Nombre: Pierna Derecha\n" + " De Exodia El Prohibido\n" +
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

    public PieDerechoDeExodia() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }
}
