package modelo;

public class PosicionDefensa implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante, CartaMonstruo cartaDefendiente, CartaMonstruo cartaAtacante){

        int resultado = ataqueDelAtacante - defensaDelDefendiente;
        if (resultado > 0)
            cartaDefendiente.estaMuerta();

        return resultado;

    }

    @Override
    public boolean posicionDeDefensa() {
        return true;
    }


}
