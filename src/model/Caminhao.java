package model;

import controller.State;
import java.util.ArrayList;

public class Caminhao extends Veiculo{

   //float valor_locacao
    

    private int qtd_eixo;
    private int state = 0;
    public Caminhao(){
        
    }

    public Caminhao(int chassi, String placa, int renavan,String cor, String combustivel, String marca,float valor_locacao,int qtd_eixo) {
        super(chassi,placa, renavan,cor,  combustivel, marca, valor_locacao);     
        this.qtd_eixo = qtd_eixo;
    }
    //
    
    
    //
    public int getQtd_eixo() {
        return qtd_eixo;
    }

    public void setQtd_eixo(int qtd_eixo) {
        this.qtd_eixo = qtd_eixo;
    }


}
