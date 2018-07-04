package modelo;

public class SinPosicion implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante, CartaMonstruo cartaDefendiente, CartaMonstruo cartaAtacante) throws CartaSinPosicionNoPuedeAtacarException {

        throw new CartaSinPosicionNoPuedeAtacarException();


    }

    @Override
    public boolean posicionDeDefensa() {
        return false;
    }


}
