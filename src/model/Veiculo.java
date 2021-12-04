package model;

import controller.State;

public abstract class Veiculo implements State  {

    private int chassi;
    private String placa;
    private int renavam;
    private String cor;
    private String combustivel;
    private String marca;
    private int state = 0;
    private float valor_locacao;
    
    public Veiculo() {

    }

    //lembrar de implementar o state
    public Veiculo(int chassi, String placa, int renavam, String cor, String combustivel, String marca, float valor_locacao) {
        this.chassi = chassi;
        this.placa = placa;
        this.renavam = renavam;
        this.cor = cor;
        this.combustivel = combustivel;
        this.marca = marca;
        this.valor_locacao = valor_locacao;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStatus_veiculo() {
        return this.state;
    }

    public float getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(float valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void setEmManutencao() {
        this.state = 2;
    }

    @Override
    public void setDisponivel() {
        this.state = 0;
    }

    @Override
    public void setOcupado() {
         this.state = 1;
    }
  
}
