package controller;

import java.util.ArrayList;
import model.Moto;

public class GerenciaMoto implements GerenciamentoDados {

    private static ArrayList<Moto> motosGerenciar;
    Leitura leitorDados = new Leitura();

    public GerenciaMoto(ArrayList<Moto> motosGerenciar) {
        this.motosGerenciar = motosGerenciar;
    }

    @Override
    public void incluir() {
        int chassi, renavan, cilindrada;
        String placa, cor, combustivel, marca;
        float valor_locacao = 0;

        System.out.println("\n --==[ Cadastro ]==--");

        System.out.println(" \n Informe os dados:");
        chassi = Integer.parseInt(leitorDados.entDados(" Chassi: "));
        renavan = Integer.parseInt(leitorDados.entDados(" Renavan: "));
        placa = leitorDados.entDados("Placa: ");
        cor = leitorDados.entDados("cor: ");
        marca = leitorDados.entDados("Marca: ");
        valor_locacao = Float.parseFloat(leitorDados.entDados("valor_locacao: "));
        marca = leitorDados.entDados("Marca do veículo: ");
        combustivel = (leitorDados.entDados("Tipo de Combustivel: "));
        cilindrada = Integer.parseInt(leitorDados.entDados(" Quantidade de cilindradas: "));

        Moto moto = new Moto(chassi, placa, renavan, cor, combustivel, marca, valor_locacao, cilindrada);

        motosGerenciar.add(moto);
    }

    @Override
    public void excluir() {
        consultar();
        int chassiBusca = Integer.parseInt(leitorDados.entDados(" Digite o chassi para exclusão: "));

        boolean encontrado = false;

        for (Moto mot : motosGerenciar) {
            if (mot.getChassi() == chassiBusca) {
                motosGerenciar.remove(mot);
                encontrado = true;
                System.out.println(" O veiculo caminhao foi excluído");
                return;
            }
        }

        System.out.println(" o chassi Digitado não foi encontrado");

    }

    public void consultar() {
        System.out.println("-----veiculo caminhao cadastrado");
        for (Moto mot : motosGerenciar) {
            imprimeMoto(mot);

        }
    }

    private void imprimeMoto(Moto mot) {//int chassi, String placa, int renavam, String cor, String combustivel, String marca, float valor_locacao
        System.out.println("\n--------------");
        System.out.println("ID: " + motosGerenciar.indexOf(mot));

        int status = mot.getStatus_veiculo();

        if (status == 0) {
            System.out.println("Disponível");
        } else if (status == 1) {
            System.out.println("Locado");
        } else {
            System.out.println("Em manutenção");
        }

        System.out.println("Chassi: " + mot.getChassi());
        System.out.println("Placa: " + mot.getPlaca());
        System.out.println("Renavam: " + mot.getRenavam());
        System.out.println("cor: " + mot.getCor());
        System.out.println("combustivel: " + mot.getCombustivel());
        System.out.println("marca: " + mot.getMarca());
        System.out.println("valor da locacao: " + mot.getValor_locacao());

        System.out.println("--------------\n");

    }

    public Moto selecionar() {
        consultar();
        int posicao = Integer.parseInt(leitorDados.entDados(" Digite a posição: "));

        boolean encontrado = false;

        for (Moto c : motosGerenciar) {
            if (posicao == motosGerenciar.indexOf(c)) {
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

    public void mudarState(Moto mot) {

        int op = 0;
        boolean prosseguir = true;
        do {

            op = Integer.parseInt(leitorDados.entDados("Escolha a nova opção de estado do veículo:\n0-Disponveil\n1-Locado\n3-Em Manutenção"));

            if (op == 0) {
                mot.setDisponivel();
                System.out.println("Mudança Concretizada");
                prosseguir = false;
            } else if (op == 1) {
                mot.setOcupado();
                System.out.println("Mudança Concretizada");
                prosseguir = false;
            } else if (op == 3) {
                mot.setEmManutencao();
                System.out.println("Mudança Concretizada");
                prosseguir = false;
            }

        } while (prosseguir);

    }

    public void gerenciar() {

        Moto moto_a_gerenciar = selecionar();

        if (moto_a_gerenciar != null) {
            int op2 = 0;
            do {
                System.out.println("\t --==[  E-CONTRACT - Gerenciar Moto ]==--");
                imprimeSubMenu();
                op2 = Integer.parseInt(leitorDados.entDados("\n Escolha uma das seguintes opções disponíveis"));
                switch (op2) {
                    case 1: {
                        mudarState(moto_a_gerenciar);
                    }
                    break;
                    case 2: {
                        alterar(moto_a_gerenciar);
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

    public void alterar(Moto moto) {

        int op = 0;

        System.out.println("Alterar Chassi: ?(Atual: " + moto.getChassi() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setChassi(Integer.parseInt(leitorDados.entDados(" Chassi:")));
        }

        System.out.println("Alterar Placa: ?(Atual: " + moto.getPlaca() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setPlaca(leitorDados.entDados(" Placa:"));
        }

        System.out.println("Alterar Renavam: ?(Atual: " + moto.getRenavam() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setRenavam(Integer.parseInt(leitorDados.entDados(" Renavam:")));
        }

        System.out.println("Alterar Cor: ?(Atual: " + moto.getCor() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setCor(leitorDados.entDados(" Cor:"));
        }

        System.out.println("Alterar Combustivel: ?(Atual: " + moto.getCombustivel() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setCombustivel(leitorDados.entDados(" Combustível:"));
        }

        System.out.println("Alterar Marca: ?(Atual: " + moto.getMarca() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setMarca(leitorDados.entDados(" Marca:"));
        }

        System.out.println("Alterar Valor Locação: ?(Atual: " + moto.getValor_locacao() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setValor_locacao(Float.parseFloat(leitorDados.entDados(" Valor Locação:")));
        }

        System.out.println("Alterar Clilindradas: ?(Atual: " + moto.getCilindrada() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            moto.setChassi(Integer.parseInt(leitorDados.entDados(" Cilindrada:")));
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
