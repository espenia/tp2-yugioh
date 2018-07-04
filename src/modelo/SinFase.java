package modelo;

public class SinFase implements Fase {


    @Override
    public Fase cambiarFase() throws NoHayMasFasesException {
        return null;
    }

    @Override
    public void jugarCartaMonstruo() throws AccionInvalidaEnFaseException {

    }

    @Override
    public void jugarCartaDeUtilidad() throws AccionInvalidaEnFaseException {

    }

    @Override
    public void jugarCartaDeCampo() throws AccionInvalidaEnFaseException {

    }

    @Override
    public void atacar() throws AccionInvalidaEnFaseException {

    }

    @Override
    public void activarCartaMagica() throws AccionInvalidaEnFaseException {

    }
}
