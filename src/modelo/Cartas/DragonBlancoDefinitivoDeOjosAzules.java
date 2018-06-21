package modelo.Cartas;

import modelo.CartaMonstruo;

import java.util.List;

public class DragonBlancoDefinitivoDeOjosAzules extends CartaMonstruo {
    private static String nombre = "Dragon Blanco Definitivo De Ojos Azules";
    private static int defensa = 3800;
    private static int ataque = 4500;
    private static int estrellas = 12;

    public DragonBlancoDefinitivoDeOjosAzules() {
        super(nombre, defensa, ataque, estrellas);

    }

    public boolean esFusionDe(List<CartaMonstruo> cartas){
        return true;

    }


}
