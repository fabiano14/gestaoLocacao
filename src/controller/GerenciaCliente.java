/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Endereco;

/**
 *
 * @author FABIANO
 */
public class GerenciaCliente implements GerenciamentoDados {

    ArrayList<Cliente> clientesGerenciar;
    Leitura leitorDados = new Leitura();

    public GerenciaCliente(ArrayList<Cliente> clientesGerenciar) {
        this.clientesGerenciar = clientesGerenciar;
    }

    public void incluir() {
        ArrayList<Endereco> enderecos;

        String nome;
        String email;
        Integer cpf;
        Integer fone;
        Integer cnh;

        System.out.println("\n --==[ Cadastro ]==--");

        System.out.println(" \n Informe os dados:");
        nome = leitorDados.entDados(" Nome: ");
        cpf = Integer.parseInt(leitorDados.entDados(" Cpf: "));
        cnh = Integer.parseInt(leitorDados.entDados(" CNH do Motorista: "));
        email = leitorDados.entDados(" Email: ");
        fone = Integer.parseInt(leitorDados.entDados(" Fone: "));

        GerenciarEndereco gEnderecos = new GerenciarEndereco();
        ArrayList<Endereco> ends = gEnderecos.cadastrarEnderecos();

        Cliente cliente = new Cliente(cpf, nome, email, fone, ends, cnh);

        clientesGerenciar.add(cliente);

        System.out.println("Cliente " +(clientesGerenciar.size() - 1) + " - "+ cliente.getNome() + " foi cadastrado com sucesso!");
    }

    
    public void excluir() {
        consultar();
        int cpfBusca = Integer.parseInt(leitorDados.entDados(" Digite o cpf para exclusão: "));

        boolean encontrado = false;

        for (Cliente c : clientesGerenciar) {
            if (c.getCpf() == cpfBusca) {
                clientesGerenciar.remove(c);
                encontrado = true;
                System.out.println(" O cliente foi excluído");
                return;
            }
        }

        System.out.println(" Cpf Digitado não foi encontrado");

    }

    public void consultar() {
        System.out.println("-----Clientes Cadastrados");
        for (Cliente c : clientesGerenciar) {
            imprimeCliente(c);
        }
    }

    public void imprimeCliente(Cliente c) {

        System.out.println("\n--------------");
        System.out.println("ID: " + clientesGerenciar.indexOf(c));
        System.out.println("Nome: " + c.getNome());
        System.out.println("Cpf: " + c.getCpf());
        System.out.println("CNH do Motorista: " + c.getCnh());
        System.out.println("Email: " + c.getEmail());
        System.out.println("Fone: " + c.getFone());
        System.out.println("--------------\n");

        GerenciarEndereco gEnderecos = new GerenciarEndereco();
        ArrayList<Endereco> ends = c.getEnderecos();
        gEnderecos.imprimeEndereco(ends);

    }

    public Cliente selecionarCliente() {
        consultar();
        int posicao = Integer.parseInt(leitorDados.entDados(" Digite a posição do Cliente: "));

        boolean encontrado = false;

        for (Cliente c : clientesGerenciar) {
            if (posicao == clientesGerenciar.indexOf(c)) {

                return c;
            }
        }

        System.out.println(" Posição Inválida!");
        return null;
    }

    public void gerenciar() {

        Cliente cliente_a_gerenciar = selecionarCliente();

        if (cliente_a_gerenciar != null) {
            int op2 = 0;
            do {
                System.out.println("\t --==[  E-CONTRACT - Gerenciar Cliente ]==--");
                imprimeSubMenu();
                op2 = Integer.parseInt(leitorDados.entDados("\n Escolha uma das seguintes opções disponíveis"));
                switch (op2) {
                    case 1: {
                        alterar(cliente_a_gerenciar);
                    }
                    break;

                    case 0:
                        System.out.println("\n retornar...\n");
                        break;
                    default:
                        System.out.println("\n Opção inválida!\n Por gentileza, tente novamente!\n");

                }
            } while (op2 != 0);
        }

    }

    public void alterar(Cliente cliente) {

        int op = 0;

        System.out.println("Alterar Nome: ?(Atual: " + cliente.getNome() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            cliente.setNome(leitorDados.entDados(" Nome:"));
        }

        System.out.println("Alterar CPF: ?(Atual: " + cliente.getCpf() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            cliente.setCpf(Integer.parseInt(leitorDados.entDados(" CPF:")));
        }

        System.out.println("Alterar E-Mail: ?(Atual: " + cliente.getEmail() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            cliente.setEmail(leitorDados.entDados(" Email:"));
        }

        System.out.println("Alterar Fone: ?(Atual: " + cliente.getFone() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            cliente.setFone(Integer.parseInt(leitorDados.entDados(" Fone:")));
        }
        
          System.out.println("Alterar CNH: ?(Atual: " + cliente.getCnh() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            cliente.setCnh(Integer.parseInt(leitorDados.entDados(" CNH:")));
        }


    }

    public static void imprimeSubMenu() {
        System.out.println("\t+===================================+");
        System.out.println("\t| 1 ---------------- Alterar        |");
        System.out.println("\t| 0 ---------------- Retornar       |");
        System.out.println("\t+===================================+");
        System.out.print("\t Opção: ");

    }
}
