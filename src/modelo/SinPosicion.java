package modelo;

public class SinPosicion implements PosicionDeCarta {

    @Override
    public int recibirAtaque(int ataqueDelDefendiente,int defensaDelDefendiente, int ataqueDelAtacante){

        return 0;//excepcion carta no posicionada


    }
    @Override
    public boolean estaDefendiendo(){
        return false;//excepcion carta no posicionada
    }

    @Override
    public boolean estaAtacando(){
        return false;//excepcion carta no posicionada
    }



}
