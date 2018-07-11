package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Carta;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class OllaDeLaCodicia extends CartaMagica {


    private Image imagen = new Image(getClass().getResourceAsStream("Olla_de_la_codicia.jpg"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Olla de la Codicia\n" +
            "Efecto: Extrae dos cartas del mazo");


    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    public OllaDeLaCodicia() {
        super("OllaDeLaCodicia");
    }



    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    	for ( int i = 0 ; i < 2; i++){
            Carta auxiliar = mazo.extraerCarta();
            jugador.darCarta(auxiliar);
        }
    }


    @Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
