package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaDeCampo;
import modelo.CartaMonstruo;
import modelo.EstadoDeCarta;
import modelo.Jugador;
import modelo.Mazo;

public class Sogen extends CartaDeCampo {

    private int buffDeDefensa = 500;
    private int buffDeAtaque = 200;

    public Sogen() {
        super("Sogen");
    }


    private static Image imagen = new Image("file:src/modelo/Cartas/Sogen.jpg");
    private static Text datos = new Text("Nombre: Sogen\n" +
            "Efecto: Aumenta la defensa de\n" + " tus cartas monstruos por 500 puntos,\n" + " y Aumenta el ataque de las cartas\n " + " monstruos de tu enemigo \n" + "por 200 puntos");

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
        carta.aplicarBuff(buffDeDefensa,0);

    }

    public void aplicarBuffDelLadoEnemigo(CartaMonstruo carta){
        carta.aplicarBuff(0, buffDeAtaque);

    }

    @Override
    public void revertirBuffDelLadoEnemigo(CartaMonstruo carta) {
        carta.aplicarBuff(0,-buffDeAtaque);
    }

    @Override
    public void revertirBuffPrincipal(CartaMonstruo carta) {
        carta.aplicarBuff(-buffDeDefensa,0);

    }


}