package model;

public class Carro extends Veiculo {

    private int qtd_portas;

    public Carro() {

    }

    public Carro(int chassi, String placa, int renavan, String cor, String combustivel, String marca, float valor_locacao, int qtd_portas) {
        super(chassi, placa, renavan, cor, combustivel, marca, valor_locacao);
        this.qtd_portas = qtd_portas;
    }

    public int getQtd_portas() {
        return qtd_portas;
    }

    public void setQtd_portas(int qtd_portas) {
        this.qtd_portas = qtd_portas;
    }

    
}
