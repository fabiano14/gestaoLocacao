package model;

public class Moto extends Veiculo {

    private int cilindrada;
    private Double valor_locacao;
    
    public Moto(int chassi, String placa, int renavan, String cor, String combustivel, String marca, float valor_locacao, int cilindrada) {
        super(chassi, placa, renavan, cor, combustivel, marca, valor_locacao);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

}
