package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GerenciaCaminhao;
import controller.GerenciaCarro;
import controller.GerenciaCliente;
import controller.GerenciaFuncionario;
import controller.GerenciaLocacao;
import controller.GerenciaMoto;

import model.Caminhao;
import model.Carro;
import model.Moto;
import model.Cliente;
import model.Endereco;
import model.Funcionario;
import model.Locacao;

public class Main {

    private static Scanner sc;

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Caminhao> caminhoes = new ArrayList<>();
    private static ArrayList<Carro> carros = new ArrayList<>();
    private static ArrayList<Moto> motos = new ArrayList<>();
    private static ArrayList<Moto> locacao = new ArrayList<>();
    private static ArrayList<Locacao> locacoes = new ArrayList<>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        int op = 0, op2;

        GerenciaCliente gClientes = new GerenciaCliente(clientes);
        GerenciaCaminhao gCaminhoes = new GerenciaCaminhao(caminhoes);
        GerenciaCarro gCarros = new GerenciaCarro(carros);
        GerenciaMoto gMotos = new GerenciaMoto(motos);
        GerenciaFuncionario gFuncionarios = new GerenciaFuncionario(funcionarios);

        GerenciaLocacao gLocacoes = new GerenciaLocacao(locacoes, gMotos, gCarros, gCaminhoes, gClientes, gFuncionarios);

        preencharDados();

        do {
            System.out.println("\n\t --==[ E-CONTRACT - Gestão de Locação ]==--");
            System.out.println("\t+=================================================+");
            System.out.println("\t| 1 ---------------- Gerenciar Clientes           |");
            System.out.println("\t| 2 ---------------- Gerenciar Carros             |");
            System.out.println("\t| 3 ---------------- Gerenciar Motos              |");
            System.out.println("\t| 4 ---------------- Gerenciar Caminhões          |");
            System.out.println("\t| 5 ---------------- Gerenciar Funcionários       |");
            System.out.println("\t| 6 ---------------- Gerenciar Locação            |");
            System.out.println("\t| 0 ---------------- SAIR                         |");
            System.out.println("\t+==================================================+");
            System.out.println(" Opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1: {
                    do {
                        System.out.println("\t --==[  E-CONTRACT - Gerenciar Clientes ]==--");
                        imprimeSubMenu();
                        op2 = sc.nextInt();

                        switch (op2) {
                            case 1: {
                                gClientes.incluir();

                            }break;
                            case 2:{
                                gClientes.gerenciar();
                            }
                            break;
                            case 3: {

                                if (!clientes.isEmpty()) {
                                    gClientes.consultar();
                                } else {
                                    System.out.println("\n Não há Clientes Cadastrados");
                                }
                            }
                            break;
                            case 4: {

                                if (!clientes.isEmpty()) {
                                    gClientes.excluir();
                                } else {
                                    System.out.println("\n Não há Clientes Cadastrados");
                                }
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
                break;
                case 2: {
                    do {
                        System.out.println("\t --==[  E-CONTRACT - Gerenciar Carros ]==--");
                        imprimeSubMenu();
                        op2 = sc.nextInt();

                        switch (op2) {
                            case 1: {
                                gCarros.incluir();

                            }
                            break;
                            case 2:{
                                gCarros.gerenciar();
                            }break;
                            case 3: {

                                if (!carros.isEmpty()) {
                                    gCarros.consultar();
                                } else {
                                    System.out.println("\n Não há Carros Cadastrados");
                                }
                            }
                            break;
                            case 4: {

                                if (!carros.isEmpty()) {
                                    gCarros.excluir();
                                } else {
                                    System.out.println("\n Não há Carros Cadastrados");
                                }
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
                break;
                case 3: {
                    do {
                        System.out.println("\t --==[  E-CONTRACT - Gerenciar Motos ]==--");
                        imprimeSubMenu();
                        op2 = sc.nextInt();

                        switch (op2) {
                            case 1: {
                                gMotos.incluir();

                            }
                            break;
                            case 2:{
                                gMotos.gerenciar();
                            }break;
                            case 3: {

                                if (!motos.isEmpty()) {
                                    gMotos.consultar();
                                } else {
                                    System.out.println("\n Não há Motos Cadastradas");
                                }
                            }
                            break;
                            case 4: {

                                if (!motos.isEmpty()) {
                                    gMotos.excluir();
                                } else {
                                    System.out.println("\n Não há Motos Cadastradas");
                                }
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
                break;
                case 4: {
                    do {
                        System.out.println("\t --==[  E-CONTRACT - Gerenciar Caminhões ]==--");
                        imprimeSubMenu();
                        op2 = sc.nextInt();

                        switch (op2) {
                            case 1: {
                                gCaminhoes.incluir();

                            }
                            break;
                            case 2:{
                                gCaminhoes.gerenciar();
                            }
                            case 3: {

                                if (!caminhoes.isEmpty()) {
                                    gCaminhoes.consultar();
                                } else {
                                    System.out.println("\n Não há Caminhões Cadastrados");
                                }
                            }
                            break;
                            case 4: {

                                if (!caminhoes.isEmpty()) {
                                    gCaminhoes.excluir();
                                } else {
                                    System.out.println("\n Não há Caminhões Cadastrados");
                                }
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
                break;
                case 5: {
                    do {
                        System.out.println("\t --==[  E-CONTRACT - Gerenciar Funcionários ]==--");
                        imprimeSubMenu();
                        op2 = sc.nextInt();

                        switch (op2) {
                            case 1: {
                                gFuncionarios.incluir();

                            }
                            break;
                            case 2:{
                                gFuncionarios.gerenciar();
                            }break;
                            case 3: {

                                if (!funcionarios.isEmpty()) {
                                    gFuncionarios.consultar();
                                } else {
                                    System.out.println("\n Não há Funcionários Cadastrados");
                                }
                            }
                            break;
                            case 4: {

                                if (!funcionarios.isEmpty()) {
                                    gFuncionarios.excluir();
                                } else {
                                    System.out.println("\n Não há Funcionários Cadastrados");
                                }
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
                break;
                case 6: {
                    do {
                        System.out.println("\t --==[  E-CONTRACT - Gerenciar Locações ]==--");
                        imprimeSubMenu();
                        op2 = sc.nextInt();

                       switch (op2) {
                            case 1: {
                                gLocacoes.incluir();

                            }
                            break;
                            case 2:{
                                gLocacoes.gerenciar();
                            }
                            case 3: {

                                if (!locacoes.isEmpty()) {
                                    gLocacoes.consultar();
                                } else {
                                    System.out.println("\n Não há Locações Cadastrados");
                                }
                            }
                            break;
                            case 4: {

                                if (!locacoes.isEmpty()) {
                                    gLocacoes.excluir();
                                } else {
                                    System.out.println("\n Não há Locações Cadastrados");
                                }
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
                break;
                case 0:
                    System.out.println("\n Até mais!\n");
                    break;
                default:
                    System.out.println("\n Opção inválida!\n Tente novamente.\n");
            }
        } while (op != 0);

    }

    public static void imprimeSubMenu() {
        System.out.println("\n Escolha uma das seguintes opções disponíveis");
        System.out.println("\t+===================================+");
        System.out.println("\t| 1 ---------------- Cadastrar      |");
        System.out.println("\t| 2 ---------------- Alterar        |");
        System.out.println("\t| 3 ---------------- Consultar      |");
        System.out.println("\t| 4 ---------------- Excluir        |");
        System.out.println("\t| 0 ---------------- Retornar       |");
        System.out.println("\t+===================================+");
        System.out.print("\t Opção: ");

    }

    public static void preencharDados() {
        Carro carro1 = new Carro(589, "HHV-78995", 7845, "Branco", "Flex", "Volks", 800, 7);
        Carro carro2 = new Carro(254, "HHV-78995", 7845, "Preto", "Flex", "Toyota", 450, 5);
        Carro carro3 = new Carro(456, "HHV-78995", 7845, "Caramelo", "Flex", "FIAT", 200, 5);
        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);

        Caminhao caminhao1 = new Caminhao(784, "HHV-78995", 7845, "Rosa", "Diesel", "Volks", 1000, 3);
        Caminhao caminhao2 = new Caminhao(659, "HHV-78995", 7845, "Lilas", "Diesel", "MAN", 1500, 2);
        Caminhao caminhao3 = new Caminhao(123, "HHV-78995", 7845, "Marrom", "Diesel", "VOLVO", 200, 4);

        caminhoes.add(caminhao1);
        caminhoes.add(caminhao2);
        caminhoes.add(caminhao3);

        Moto moto1 = new Moto(741, "HHV-4587", 1456654, "Azul", "Flex", "FIAT", 450, 150);
        Moto moto2 = new Moto(1254, "HTV-7877", 414424, "Vermelho", "Flex", "FIAT", 500, 250);
        Moto moto3 = new Moto(56987, "HHo-3495", 74534845, "Preto", "Flex", "FIAT", 700, 300);

        motos.add(moto1);
        motos.add(moto2);
        motos.add(moto3);

        Cliente cliente1 = new Cliente(120, "Aislan", "aislan-c", 9987, 415467);
        Endereco end1 = new Endereco("Rua 1", "0");
        Endereco end2 = new Endereco("Rua 2", "10");
        ArrayList<Endereco> ends1 = new ArrayList<>();
        ends1.add(end1);
        ends1.add(end2);
        cliente1.setEnderecos(ends1);

        Cliente cliente2 = new Cliente(9854, "Fabiano", "fabiano-c", 1447, 998541);
        Endereco end3 = new Endereco("Rua 3", "0");
        Endereco end4 = new Endereco("Rua 4", "10");
        ArrayList<Endereco> ends2 = new ArrayList<>();
        ends2.add(end3);
        ends2.add(end4);
        cliente2.setEnderecos(ends2);

        Cliente cliente3 = new Cliente(120, "Joao de Deus", "oceu", 784541, 65477);
        Endereco end5 = new Endereco("Rua 5", "120");
        Endereco end6 = new Endereco("Rua 6", "105");
        ArrayList<Endereco> ends3 = new ArrayList<>();
        ends3.add(end5);
        ends3.add(end6);
        cliente3.setEnderecos(ends3);

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        Funcionario func1 = new Funcionario(468, "Maria das Amexias", "maria-c", 786, 12345);
        Funcionario func2 = new Funcionario(7895, "Gorgonzola", "gorg-c", 4567, 45626);
        Funcionario func3 = new Funcionario(12344, "Mario de Deus", "mariodceu", 456, 78965);

        funcionarios.add(func1);
        funcionarios.add(func2);
        funcionarios.add(func3);

    }

}
