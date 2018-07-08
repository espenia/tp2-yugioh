package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class AligatorCibertech extends CartaMonstruo {
	private static String nombre = "Aligator Cibertech";
    private static int defensa = 1600;
    private static int ataque = 2500;
    private static int estrellas = 5;
	private static Image imagen = new Image("file:src/modelo/Cartas/CyberTechAlligator.png");
	private static Text datos = new Text("Nombre: Aligator CyberTech\n" +
			"Ataque: 2500\n" +
			"Defensa: 1600\n" +
			"Estrellas: 5");

	@Override
	public Image getImagen(){
		return imagen;
	}

	@Override
	public Text getDatos(){
		return datos;
	}
    
	public AligatorCibertech() {
		super(nombre, defensa, ataque, estrellas);
	}

	@Override
	public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
		if (cantidad != 1)
			throw new CantidadDeSacrificiosIncorrectaException();

	}

}
