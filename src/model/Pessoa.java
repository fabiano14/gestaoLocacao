
package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	
    
	private int cpf;
	private String nome;
	private String email;
	private int fone;
	private  ArrayList<Endereco>  enderecos;
       
         public Pessoa(){
           
        }
     
	
        public Pessoa(int cpf, String nome, String email, int fone){
            this.cpf = cpf;
            this.nome = nome;
            this.email = email;
            this.fone = fone;
        }
        
         public Pessoa(int cpf, String nome, String email, int fone, ArrayList<Endereco> enderecos){
            this.cpf = cpf;
            this.nome = nome;
            this.email = email;
            this.fone = fone;
            this.enderecos = enderecos;
        }
        
        
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFone() {
		return fone;
	}
	public void setFone(int fone) {
		this.fone = fone;
	}

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
        
        

}
