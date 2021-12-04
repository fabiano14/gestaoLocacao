package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Locacao {//locação não implementa a interface

    private int cod_Locacao;
    private LocalDate dt_locacao;
    private LocalTime hora_locacao;
    private LocalDate dt_devolucao;
    private LocalTime hora_devolucao;
    private LocalTime hora_prevista_devolucao;    
    private LocalDate dt_prevista_devolucao;
    protected boolean status_locacao = false; // esse nivel de encapsulamento faz com que a penas a propria classe tenha acesso a variável.
    private float valor_calcao;
    private float multa;
    private LocalDate dt_pagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Veiculo veiculo;
    private double valor_pago;
    private Double valor_locacao;
    private int tipo_pagamento;
    private Nota nota_fiscal;

    protected boolean pago = false;

    public Locacao() {
    }

    public Locacao(LocalTime hora_prevista_devolucao, LocalDate dt_prevista_devolucao, LocalDate dt_locacao, LocalTime hora_locacao, float valor_calcao, Cliente cliente, Funcionario funcionario, Veiculo veiculo, int cod_Locacao) {
        this.dt_locacao = dt_locacao;
        this.hora_locacao = hora_locacao;
        this.valor_calcao = valor_calcao;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.cod_Locacao = cod_Locacao;
        this.dt_prevista_devolucao = dt_prevista_devolucao;
        this.hora_prevista_devolucao = hora_prevista_devolucao;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public int getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(int tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public Nota getNota_fiscal() {
        return nota_fiscal;
    }

    public void setNota_fiscal(Nota nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

    public LocalDate getDt_locacao() {
        return dt_locacao;
    }

    public void setDt_locacao(LocalDate dt_locacao) {
        this.dt_locacao = dt_locacao;
    }

    public LocalTime getHora_locacao() {
        return hora_locacao;
    }

    public void setHora_locacao(LocalTime hora_locacao) {
        this.hora_locacao = hora_locacao;
    }

    public LocalDate getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(LocalDate dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }

    public LocalTime getHora_devolucao() {
        return hora_devolucao;
    }

    public void setHora_devolucao(LocalTime hora_devolucao) {
        this.hora_devolucao = hora_devolucao;
    }

    public boolean isStatus_locacao() {
        return status_locacao;
    }

    public void setStatus_locacao(boolean status_locacao) {
        this.status_locacao = status_locacao;
    }

    public float getValor_calcao() {
        return valor_calcao;
    }

    public void setValor_calcao(float valor_calcao) {
        this.valor_calcao = valor_calcao;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public LocalDate getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(LocalDate dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getCod_Locacao() {
        return cod_Locacao;
    }

    public void setCod_Locacao(int cod_Locacao) {
        this.cod_Locacao = cod_Locacao;
    }

    public Double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(Double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public LocalTime getHora_prevista_devolucao() {
        return hora_prevista_devolucao;
    }

    public void setHora_prevista_devolucao(LocalTime hora_prevista_devolucao) {
        this.hora_prevista_devolucao = hora_prevista_devolucao;
    }

    public LocalDate getDt_prevista_devolucao() {
        return dt_prevista_devolucao;
    }

    public void setDt_prevista_devolucao(LocalDate dt_prevista_devolucao) {
        this.dt_prevista_devolucao = dt_prevista_devolucao;
    }
    
    public void pagar() { //não precisa de get e setter em boolean
        if (!this.pago) {
            this.pago = true;
        } else {
            System.out.println("Essa localção já foi pago!");
        }

    }

}
