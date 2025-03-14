package br.com.fiap.Bank_api.service;

import br.com.fiap.Bank_api.model.Conta;
import br.com.fiap.Bank_api.model.Deposito;
import br.com.fiap.Bank_api.model.TipoConta;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

public class ContaService {
    public void validaConta(Conta conta) {
        if (verificaNullOuBlank(conta.getNomeTitular()) || verificaNullOuBlank(conta.getCpf())
                || verificaSaldo(conta.getSaldo()) || verificaTipo(conta.getTipo().toString())
                || verificaDataAbertura(conta.getDataAbertura())) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "erro no corpo da resposta");
        }
    }

    public Conta deposit(Conta conta, Deposito deposito) {
        if (!verificaValorPositivo(deposito.valor())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor deve ser maior que 0, valor: " + deposito.valor());
        }

        conta.setSaldo(conta.getSaldo() + deposito.valor());
        return conta;
    }

    public boolean verificaNullOuBlank(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean verificaSaldo(Double saldo) {
        if (saldo == null || saldo < 0) {
            return true;
        }
        return false;
    }

    public boolean verificaTipo(String tipo) {
        if (tipo == null || tipo.isEmpty() || TipoConta.valueOf(tipo).toString().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean verificaDataAbertura(LocalDate data) {
        if (LocalDate.now().isBefore(data)) {
            return true;
        }
        return false;
    }


    public boolean verificaValorPositivo(Double valor) {
        if (valor <= 0) {
            return false;
        }
        return true;

    }
}
