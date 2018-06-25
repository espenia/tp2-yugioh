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
    @Override
    public boolean esFusionDe(List<CartaMonstruo> cartas){
        for (CartaMonstruo i: cartas){
            if (i.getNombre() != "Dragon Blanco De Ojos Azules")
                return false;

        }
        return true;

    }


}
