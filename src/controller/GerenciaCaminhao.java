package controller;

import java.util.ArrayList;
import model.Caminhao;

public class GerenciaCaminhao implements GerenciamentoDados {

    private static ArrayList<Caminhao> caminhoesGerenciar;
    Leitura leitorDados = new Leitura();

    public GerenciaCaminhao(ArrayList<Caminhao> caminhoesGerenciar) {
        this.caminhoesGerenciar = caminhoesGerenciar;
    }

    @Override
    public void incluir() {
        int chassi, renavan, qtd_eixo;
        String placa, cor, combustivel, marca;
        float valor_locacao = 0;

        System.out.println("\n --==[ Cadastro ]==--");

        System.out.println(" \n Informe os dados:");
        chassi = Integer.parseInt(leitorDados.entDados(" Chassi: "));
        renavan = Integer.parseInt(leitorDados.entDados(" Renavan: "));
        placa = leitorDados.entDados("Placa: ");
        cor = leitorDados.entDados("cor: ");
        marca = leitorDados.entDados("Marca: ");
        valor_locacao = Float.parseFloat(leitorDados.entDados("Valor Locacao: "));
        combustivel = (leitorDados.entDados("Tipo de Combustivel: "));
        qtd_eixo = Integer.parseInt(leitorDados.entDados(" Quantidade de Eixos: "));

        Caminhao caminhao = new Caminhao(chassi, placa, renavan, cor, combustivel, marca, valor_locacao, qtd_eixo);

        caminhoesGerenciar.add(caminhao);
    }

    @Override
    public void excluir() {
        consultar();
        int chassiBusca = Integer.parseInt(leitorDados.entDados(" Digite o chassi para exclusão: "));

        boolean encontrado = false;

        for (Caminhao cam : caminhoesGerenciar) {
            if (cam.getChassi() == chassiBusca) {
                caminhoesGerenciar.remove(cam);
                encontrado = true;
                System.out.println(" O veiculo caminhao foi excluído");
                return;
            }
        }

        System.out.println(" o chassi Digitado não foi encontrado");

    }

    public void consultar() {
        System.out.println("-----veiculo caminhao cadastrado");
        for (Caminhao cam : caminhoesGerenciar) {
            imprimeCaminhao(cam);

        }
    }

    private void imprimeCaminhao(Caminhao cam) {//int chassi, String placa, int renavam, String cor, String combustivel, String marca, float valor_locacao
        System.out.println("\n--------------");
        System.out.println("ID: " + caminhoesGerenciar.indexOf(cam));

        int status = cam.getStatus_veiculo();

        if (status == 0) {
            System.out.println("Disponível");
        } else if (status == 1) {
            System.out.println("Locado");
        } else if (status == 2) {
            System.out.println("Em manutenção");
        }

        System.out.println("Chassi: " + cam.getChassi());
        System.out.println("Placa: " + cam.getPlaca());
        System.out.println("Renavam: " + cam.getRenavam());
        System.out.println("cor: " + cam.getCor());
        System.out.println("combustivel: " + cam.getCombustivel());
        System.out.println("marca: " + cam.getMarca());
        System.out.println("valor da locacao: " + cam.getValor_locacao());

        System.out.println("--------------\n");

    }

    public Caminhao selecionar() {
        consultar();
        int posicao = Integer.parseInt(leitorDados.entDados(" Digite a posição: "));

        boolean encontrado = false;

        for (Caminhao c : caminhoesGerenciar) {
            if (posicao == caminhoesGerenciar.indexOf(c)) {
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

    public void mudarState(Caminhao cam) {

        boolean prosseguir = true;
        int op = 0;
        do {

            op = Integer.parseInt(leitorDados.entDados("Escolha a nova opção de estado do veículo:\n0-Disponveil\n1-Locado\n2-Em Manutenção"));

            if (op == 0) {
                cam.setDisponivel();
                prosseguir = false;
                System.out.println("Mudança Concretizada");
            } else if (op == 1) {
                cam.setOcupado();
                prosseguir = false;
                System.out.println("Mudança Concretizada");
            } else if (op == 2) {
                cam.setEmManutencao();
                prosseguir = false;
                System.out.println("Mudança Concretizada");
            }

        } while (prosseguir);

    }

    public void gerenciar() {

        Caminhao caminhao_a_gerenciar = selecionar();

        if (caminhao_a_gerenciar != null) {
            int op2 = 0;
            do {
                System.out.println("\t --==[  E-CONTRACT - Gerenciar Caminhão ]==--");
                imprimeSubMenu();
                op2 = Integer.parseInt(leitorDados.entDados("\n Escolha uma das seguintes opções disponíveis"));
                switch (op2) {
                    case 1: {
                        mudarState(caminhao_a_gerenciar);
                    }
                    break;
                    case 2: {
                        alterar(caminhao_a_gerenciar);
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

    public void alterar(Caminhao caminhao) {

        int op = 0;

        System.out.println("Alterar Chassi: ?(Atual: " + caminhao.getChassi() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setChassi(Integer.parseInt(leitorDados.entDados(" Chassi:")));
        }

        System.out.println("Alterar Placa: ?(Atual: " + caminhao.getPlaca() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setPlaca(leitorDados.entDados(" Placa:"));
        }

        System.out.println("Alterar Renavam: ?(Atual: " + caminhao.getRenavam() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setRenavam(Integer.parseInt(leitorDados.entDados(" Renavam:")));
        }

        System.out.println("Alterar Marca: ?(Atual: " + caminhao.getMarca() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setMarca(leitorDados.entDados(" Marca:"));
        }

        System.out.println("Alterar Combustivel: ?(Atual: " + caminhao.getCombustivel() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setCombustivel(leitorDados.entDados(" Combustível:"));
        }

        System.out.println("Alterar Cor: ?(Atual: " + caminhao.getCor() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setCor(leitorDados.entDados(" Cor:"));
        }

        System.out.println("Alterar Valor Locação: ?(Atual: " + caminhao.getValor_locacao() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setValor_locacao(Float.parseFloat(leitorDados.entDados(" Valor Locação:")));
        }

        System.out.println("Alterar Quantidade de Eixos: ?(Atual: " + caminhao.getQtd_eixo() + ")");
        op = Integer.parseInt(leitorDados.entDados("1.Sim | 2.Não"));
        if (op == 1) {
            caminhao.setQtd_eixo(Integer.parseInt(leitorDados.entDados(" Quantida de Eixos:")));
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
