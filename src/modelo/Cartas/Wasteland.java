package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Jugador;
import modelo.Mazo;

public class Wasteland extends CartaDeCampo {

    private int buffDeDefensa = 300;
    private int buffDeAtaque = 200;

    public Wasteland() {
        super("Wasteland");

    }


    private Image imagen = new Image(getClass().getResourceAsStream("Wasteland.png"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Wasteland\n" +
            "Efecto: Aumenta el ataque de\n " +
    		"tus cartas monstruos por 200 puntos,\n" +
            "y Aumenta la defensa de las cartas monstruos \n" +
    		" de tu enemigo por 300 puntos");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    @Override
    public void colocarEn(EstadoDeCarta unEstado) {

    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {
    }


    public void aplicarBuffPrincipal(CartaMonstruo carta){
        carta.aplicarBuff(0,buffDeAtaque);

    }

    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(buffDeDefensa,0);

    }

    @Override
    public void revertirBuffDelLadoEnemigo(CartaMonstruo carta) {
        carta.aplicarBuff(-buffDeDefensa,0);
    }

    @Override
    public void revertirBuffPrincipal(CartaMonstruo carta) {
        carta.aplicarBuff(0,-buffDeAtaque);
    }


}
