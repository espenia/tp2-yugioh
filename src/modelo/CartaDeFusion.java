package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CartaDeFusion {


    private Map<String,CartaMonstruo> mazoDeFusiones;
    private List<CartaMonstruo> sacrificios;

    public CartaDeFusion(Map<String,CartaMonstruo> mazo){
        mazoDeFusiones = mazo;
        sacrificios = new ArrayList<>();
    }

    public void agregarSacrificio(CartaMonstruo sacrificio) {
        sacrificios.add(sacrificio);

    }

    public CartaMonstruo realizarFusion()  throws NoAdmiteFusion {

        for (Map.Entry<String, CartaMonstruo> entry : mazoDeFusiones.entrySet()){
            if (entry.getValue().esFusionDe(sacrificios))
                return entry.getValue();

        }

        throw new NoAdmiteFusion();

    }
}
