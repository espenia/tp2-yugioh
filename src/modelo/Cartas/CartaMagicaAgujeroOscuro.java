package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class CartaMagicaAgujeroOscuro extends CartaMagica {

	private static Image imagen = new Image("file:src/modelo/Cartas/Agujero_oscuro.jpg");
	private static Text datos = new Text("Nombre: Agujero Negro\n" +
			"Efecto: Destruye todas las\n" + "cartas monstruo en el campo");


	@Override
	public Image getImagen(){
		return imagen;
	}

	@Override
	public Text getDatos(){
		return datos;
	}

	public CartaMagicaAgujeroOscuro() {
		super("AgujeroOscuro");
	}


	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
		for(CartaMonstruo actual: monstruosAliados) {
			actual.estaMuerta();
		}
		for(CartaMonstruo actual: monstruosEnemigos) {
			actual.estaMuerta();
		}
	}


	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		// TODO Auto-generated method stub
		
	}

}
