package com.nice.service;

import com.nice.entity.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nice.repository.ExerciseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Exercise> getExercises(Pageable pageable) {

        return exerciseRepository.findAll(pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Exercise getExerciseById(UUID id) {
        return exerciseRepository.findById(id).get();
    }

    @Override
    public Exercise insert(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise updateExercise(UUID id, Exercise exercise) {
        Exercise exerciseFromDb = exerciseRepository.findById(id).get();

        System.out.println(exerciseFromDb.toString());

        exerciseFromDb.setTitle(exercise.getTitle());
        exerciseFromDb.setDescription(exercise.getDescription());
        exerciseFromDb.setBodypart(exercise.getBodypart());


       return exerciseRepository.save(exerciseFromDb);
    }

    @Override
    public void deleteExercise(UUID id) {
        exerciseRepository.deleteById(id);
    }
}
