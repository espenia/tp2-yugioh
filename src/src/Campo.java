package src;

public class Campo {
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Lado ladoJugadorUno;
    private Lado ladoJugadorDos;
    
    public Campo(Jugador jugador1, Jugador jugador2) {
    	jugadorUno = jugador1;
    	jugadorDos = jugador2;
    	ladoJugadorUno = new Lado();
    	ladoJugadorDos = new Lado();
    }
    public void jugarMonstruoJugadorUno(Monstruo unMonstruo,String modeDeLaCarta,String posicionDeLaCarta){
    	
    }
}
