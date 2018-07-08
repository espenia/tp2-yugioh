package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class Conedragon extends CartaMonstruo {
	private static String nombre = "ConeDragon";
    private static int defensa = 2900;
    private static int ataque = 2950;
    private static int estrellas = 8;
	private static Image imagen = new Image("file:src/modelo/Cartas/Conedragón.jpg");
	private static Text datos = new Text("Nombre: ConeDragon\n" +
			"Ataque: 2950\n" +
			"Defensa: 2900\n" +
			"Estrellas: 8");

	@Override
	public Image getImagen(){
		return imagen;
	}

	@Override
	public Text getDatos(){
		return datos;
	}
    
	public Conedragon() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 2)
			throw new CantidadDeSacrificiosIncorrectaException();

	}


}
