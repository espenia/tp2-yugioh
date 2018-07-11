package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;

public class CartaTrampaCilindroMagico extends CartaTrampa {


    private static EstadoDeCarta estadoDeCarta;
    private Image imagen = new Image(getClass().getResourceAsStream("Cilindro_magico.jpg"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Cilindro Magico\n" +
            "Efecto: Cuando un monstruo enemigo \n" + 
    		"declara un ataque, \n" + 
            "niega al ataque y los\n" + 
    		" redirige hacia al enemigo");


    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    public CartaTrampaCilindroMagico() {
        super("CilindroMagico");
        estadoDeCarta = new EstadoBocaAbajo();

    }

    @Override
    public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
        estadoDeCarta = new EstadoBocaArriba();
        jugador.notificarDanioAlEnemigo(carta.getAtaque());
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
	}

	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
		
	}
}
