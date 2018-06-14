package src;


public class Campo {
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Lado ladoJugadorUno;
    private Lado ladoJugadorDos;

    public Campo(Jugador elJugadorUno,Jugador elJugadorDos){
        jugadorDos = elJugadorDos;
        jugadorUno = elJugadorUno;
        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();
        ladoJugadorUno = new Lado(mazo1, this, jugadorUno);
        ladoJugadorDos = new Lado(mazo2, this, jugadorDos);
        jugadorUno.asignarLado(ladoJugadorUno);
        jugadorDos.asignarLado(ladoJugadorDos);
    }

    public void notificarMandarCartaMonstruoAlCementerioAlOtroLado(int cantidadDeDaño,CartaMonstruo cartaAfectada, Lado noEsEsteLado){
        if(noEsEsteLado == ladoJugadorDos)
            ladoJugadorUno.notificarConflicto(cantidadDeDaño,cartaAfectada);
        else ladoJugadorDos.notificarConflicto(cantidadDeDaño,cartaAfectada);
    }


}