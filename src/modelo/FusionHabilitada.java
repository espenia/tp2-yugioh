package modelo;

import java.util.Map;

public class FusionHabilitada extends Fusion {

    public FusionHabilitada() {

    }
    
	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio, Map<String,CartaMonstruo> mazoDeFusiones, Lado lado){

		CartaDeFusion cartaDeFusion = new CartaDeFusion(mazoDeFusiones);
		lado.removerCartaMonstruo(primerSacrificio);
		lado.removerCartaMonstruo(segundoSacrificio);
		lado.removerCartaMonstruo(tercerSacrificio);
		cartaDeFusion.agregarSacrificio(primerSacrificio);
		cartaDeFusion.agregarSacrificio(segundoSacrificio);
		cartaDeFusion.agregarSacrificio(tercerSacrificio);
		CartaMonstruo monstruo = cartaDeFusion.realizarFusion();
		lado.jugarCartaMonstruo(monstruo);

	}
}
