package br.com.fiap.gyma_api.model;

import java.util.List;

public class Exercise {

    private Long id;
    public String name;
    private List<MuscleGroup> muscleGroup;
    private int repetitions;
    private int series;
    private int restSec;


    public Exercise(Long id, String name, List<MuscleGroup> muscleGroup, int repetitions, int series, int restSec) {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.repetitions = repetitions;
        this.series = series;
        this.restSec = restSec;
    }

    public Long getId() {
        return id;
    }

    public List<MuscleGroup> getMuscleGroup() {
        return muscleGroup;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getSeries() {
        return series;
    }

    public int getRestSec() {
        return restSec;
    }
}
