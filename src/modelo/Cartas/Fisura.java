package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;
import modelo.Exceptions.LadoNoContieneCartaException;
import modelo.Mazo;

public class Fisura extends CartaMagica {

	private Image imagen = new Image(getClass().getResourceAsStream("Fisura.jpg"));
	//private static Image imagen = new Image("file:src/modelo/Cartas/");
	private static Text datos = new Text("Nombre: Fisura\n" +
			"Efecto: Destruye la Carta monstruo\n" + " de menor defensa del enemigo");


	@Override
	public Image getImagen(){
		return imagen;
	}

	@Override
	public Text getDatos(){
		return datos;
	}

	
    public Fisura() {
        super("Fisura");
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    	if(monstruosEnemigos.isEmpty()) {
    		return;
    	}
    	CartaMonstruo monstruoDeMenorAtaque = monstruosEnemigos.get(0);
    	for (int i = 1; i < monstruosEnemigos.size(); i++) {
    	    CartaMonstruo actual = monstruosEnemigos.get(i); {
			if(actual.getAtaque() < monstruoDeMenorAtaque.getAtaque())
				monstruoDeMenorAtaque = actual;
    	    }
		}
    	monstruoDeMenorAtaque.estaMuerta();   	
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
		
	}
}
