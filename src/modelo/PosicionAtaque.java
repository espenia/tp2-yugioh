package modelo;

public class PosicionAtaque implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante){

        return ataqueDelAtacante - ataqueDelDefendiente;


    }
    @Override
    public boolean estaDefendiendo(){
        return false;
    }

    @Override
    public boolean estaAtacando(){
        return true;
    }



}
