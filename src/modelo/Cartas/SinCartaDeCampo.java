package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class SinCartaDeCampo extends CartaDeCampo {


    private Image image = new Image("file:src/modelo/Cartas/Sin_Carta_De_Campo.png");
    private Text text = new Text("Carta De Campo No Jugada");

    public SinCartaDeCampo() {
        super("SinCartaDeCampo");
    }

    @Override
    public void aplicarBuff(CartaMonstruo carta, Lado unLado) {

    }

    @Override
    public void aplicarBuffPrincipal(CartaMonstruo carta) {

    }

    @Override
    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta) {

    }

    @Override
    public void revertirBuffDelLadoEnemigo(CartaMonstruo carta) {

    }

    @Override
    public void revertirBuffPrincipal(CartaMonstruo carta) {

    }

    @Override
    public void asignarLado(Lado unLado) {

    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

	@Override
	public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
	}

    @Override
    public Image getImagen() {
        return image;
    }

    @Override
    public Text getDatos() {
        return text;
    }

}
