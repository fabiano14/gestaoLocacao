/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Endereco;
import model.Funcionario;

/**
 *
 * @author FABIANO
 */
public class GerenciaFuncionario implements GerenciamentoDados {

    ArrayList<Funcionario> funcionariosGerenciar;
    Leitura leitorDados = new Leitura();

    public GerenciaFuncionario(ArrayList<Funcionario> funcionariosGerenciar) {
        this.funcionariosGerenciar = funcionariosGerenciar;
    }

    /* public GerenciaFuncionario(ArrayList<Cliente> clientes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public void incluir() {
        ArrayList<Endereco> enderecos;

        String nome, email;
        int cpf, fone, ctps;

        System.out.println("\n --==[ Cadastro ]==--");

        System.out.println(" \n Informe os dados:");
        nome = leitorDados.entDados(" Nome: ");
        cpf = Integer.parseInt(leitorDados.entDados(" Cpf: "));
        ctps = Integer.parseInt(leitorDados.entDados(" CNH do Motorista: "));
        email = leitorDados.entDados(" Email: ");
        fone = Integer.parseInt(leitorDados.entDados(" Fone: "));

        GerenciarEndereco gEnderecos = new GerenciarEndereco();
        ArrayList<Endereco> ends = gEnderecos.cadastrarEnderecos();

        Funcionario funcionario = new Funcionario(cpf, nome, email, fone, ends,ctps);

        funcionariosGerenciar.add(funcionario);

    }

    public void excluir() {
        consultar();
        int ctpsBusca = Integer.parseInt(leitorDados.entDados(" Digite o cpf para exclusão: "));

        boolean encontrado = false;

        for (Funcionario f : funcionariosGerenciar) {
            if (f.getCtps() == ctpsBusca) {
                funcionariosGerenciar.remove(f);
                encontrado = true;
                System.out.println(" O cliente foi excluído");
                return;
            }
        }

        System.out.println(" Ctps Digitado não foi encontrado");//numero de inscrição de carteira de trabalho

    }

    public void consultar() {
        System.out.println("-----Funcionários Cadastrados");
        for (Funcionario f : funcionariosGerenciar) {
            imprimeCliente(f);
        }
    }

    public void imprimeCliente(Funcionario f) {
        System.out.println("\n--------------");
        System.out.println("ID: " + funcionariosGerenciar.indexOf(f));
        System.out.println("Nome: " + f.getNome());
        System.out.println("Cpf: " + f.getCpf());
        System.out.println("CNH do Motorista: " + f.getCtps());
        System.out.println("Email: " + f.getEmail());
        System.out.println("Fone: " + f.getFone());

        System.out.println("--------------\n");

    }

    public Funcionario selecionarFuncionario() {
        consultar();
        int posicao = Integer.parseInt(leitorDados.entDados(" Digite a posição do funcionário: "));

        boolean encontrado = false;

        for (Funcionario f : funcionariosGerenciar) {
            if (posicao == funcionariosGerenciar.indexOf(f)) {

                return f;
            }
        }

        System.out.println(" Posição Inválida!");
        return null;
    }
    
    
       public void gerenciar() {

       Funcionario  funcionario_a_gerenciar = selecionarFuncionario();

        if (funcionario_a_gerenciar != null) {
            int op2 = 0;
            do {
                System.out.println("\t --==[  E-CONTRACT - Gerenciar Funcionário ]==--");
                imprimeSubMenu();
                op2 = Integer.parseInt(leitorDados.entDados("\n Escolha uma das seguintes opções disponíveis"));
                switch (op2) {
                    case 1: {
                        alterar(funcionario_a_gerenciar);
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
       
     public void alterar(Funcionario funcionario) {

        int op = 0;

        System.out.println("Alterar Nome: ?(Atual: " + funcionario.getNome() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            funcionario.setNome(leitorDados.entDados(" Nome:"));
        }

        System.out.println("Alterar CPF: ?(Atual: " + funcionario.getCpf() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            funcionario.setCpf(Integer.parseInt(leitorDados.entDados(" CPF:")));
        }

        System.out.println("Alterar E-Mail: ?(Atual: " + funcionario.getEmail() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            funcionario.setEmail(leitorDados.entDados(" Email:"));
        }

        System.out.println("Alterar Fone: ?(Atual: " + funcionario.getFone() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            funcionario.setFone(Integer.parseInt(leitorDados.entDados(" Fone:")));
        }

        System.out.println("Alterar CTPS: ?(Atual: " + funcionario.getCtps() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            funcionario.setCtps(Integer.parseInt(leitorDados.entDados(" CTPS:")));
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
