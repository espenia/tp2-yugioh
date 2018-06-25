package modelo;

public class SinPosicion implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante, CartaMonstruo cartaDefendiente, CartaMonstruo cartaAtacante) throws CartaSinPosicionNoPuedeAtacar {

        throw new CartaSinPosicionNoPuedeAtacar();


    }

    @Override
    public boolean posicionDeDefensa() {
        return false;
    }


}
