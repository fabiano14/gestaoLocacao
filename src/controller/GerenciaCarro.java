package controller;

import java.util.ArrayList;
import model.Carro;

public class GerenciaCarro implements GerenciamentoDados {

    private static ArrayList<Carro> carrosGerenciar;
    Leitura leitorDados = new Leitura();

    public GerenciaCarro(ArrayList<Carro> carrosGerenciar) {
        this.carrosGerenciar = carrosGerenciar;
    }

    @Override
    public void incluir() {
        int chassi, renavan, qtd_portas;
        String placa, cor, combustivel, marca;
        float valor_locacao = 0;

        System.out.println("\n --==[ Cadastro ]==--");

        System.out.println(" \n Informe os dados:");
        chassi = Integer.parseInt(leitorDados.entDados(" Chassi: "));
        renavan = Integer.parseInt(leitorDados.entDados(" Renavan: "));
        placa = leitorDados.entDados("Placa: ");
        cor = leitorDados.entDados("Cor: ");
        valor_locacao = Float.parseFloat(leitorDados.entDados("Valor Locaçãao: "));
        marca = leitorDados.entDados("Marca do Veículo: ");
        combustivel = (leitorDados.entDados("Tipo de Combustível: "));
        qtd_portas = Integer.parseInt(leitorDados.entDados(" Quantidade de portas: "));

        Carro carro = new Carro(chassi, placa, renavan, cor, combustivel, marca, valor_locacao, qtd_portas);

        carrosGerenciar.add(carro);
    }

    @Override
    public void excluir() {
        consultar();
        int chassiBusca = Integer.parseInt(leitorDados.entDados(" Digite o chassi para Exclusão: "));

        boolean encontrado = false;

        for (Carro car : carrosGerenciar) {
            if (car.getChassi() == chassiBusca) {
                carrosGerenciar.remove(car);
                encontrado = true;
                System.out.println(" O veículo de carro foi excluído");
                return;
            }
        }

        System.out.println(" O chassi Digitado não foi encontrado");

    }

    public void consultar() {
        System.out.println("-----Veiculo-----");
        for (Carro car : carrosGerenciar) {
            imprimeCarro(car);

        }
    }

    private void imprimeCarro(Carro car) {
        System.out.println("\n--------------");
        System.out.println("ID: " + carrosGerenciar.indexOf(car));

        int status = car.getStatus_veiculo();

        if (status == 0) {
            System.out.println("Disponível");
        } else if (status == 1) {
            System.out.println("Locado");
        } else {
            System.out.println("Em manutenção");
        }

        System.out.println("Chassi: " + car.getChassi());
        System.out.println("Placa: " + car.getPlaca());
        System.out.println("Renavam: " + car.getRenavam());
        System.out.println("cor: " + car.getCor());
        System.out.println("Combustível: " + car.getCombustivel());
        System.out.println("Marca: " + car.getMarca());
        System.out.println("Valor da Locação " + car.getValor_locacao());
        System.out.println("Quantidade de Portas: " + car.getQtd_portas());

        System.out.println("--------------\n");

    }

    public Carro selecionar() {
        consultar();
        int posicao = Integer.parseInt(leitorDados.entDados(" Digite a posição: "));

        boolean encontrado = false;

        for (Carro c : carrosGerenciar) {
            if (posicao == carrosGerenciar.indexOf(c)) {
                if (c.getStatus_veiculo() != 0) {
                    return null;
                } else {
                    return c;
                }
            }
        }

        System.out.println(" Posição Inválida!");
        return null;
    }

    public void mudarState(Carro car) {

        int op = 0;
        boolean prosseguir = true;
        do {

            op = Integer.parseInt(leitorDados.entDados("Escolha a nova opção de estado do veículo:\n0-Disponveil\n1-Locado\n3-Em Manutenção"));

            if (op == 0) {
                car.setDisponivel();
                System.out.println("Mudança Concretizada");
                prosseguir = false;
            } else if (op == 1) {
                car.setOcupado();
                System.out.println("Mudança Concretizada");
                prosseguir = false;
            } else if (op == 3) {
                car.setEmManutencao();
                System.out.println("Mudança Concretizada");
                prosseguir = false;
            }

        } while (prosseguir);

    }

    public void gerenciar() {

        Carro carro_a_gerenciar = selecionar();

        if (carro_a_gerenciar != null) {
            int op2 = 0;
            do {
                System.out.println("\t --==[  E-CONTRACT - Gerenciar Carro ]==--");
                imprimeSubMenu();
                op2 = Integer.parseInt(leitorDados.entDados("\n Escolha uma das seguintes opções disponíveis"));
                switch (op2) {
                    case 1: {
                        mudarState(carro_a_gerenciar);
                    }
                    break;
                    case 2: {
                        alterar(carro_a_gerenciar);
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

    public void alterar(Carro carro) {

        int op = 0;

        System.out.println("Alterar Chassi: ?(Atual: " + carro.getChassi() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setChassi(Integer.parseInt(leitorDados.entDados(" Chassi:")));
        }

        System.out.println("Alterar Placa: ?(Atual: " + carro.getPlaca() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setPlaca(leitorDados.entDados(" Placa:"));
        }

        System.out.println("Alterar Renavam: ?(Atual: " + carro.getRenavam() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setRenavam(Integer.parseInt(leitorDados.entDados(" Renavam:")));
        }

        System.out.println("Alterar Combustivel: ?(Atual: " + carro.getCombustivel() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setCombustivel(leitorDados.entDados(" Combustível:"));
        }

        System.out.println("Alterar Cor: ?(Atual: " + carro.getCor() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setCor(leitorDados.entDados(" Cor:"));
        }

        System.out.println("Alterar Marca: ?(Atual: " + carro.getMarca() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setMarca(leitorDados.entDados(" Marca:"));
        }

        System.out.println("Alterar Valor Locação: ?(Atual: " + carro.getValor_locacao() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setValor_locacao(Float.parseFloat(leitorDados.entDados(" Valor Locação:")));
        }

        System.out.println("Alterar Quantidade de Eixos: ?(Atual: " + carro.getQtd_portas() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            carro.setQtd_portas(Integer.parseInt(leitorDados.entDados(" Quantidade de Portas:")));
        }

    }

    public static void imprimeSubMenu() {
        System.out.println("\t+===================================+");
        System.out.println("\t| 1 ---------------- Mudar Estado   |");
        System.out.println("\t| 2 ---------------- Alterar        |");
        System.out.println("\t| 0 ---------------- Retornar       |");
        System.out.println("\t+===================================+");
        System.out.print("\t Opção: ");

    }
}
