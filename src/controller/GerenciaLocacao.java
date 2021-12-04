package controller;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import model.Caminhao;
import model.Carro;

import model.Locacao;
import model.Cliente;
import model.Funcionario;
import model.Moto;
import model.Nota;
//import model.Veiculo
//import model.Nota
import model.Veiculo;
//import controller.GerenciaFuncionario;

/**
 *
 * @author FABIANO
 */
public class GerenciaLocacao implements GerenciamentoDados, TipoPagamento {

    private ArrayList<Locacao> locacoesGerenciar;
    private Leitura leitorDados = new Leitura();
    private GerenciaCliente gClientes;
    private GerenciaFuncionario gFuncionarios;
    private GerenciaCaminhao gCaminhoes;
    private GerenciaCarro gCarros;
    private GerenciaMoto gMotos;

    public GerenciaLocacao(ArrayList<Locacao> locacoesGerenciar, GerenciaMoto gMotos, GerenciaCarro gCarros, GerenciaCaminhao gCaminhoes, GerenciaCliente gClientes, GerenciaFuncionario gFuncionarios) {
        this.locacoesGerenciar = locacoesGerenciar;
        this.gClientes = gClientes;
        this.gMotos = gMotos;
        this.gCarros = gCarros;
        this.gCaminhoes = gCaminhoes;
        this.gFuncionarios = gFuncionarios;
    }

    public void incluir() {

        LocalDate dt_locacao = null;
        LocalTime hora_locacao = null;
        boolean status_locacao;
        float valor_calcao, valor_locacao;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("\n --==[ Cadastro ]==--");
        dt_locacao = (LocalDate.now());
        hora_locacao = (LocalTime.now());

        Cliente cliente = null;
        do {
            cliente = gClientes.selecionarCliente();
        } while (cliente == null);

        Funcionario funcionario = null;
        do {
            funcionario = gFuncionarios.selecionarFuncionario();
        } while (funcionario == null);

        Veiculo veiculo = null;
        int escolha = 0;
        do {
            escolha = Integer.parseInt(leitorDados.entDados("\nEscolha a opção referente a veiculo: \n1 - Carro\n2 - Moto \n3- Caminhão"));

            veiculo = selecionarVeiculo(escolha, veiculo);

        } while (veiculo == null);

        valor_calcao = Float.parseFloat(leitorDados.entDados(" Valor Calsão: "));
        
        LocalDate dt_prevista_devolucao = LocalDate.parse(leitorDados.entDados(" Data do Prevista Devolução: Ex: 19/06/2021"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime hora_prevista_devolucao = LocalTime.parse(leitorDados.entDados(" Hora da Prevista Devolução: Ex: 12:30"), DateTimeFormatter.ofPattern("HH:MM"));
        
        Locacao locacao = new Locacao(hora_prevista_devolucao, dt_prevista_devolucao, dt_locacao, hora_locacao, valor_calcao, cliente, funcionario, veiculo, locacoesGerenciar.size() + 1);

        locacoesGerenciar.add(locacao);
        System.out.println("Veiculo locado com sucesso!");
    }

    private Veiculo selecionarVeiculo(int escolha, Veiculo veiculoSelecionado) {
        Veiculo veiculo = veiculoSelecionado;

        if (escolha == 1) {
            veiculo = gCarros.selecionar();
        } else if (escolha == 2) {
            veiculo = gMotos.selecionar();
        } else if (escolha == 3) {
            veiculo = gCaminhoes.selecionar();
        }

        if (veiculo == null) {
            System.out.println(" O Veículo escolhido esta indisponivel, escolha outro");
            return null;
        }

        if (veiculo.getState() == 1) {
            System.out.println("Veiculo ja esta ocupado, selecione outro veiculo!");
            return null;
        } else if (veiculo.getState() == 2) {
            System.out.println("Veiculo esta em manutenção,  selecione outro veiculo!");
            return null;
        }

        veiculo.setOcupado();

        return veiculo;
    }

    public void excluir() {
        consultar();
        int codLocBusca = Integer.parseInt(leitorDados.entDados(" codigo de locação para exclusão: "));

        boolean encontrado = false;

        for (Locacao loc : locacoesGerenciar) {
            if (loc.getCod_Locacao() == codLocBusca) {
                locacoesGerenciar.remove(loc);
                encontrado = true;
                System.out.println(" a locacão foi excluída");
                return;
            }
        }

        System.out.println(" o codio de locacao Digitado não foi encontrado");

    }

    public void consultar() {
        System.out.println("-----Locacao cadastrado");
        for (Locacao loc : locacoesGerenciar) {
            imprimeLocacao(loc);
        }
    }

    public void imprimeLocacao(Locacao loc) {
        System.out.println("\n--------------");
        System.out.println("ID: " + locacoesGerenciar.indexOf(loc));
        System.out.println("Código: " + loc.getCod_Locacao());
        System.out.println("Data Locação: " + loc.getDt_locacao());
        System.out.println("Hora Locação: " + loc.getHora_locacao());
        System.out.println("Status Locaçâo: " + (loc.isStatus_locacao() ? "Em andamento" : "Finalizado"));
        System.out.println("Valor Calsão: " + loc.getValor_calcao());
        System.out.println("Valor da Multa: " + loc.getMulta());
        System.out.println("Data Devolução: " + loc.getDt_devolucao());
        System.out.println("Hora Devolução: " + loc.getHora_locacao());

        System.out.println("Cliente Locatario: " + loc.getCliente().getNome() + " CNH: " + loc.getCliente().getCnh());
        System.out.println("Funcionário Mediador: " + loc.getFuncionario().getNome() + " CNH: " + loc.getFuncionario().getCtps());

        Veiculo v = loc.getVeiculo();

        if (v instanceof Moto) {
            System.out.println("Veiculo: Moto");
            Moto moto = (Moto) v;
            System.out.println("Cilindrada: " + moto.getCilindrada());
            System.out.println("Valor Locação: " + moto.getValor_locacao());
        } else if (v instanceof Carro) {
            System.out.println("Veiculo: Carro");
            Carro carro = (Carro) v;
            System.out.println("Quantidade de Portas: " + carro.getQtd_portas());
            System.out.println("Valor Locação: " + carro.getValor_locacao());
        } else {

            System.out.println("Veiculo: Caminhão");
            Caminhao cam = (Caminhao) v;
            System.out.println("Quantidade de Eixos: " + cam.getQtd_eixo());
            System.out.println("Valor Locação: " + cam.getValor_locacao());
        }

        System.out.println("--------------\n");

    }

    public void setDevolucao(Locacao locacao) {

        LocalDate dt_devolucao = null;
        boolean data_dev = false;
        do {
            try {
                dt_devolucao = LocalDate.parse(leitorDados.entDados(" Data do Devolução: Ex: 19/06/2021"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                data_dev = true;
            } catch (Exception e) {
                System.out.println("Data da Devoulcao Inválida!");
            }

        } while (!data_dev);

        LocalTime hr_devolucao = null;
        boolean hr_dev = false;
        do {
            try {
                hr_devolucao = LocalTime.parse(leitorDados.entDados(" Hora da Devolução: Ex: 12:30"), DateTimeFormatter.ofPattern("HH:MM"));
                hr_dev = true;
            } catch (Exception e) {
                System.out.println("Hora da Devoulcao Inválida!");
            }

        } while (!hr_dev);

        locacao.setDt_devolucao(dt_devolucao);
        locacao.setHora_devolucao(hr_devolucao);
        locacao.setStatus_locacao(true);

        Veiculo v = locacao.getVeiculo();
        v.setDisponivel();
    }

    public void gerenciar() {

        Locacao locacao_a_gerenciar = selecionar();

        if (locacao_a_gerenciar != null) {
            int op2 = 0;
            do {
                System.out.println("\t --==[  E-CONTRACT - Gerenciar Locação ]==--");
                imprimeSubMenu();
                op2 = Integer.parseInt(leitorDados.entDados("\n Escolha uma das seguintes opções disponíveis"));
                switch (op2) {
                    case 1: {
                        if (locacao_a_gerenciar.isStatus_locacao()) {
                            this.pagar(locacao_a_gerenciar);
                        } else {
                            System.err.print("\n\nLocação ainda em andamento!\n\n");
                        }
                    }
                    break;
                    case 2: {
                        this.setDevolucao(locacao_a_gerenciar);
                    }
                    break;
                    case 3: {

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

    public Locacao selecionar() {
        consultar();
        int posicao = Integer.parseInt(leitorDados.entDados(" Digite a posição: "));

        boolean encontrado = false;

        for (Locacao loc : locacoesGerenciar) {
            if (posicao == locacoesGerenciar.indexOf(loc)) {
                return loc;
            }
        }

        System.out.println(" Posição Inválida!");
        return null;
    }

    @Override
    public void pagar(Locacao locacao) {

        double valor_a_pagar = 0.0;
        LocalDate dt_pagamento = null;

        LocalDateTime data_e_hora_locacao = locacao.getDt_locacao().atTime(locacao.getHora_locacao());
        LocalDateTime data_e_hora_devolucao = locacao.getDt_devolucao().atTime(locacao.getHora_devolucao());
        
       // LocalDate.parse(leitorDados.entDados(" Data do Devolução: Ex: 19/06/2021"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        LocalDateTime data_e_hora_prevista_devolucao = locacao.getDt_prevista_devolucao().atTime(locacao.getHora_prevista_devolucao());

        long dias_locados = ChronoUnit.DAYS.between(data_e_hora_locacao, data_e_hora_devolucao);

        long dias_ultrapassados = ChronoUnit.DAYS.between(data_e_hora_prevista_devolucao, data_e_hora_devolucao);
        
        if(dias_locados == 0){
            dias_locados++;
        }
        
        double valor_base = dias_locados * locacao.getValor_calcao();

        double porcentagem_multa = dias_ultrapassados * 0.15;

        double multa = valor_base * porcentagem_multa;

        int tipo_pagamento = 0;
        boolean prosseguir = true;
        boolean data_pagamento = false;
        do {

            do {
                try {
                    dt_pagamento = LocalDate.parse(leitorDados.entDados("Data do Pagamento: Ex: 19/06/2021"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    data_pagamento = true;
                } catch (Exception e) {
                    System.out.println("Data de Pagamento Inválida!");
                }

            } while (!data_pagamento);

            System.out.println(" O valor pago atual é: " + locacao.getValor_pago());
            tipo_pagamento = Integer.parseInt(leitorDados.entDados("Escolha o tipo de pagamento: \n1-Crédito(+3%) \n2-Débito(-5%) \n3-Á Vista(-10%"));

            if (tipo_pagamento == 1) {

                valor_a_pagar = valor_base + (valor_base * 0.03) + multa;
                prosseguir = false;
            } else if (tipo_pagamento == 2) {
                valor_a_pagar = valor_base - (valor_base * 0.05) + multa;
                prosseguir = false;
            } else if (tipo_pagamento == 3) {
                valor_a_pagar = valor_base - (valor_base * 0.10) + multa;
                prosseguir = false;
            } else {
                System.out.println("\nOpção Selecionada Inválida!");
            }

            System.out.println("O Caixa deve receber o Valor de R$ " + valor_a_pagar + " Referencetes há: "
                    + dias_locados + " dias de locação, a R$ " + locacao.getValor_calcao() + " ao dia, multa de  R$ " + multa + " por mais "+ dias_ultrapassados + "dias ultrapassados");

            locacao.setDt_pagamento(dt_pagamento);
            locacao.setTipo_pagamento(tipo_pagamento);
            locacao.setPago(true);

            Nota nota_fiscal = new Nota();
            nota_fiscal.setValor_nota(valor_a_pagar);

            locacao.setNota_fiscal(nota_fiscal);

            nota_fiscal.regNota();
            System.out.println("Pagamento Finalizado");

        } while (prosseguir);

    }

    public static void imprimeSubMenu() {
        System.out.println("\t+===================================+");
        System.out.println("\t| 1 ---------------- Pagar          |");
        System.out.println("\t| 2 ---------------- Devolver       |");
        System.out.println("\t| 3 ---------------- Alterar        |");
        System.out.println("\t| 0 ---------------- Retornar       |");
        System.out.println("\t+===================================+");
        System.out.print("\t Opção: ");

    }

}
