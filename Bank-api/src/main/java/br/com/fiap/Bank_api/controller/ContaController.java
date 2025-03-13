package br.com.fiap.Bank_api.controller;

import br.com.fiap.Bank_api.model.Conta;
import br.com.fiap.Bank_api.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaService cs = new ContaService();
    private List<Conta> repository = new ArrayList<>();


    @GetMapping
    private List<Conta> index() {
        return repository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta create(@RequestBody Conta conta) {
        System.out.println("Salvando conta de: " + conta.getNomeTitular());
        cs.validaConta(conta);
        repository.add(conta);
        System.out.println("Conta salva com sucesso!");
        return conta;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Conta> getCpf(@PathVariable String cpf) {
        System.out.println("Buscando conta de cpf: " + cpf);
        return ResponseEntity.ok(getContaCpf(cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getId(@PathVariable Long id) {
        System.out.println("Buscando conta de id: " + id);
        return ResponseEntity.ok(getContaId(id));
    }



    private Conta getByCpf(String cpf) {
        var conta = repository.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();

        if (conta.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de cpf(" + cpf + ") não encontrada");
        }

        return conta.get();
    }

    private Conta getById(Long id) {
        var conta = repository.stream()
                .filter(c -> c.getNumero().equals(id))
                .findFirst();

        if (conta.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de id ("+id+") não encontrada");
        }

        return conta.get();
    }
}
