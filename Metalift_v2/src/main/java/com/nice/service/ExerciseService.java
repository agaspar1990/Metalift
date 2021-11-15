package com.nice.service;
import com.nice.dto.ExerciseDto;
import com.nice.exception.EmptyListException;
import com.nice.exception.ExerciseNotFoundException;
import com.nice.exception.MissingMandatoryElementException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Transactional
public interface ExerciseService {
    Page<ExerciseDto> getExercises(Pageable pageable) throws EmptyListException;

    Optional<ExerciseDto> getExerciseById(UUID id) throws ExerciseNotFoundException;

    UUID insertExercise(ExerciseDto exercise) throws MissingMandatoryElementException;

    ExerciseDto updateExercise(UUID id, ExerciseDto exercise);

    void deleteExercise(UUID gameId);

}
