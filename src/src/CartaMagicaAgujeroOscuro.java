package src;

public class CartaMagicaAgujeroOscuro extends CartaMagica{

	public CartaMagicaAgujeroOscuro(String nombreDeCarta) {
		super(nombreDeCarta);
	}

	@Override
	public void activarEfecto(Jugador jugador) {
		Lado lado = jugador.getLado();
		Lado ladoEnemigo = jugador.getLadoEnemigo(); 
		lado.mandarCastasMonstruosAlCementerio();
		ladoEnemigo.mandarCastasMonstruosAlCementerio();
	}

	@Override
	public void jugar(Lado lado, String posicionDeLaCarta, String modoDeLaCarta) {
		lado.jugarCartaMagica(this, posicionDeLaCarta);
	}

}
