package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class CartaTrampaCilindroMagico extends CartaTrampa {

    private static Image imagen = new Image("file:src/modelo/Cartas/Cilindro_mágico.jpg");
    private static Text datos = new Text("Nombre: Cilindro Magico\n" +
            "Efecto: Cuando un monstruo enemigo declara un ataque, niega al ataque y los redirige hacia al enemigo");


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

    }

    @Override
    public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
        jugador.notificarDanioAlEnemigo(carta.getAtaque());
    }

	@Override
	public void activarTrampa(Lado lado, Lado ladoEnemigo) {
	}

	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
		
	}
}
