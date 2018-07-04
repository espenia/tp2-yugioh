package modelo;

public interface Fase {

    public Fase cambiarFase() throws NoHayMasFasesException;

    public void jugarCartaMonstruo() throws AccionInvalidaEnFaseException;

    public void jugarCartaDeUtilidad() throws AccionInvalidaEnFaseException;

    public void jugarCartaDeCampo() throws AccionInvalidaEnFaseException;

    public void atacar() throws AccionInvalidaEnFaseException;

    public void activarCartaMagica() throws AccionInvalidaEnFaseException;





}
