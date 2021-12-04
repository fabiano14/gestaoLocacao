
package model;

import java.util.ArrayList;


public final class Funcionario extends Pessoa{
    
    
      private int ctps;

    public Funcionario(int ctps) {
        this.ctps = ctps;
    }

     
    public Funcionario( int cpf, String nome, String email, int fone,int ctps) {
        super(cpf, nome, email, fone);
        this.ctps = ctps;
    }

    public Funcionario( int cpf, String nome, String email, int fone,  ArrayList<Endereco> enderecos, int ctps) {
        super(cpf, nome, email, fone, enderecos);
        this.ctps = ctps;
    }

 
    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

   
    
}
