package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CartaDeFusion {


    private Mazo mazoDeFusiones;
    private List<CartaMonstruo> sacrificios;

    public CartaDeFusion(Mazo mazo){
        mazoDeFusiones = mazo;
        sacrificios = new ArrayList<>();
    }

    public void agregarSacrificio(CartaMonstruo sacrificio) {
        sacrificios.add(sacrificio);

    }

    public void realizarFusion() {
        Stack<Carta> cartaMonstruos =mazoDeFusiones.extraer(mazoDeFusiones.cantidadDeCartas());
        int i = cartaMonstruos.size();
        for (int j = 0; j < i ; j++){
            CartaMonstruo carta = (CartaMonstruo)cartaMonstruos.pop();
            for (int k = 0; k < sacrificios.size(); k++){
                //recorre k y verifica si cumple la condicion de fusion de j

            }

        }

    }
}
