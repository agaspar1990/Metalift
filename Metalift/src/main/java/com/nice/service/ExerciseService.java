package com.nice.service;
import com.nice.entity.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface ExerciseService {
    Page<Exercise> getExercises(Pageable pageable);

    Exercise getExerciseById(UUID id);

    Exercise insert(Exercise exercise);

    Exercise updateExercise(UUID id, Exercise exercise);

    void deleteExercise(UUID gameId);

}
