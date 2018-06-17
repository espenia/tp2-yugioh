package modelo;

public class PosicionDefensa implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante){

        return ataqueDelAtacante - defensaDelDefendiente;

    }

    @Override
    public boolean estaDefendiendo(){
        return true;
    }

    @Override
    public boolean estaAtacando(){
        return false;
    }



}
