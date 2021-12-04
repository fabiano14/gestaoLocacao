package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Endereco;

public class GerenciarEndereco {

    Leitura leitorDados = new Leitura();

    public GerenciarEndereco() {
    }

    public ArrayList<Endereco> cadastrarEnderecos() {
        ArrayList<Endereco> enderecos = new ArrayList<>();

        String numero, rua;
        int op = 0;
        do {
            System.out.println("---- Cadastro de Novo Endereço -----");
            rua = leitorDados.entDados(" Informe a Rua: ");
            numero = leitorDados.entDados(" Informe o Núumero: ");

            Endereco end = new Endereco();
            end.setRua(rua);
            end.setNumero(numero);

            enderecos.add(end);

            op = Integer.parseInt(leitorDados.entDados(" ------- Deseja cadastrar outro endereço? 1.Sim | 2.Não"));

        } while (op == 1);
        
        //colocar mensagem aqui para finalizar o cadastro e exibir numero do codigo
        return enderecos;
    } 
    
    public void imprimeEndereco(ArrayList<Endereco> enderecos) {

        for (Endereco end : enderecos) {
            System.out.println("\nEndereço ------");
            System.out.println("Rua: " + end.getRua());
            System.out.println("Número: " + end.getNumero());
            System.out.println("--------------\n");
        }

    }

}
