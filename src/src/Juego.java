package src;

public class Juego {  //Fachada del juego  puede que este de mas
    private Campo campo;

    public Juego (Jugador jugador1, Jugador jugador2){
    	this.campo = new Campo(jugador1, jugador2);
    }

	public void nuevoJuegoSoloMonstruos() {		
	}

    //supongo que se manejara la parte grafica
}
