package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class AbismoReluciente extends CartaMonstruo {
	private static String nombre = "Abismo Reluciente";
    private static int defensa = 1600;
    private static int ataque = 1800;
    private static int estrellas = 4;
	private Image imagen = new Image(getClass().getResourceAsStream("Abismo_reluciente.jpg"));
	//private static Image imagen = new Image("file:src/modelo/Cartas/");
	private static Text datos = new Text("Nombre: Abismo Reluciente\n" +
			"Ataque: 1800\n" +
			"Defensa: 1600\n" +
			"Estrellas: 4");

	@Override
	public Image getImagen(){
		return imagen;
	}

	@Override
	public Text getDatos(){
		return datos;
	}
    
	public AbismoReluciente() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 0)
			throw new CantidadDeSacrificiosIncorrectaException();

	}
	
}
