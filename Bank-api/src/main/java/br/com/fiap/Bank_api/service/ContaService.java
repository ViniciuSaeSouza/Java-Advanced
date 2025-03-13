package br.com.fiap.Bank_api.service;

import br.com.fiap.Bank_api.model.Conta;
import br.com.fiap.Bank_api.model.TipoConta;
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
}
