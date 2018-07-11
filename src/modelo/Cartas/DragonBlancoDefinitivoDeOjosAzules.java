package modelo.Cartas;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import modelo.CartaMonstruo;
import modelo.EstadoBocaArriba;
import modelo.PosicionAtaque;

import java.util.List;

public class DragonBlancoDefinitivoDeOjosAzules extends CartaMonstruo {
    private static String nombre = "Dragon Blanco Definitivo De Ojos Azules";
    private static int defensa = 3800;
    private static int ataque = 4500;
    private static int estrellas = 12;
    private Image imagen = new Image(getClass().getResourceAsStream("Dragon_de_ojos_azules_definitivo.jpg"));
    //private static Image imagen = new Image("file:src/modelo/Cartas/");
    private static Text datos = new Text("Nombre: Dragon Definitivo\n" + " De Ojos Azules\n" +
            "Ataque: 4500\n" +
            "Defensa: 3800\n" +
            "Estrellas: 12");

    @Override
    public Image getImagen(){
        return imagen;
    }

    @Override
    public Text getDatos(){
        return datos;
    }


    public DragonBlancoDefinitivoDeOjosAzules() {
        super(nombre, defensa, ataque, estrellas);
        colocarEn(new EstadoBocaArriba());
        enPosicion(new PosicionAtaque());

    }
    @Override
    public boolean esFusionDe(List<CartaMonstruo> cartas){
        for (CartaMonstruo i: cartas){
            if (i.getNombre() != "Dragon Blanco De Ojos Azules")
                return false;

        }
        return true;

    }


}
