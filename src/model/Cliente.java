package model;

import java.util.ArrayList;

public final class Cliente extends Pessoa {

    private int cnh;

    public Cliente(int cpf, String nome, String email, int fone, int cnh) {
        super(cpf, nome, email, fone);
        this.cnh = cnh;
    }

    public Cliente(int cpf, String nome, String email, int fone, ArrayList<Endereco> enderecos, int cnh) {
        super(cpf, nome, email, fone, enderecos);
        this.cnh = cnh;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

}
