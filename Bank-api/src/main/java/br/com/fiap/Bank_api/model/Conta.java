package br.com.fiap.Bank_api.model;

import br.com.fiap.Bank_api.service.ContaService;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class Conta {

    private Long numero;
    private Long agencia;
    private String nomeTitular;
    private String cpf;
    private LocalDate dataAbertura;
    private double saldo;
    private boolean ativo; //(s/n)
    private TipoConta tipo;

    public Conta(Long numero, Long agencia, String nomeTitular, String cpf, TipoConta tipo, Double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.dataAbertura = LocalDate.now();
        this.saldo = saldo;
        this.ativo = true;
        this.tipo = tipo;
    }



    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }
}
