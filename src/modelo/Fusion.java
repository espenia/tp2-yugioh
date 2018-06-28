package modelo;

import java.util.Map;

public class Fusion {
	
	boolean habilitado;
	
    public Fusion() {
        this.habilitado = false;
    }
    public void habilitarFusion() {
    	this.habilitado = true;
    }
	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio, Map<String,CartaMonstruo> mazoDeFusiones, Lado lado){
			if(this.habilitado) {
			CartaDeFusion cartaDeFusion = new CartaDeFusion(mazoDeFusiones);
			lado.removerCartaMonstruo(primerSacrificio);
			lado.removerCartaMonstruo(segundoSacrificio);
			lado.removerCartaMonstruo(tercerSacrificio);
			cartaDeFusion.agregarSacrificio(primerSacrificio);
			cartaDeFusion.agregarSacrificio(segundoSacrificio);
			cartaDeFusion.agregarSacrificio(tercerSacrificio);
			CartaMonstruo monstruo = cartaDeFusion.realizarFusion();
			lado.jugarCartaMonstruo(monstruo);
			this.habilitado = false;
			}

	}
}
