package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.*;

public class Reinforcements extends CartaTrampa {

    private EstadoDeCarta estadoDeCarta;

    public Reinforcements() {
        super("Reinforcements");
        estadoDeCarta = new EstadoBocaAbajo();
    }
    private Image imagen = new Image(getClass().getResourceAsStream("Refuerzos.jpg"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Reinforcements\n" +
            "Efecto: Aumenta el ataque\n" + " del monstruo atacado por 500 puntos");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }

    @Override
    public void activarTrampa(Lado lado, Lado ladoEnemigo) {
    }

    @Override
    public void activarTrampaDeAtaque(Jugador jugador, CartaMonstruo carta) {
        estadoDeCarta = new EstadoBocaArriba();
    	carta.aplicarBuff(0,500);
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {

    }

}
