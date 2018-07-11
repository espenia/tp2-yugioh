package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class AcechadorDelCraneo extends CartaMonstruo {
	private static String nombre = "Acechador Del Craneo";
    private static int defensa = 800;
    private static int ataque = 900;
    private static int estrellas = 3;
	private Image imagen = new Image(getClass().getResourceAsStream("Acechador_del_craneo.jpg"));
	//private static Image imagen = new Image("file:src/modelo/Cartas/");
	private static Text datos = new Text("Nombre: Acechador Del Craneo\n" +
			"Ataque: 900\n" +
			"Defensa: 800\n" +
			"Estrellas: 3");

	@Override
	public Image getImagen(){
		return imagen;
	}

	@Override
	public Text getDatos(){
		return datos;
	}
    
	public AcechadorDelCraneo() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 0)
			throw new CantidadDeSacrificiosIncorrectaException();

	}
}
