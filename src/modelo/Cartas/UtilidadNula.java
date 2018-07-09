package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;

import java.util.List;

public class UtilidadNula  extends CartaDeUtilidad{


    private static String nombreDeCarta = "Carta Nula";

    private Image imagen = new Image("file:src/modelo/Cartas/Utilidad_nula.png");
    private Text text = new Text("Carta De Utilidad No Jugada");


    public UtilidadNula() {
        super(nombreDeCarta);
    }

    @Override
    public void activarTrampa(Lado lado, Lado ladoEnemigo) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {

    }

    @Override
    public Image getImagen() {
        return imagen;
    }

    @Override
    public Text getDatos() {
        return text;
    }
}
