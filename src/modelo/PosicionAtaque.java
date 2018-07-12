package modelo;

public class PosicionAtaque implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante, CartaMonstruo cartaDefendiente, CartaMonstruo cartaAtacante){

        int resultado = ataqueDelAtacante - ataqueDelDefendiente;
        if (resultado < 0)
            cartaAtacante.estaMuerta();
        else if (resultado == 0){
            cartaAtacante.estaMuerta();
            cartaDefendiente.estaMuerta();
        }
        else cartaDefendiente.estaMuerta();

        return resultado;


    }

    @Override
    public boolean posicionDeDefensa() {
        return false;
    }


}
