package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;

import java.util.List;

public class Jinzo7 extends CartaMonstruo {
    private static String nombre = "Jinzo #7";
    private static int defensa = 400;
    private static int ataque = 500;
    private static int estrellas = 2;
    private static Image imagen = new Image("file:src/modelo/Cartas/Jinzo_7.jpg");
    private static Text datos = new Text("Nombre: Jinzo #7\n" +
            "Ataque: 500\n" +
            "Defensa: 450\n" +
            "Estrellas: 2\n" +
            "Efecto: Este monstruo puede atacar\n" + "directamente a los puntos de vida ");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    public Jinzo7() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
        atacarA(enemigo);

    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }
}
