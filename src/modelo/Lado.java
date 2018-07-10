package modelo;

import modelo.Cartas.*;
import modelo.Exceptions.HayUnMonstruoEnElCaminoException;
import modelo.Exceptions.LadoNoContieneCartaException;
import modelo.Exceptions.NoHayEspacioEnLadoException;

import java.util.*;

public class Lado {

	private List<CartaMonstruo> cartasMonstruo;
	private List<CartaDeUtilidad> cartasTrampaOMagicas;
	private Mazo mazo;
	private Map<String, CartaMonstruo> mazoDeFusiones;
	private CartaDeCampo cartaDeCampo;
	private Fusion fusion;

	public Lado(Mazo unMazo){

		this.cartasMonstruo = new ArrayList<>();
		this.cartasTrampaOMagicas = new ArrayList<>();
		this.mazo = unMazo;
		this.cartaDeCampo = new SinCartaDeCampo();
		this.fusion = new Fusion();
		this.mazoDeFusiones = new HashMap<>();
		mazoDeFusiones.put("Dragon Blanco Definitivo De Ojos Azules",new DragonBlancoDefinitivoDeOjosAzules());//medio harcodeado
	}
	
	//SETTERS UNITARIOS//
	public void darMazo(Mazo unMazo) {
		this.mazo = unMazo;
	}

	public void darMazoDeFusiones(Map<String,CartaMonstruo> mazo) {
		this.mazoDeFusiones = mazo;
	}

	//JUEGA UNA CARTA DE LA MANO AL CAMPO DE BATALLA//
	public void jugarCartaMonstruo(CartaMonstruo carta) {
		this.cartaDeCampo.aplicarBuff(carta,this);
		this.cartasMonstruo.add(carta);
	}
	
	public void jugarCartaDeCampo(CartaDeCampo carta){
		this.cartaDeCampo = carta;
		this.cartaDeCampo.asignarLado(this);
		for(CartaMonstruo i : this.cartasMonstruo )
			this.cartaDeCampo.aplicarBuff(i,this);
	}
	
	public void jugarCartaTrampa(CartaDeUtilidad carta,Lado esteLado,Lado ladoEnemigo){
		carta.activarTrampa(esteLado,ladoEnemigo);
		this.cartasTrampaOMagicas.add(carta);
	}

	public void jugarCartaMagica(CartaDeUtilidad carta) {
		this.cartasTrampaOMagicas.add(carta);
	}

	//SACA UNA CARTA DEL MAZO A LA MANO//
	public Carta extraerDelMazo(){
		return this.mazo.extraerCarta();
	}
	
	//EXCEPCIONES//
	public void verificarSiHayCartasMonstruos() throws HayUnMonstruoEnElCaminoException {
		if (!this.cartasMonstruo.isEmpty())
			throw new HayUnMonstruoEnElCaminoException();
	}

	public void verificarEspacioDeCartasMonstruos() throws NoHayEspacioEnLadoException {
		if (this.cartasMonstruo.size() == 5)
			throw new NoHayEspacioEnLadoException();
	}

	public void verificarEspacioDeCartasDeUtilidad() throws NoHayEspacioEnLadoException {
		if (this.cartasTrampaOMagicas.size() == 5)
			throw new NoHayEspacioEnLadoException();
	}

	public void verificarSiCartaDeUtilidadEstaEnLado(CartaDeUtilidad cartaDeUtilidad)throws LadoNoContieneCartaException {
		if (!this.cartasTrampaOMagicas.contains(cartaDeUtilidad))
			throw new LadoNoContieneCartaException();
	}

	public void verificarSiCartaMonstruoEstaEnLado(CartaMonstruo cartaMonstruo)throws LadoNoContieneCartaException{
		if (!this.cartasMonstruo.contains(cartaMonstruo))
			throw new LadoNoContieneCartaException();
	}
	
	//FUNCIONES VARIAS//
	public void removerBuffs() {
		for (CartaMonstruo i : this.cartasMonstruo)
			this.cartaDeCampo.revertirBuff(i,this);
	}
	
	public void refrescarAtaques() {
		for (CartaMonstruo i : this.cartasMonstruo)
			i.refrescarAtaque();
	}
	
	//GETTER INFORMATIVO//
	public int cantidadDeCartasEnMazo() {
		return this.mazo.cantidadDeCartas();
	}
	
	//DISPATCHES DE FUSION//
	public void fusionDeTresMonstruos(CartaMonstruo primerSacrificio, CartaMonstruo segundoSacrificio, CartaMonstruo tercerSacrificio){
		this.fusion.fusionDeTresMonstruos(primerSacrificio,segundoSacrificio,tercerSacrificio,this.mazoDeFusiones,this);
	}

	public void habilitarFusion(Fusion fusion) {
		this.fusion = fusion;
	}
	
	//ACTIVACION DE TRAMPA PRODUCTO DE UN ATAQUE ENEMIGO//
	public void activarTrampaConAtaque(CartaMonstruo miCarta,Jugador jugador) {
		for (CartaDeUtilidad i: this.cartasTrampaOMagicas){
			if (i instanceof CartaTrampa)
				i.activarTrampaDeAtaque(jugador, miCarta);
		}
	}

    //DISPATCHES DE PARAMETROS PARA LA ACTIVACION DE UN EFECTO AL DAR VUELTA UNA CARTA//
	public void activarEfecto(Carta unaCarta, Jugador jugador, Jugador enemigo) {
		jugador.activarEfecto(unaCarta, this.cartasMonstruo, this.mazo, jugador, this.fusion, enemigo);
	}

	public void activarEfecto(Carta unaCarta, List<CartaMonstruo> cartasMonstruoAliadas, Mazo mazo, Jugador jugador, Fusion fusion, Jugador enemigo) {
		jugador.activarEfecto(unaCarta, cartasMonstruoAliadas , this.cartasMonstruo, mazo, jugador, this.fusion, enemigo);
	}
	
	//SIREVEN PARA NO MANTENER CARTAS EN ESTADO MUERTAS Y NO GENEREN PROBLEMAS//
	public void removerCartaMonstruo(CartaMonstruo cartaMonstruo){
		verificarSiCartaMonstruoEstaEnLado(cartaMonstruo);
		this.cartasMonstruo.remove(cartaMonstruo);
	}

	public void removerCartaDeUtilidad(CartaDeUtilidad cartaDeUtilidad){
		verificarSiCartaDeUtilidadEstaEnLado(cartaDeUtilidad);
		this.cartasTrampaOMagicas.remove(cartaDeUtilidad);
	}

    public Map getMazoDeFusion() {
        return mazoDeFusiones;
    }

	public Mazo getMazo() {
		return mazo;
	}

    public List<CartaMonstruo> getCartasMosntruos() {
        return cartasMonstruo;
    }

    public List<CartaDeUtilidad> getCartasDeUtilidad() {
        return cartasTrampaOMagicas;
    }

	public CartaDeCampo getCartaDeCampo() {
		return cartaDeCampo;
	}
}