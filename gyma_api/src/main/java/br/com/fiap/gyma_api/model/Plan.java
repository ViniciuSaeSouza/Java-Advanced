package br.com.fiap.gyma_api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Plan {
    private Long id;
    private String photo;
    private String name;
    private List<Optional<Exercise>> exercises;
    private int total;

    public Plan(String photo, String name, List<Optional<Exercise>> exercises, Long id){
        // TODO - Melhor iniciar a lista vazia no construtor ou no atributo?
        this.exercises = new ArrayList<>();

        if (!exercises.isEmpty()){
            this.exercises = exercises;
        }

        total = this.exercises.size();
        this.name = name;
    }
}
