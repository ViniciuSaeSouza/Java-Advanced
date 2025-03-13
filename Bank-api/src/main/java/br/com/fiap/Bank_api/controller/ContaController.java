package br.com.fiap.Bank_api.controller;

import br.com.fiap.Bank_api.model.Conta;
import br.com.fiap.Bank_api.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaService cs = new ContaService();
    private List<Conta> repository = new ArrayList<>();

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta create(@RequestBody Conta conta) {
        System.out.println("Salvando conta de: " + conta.getNomeTitular());
        cs.validaConta(conta);
        repository.add(conta);
        System.out.println("Conta salva com sucesso!");
        return conta;
    }
}
