package modelo.Cartas;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mazo;

public class Reinforcements extends CartaTrampa {

    public Reinforcements() {
        super("Reinforcements");
    }

    private static Image imagen = new Image("file:src/modelo/Cartas/Refuerzos.jpg");
    private static Text datos = new Text("Nombre: Reinforcements\n" +
            "Efecto: Aumenta el ataque del monstruo atacado por 500 puntos");

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
    	carta.aplicarBuff(0,400);
    }

    @Override
    public void activarEfecto(List<CartaMonstruo> monstruosAliados, List<CartaMonstruo> monstruosEnemigos, Mazo mazo, Jugador jugador, Jugador enemigo) {

    }

}
