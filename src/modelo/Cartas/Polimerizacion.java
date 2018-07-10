package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;

public class Polimerizacion extends CartaMagica {


    public Polimerizacion() {
        super("Polimerizacion");
    }

    private static Image imagen = new Image("file:src/modelo/Cartas/Polimerización.jpg");
    private static Text datos = new Text("Nombre: Polimerizacion\n" +
            "Efecto: Habilita la\n " + " fusion de monstruos");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    	jugador.habilitarFusion(new Fusion());

    }


    @Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
