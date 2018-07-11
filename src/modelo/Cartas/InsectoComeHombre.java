package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.Exceptions.CantidadDeSacrificiosIncorrectaException;
import modelo.CartaMonstruo;

public class InsectoComeHombre extends CartaMonstruo {

    private static String nombre = "Insecto Come-Hombre";
    private static int defensa = 600;
    private static int ataque = 450;
    private static int estrellas = 2;
    private Image imagen = new Image(getClass().getResourceAsStream("Insecto-Come-Hombres.png"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Insecto Come Hombre\n" +
                                        "Ataque: 450\n" +
                                        "Defensa: 600\n" +
                                        "Estrellas: 2\n" +
                                        "Efecto: Volteo / Al ser atacado, \n" +
                                        "destruye al monstruo que lo ataca");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }


    public InsectoComeHombre() {
        super(nombre, defensa, ataque, estrellas);
    }

    @Override
    public void activarEfectoAlRecibirAtaque(CartaMonstruo cartaMonstruo){
        cartaMonstruo.estaMuerta();

    }

    @Override
    public void verificarCantidadDeSacrificios(int cantidad) throws CantidadDeSacrificiosIncorrectaException {
        if (cantidad != 0)
            throw new CantidadDeSacrificiosIncorrectaException();

    }

}
