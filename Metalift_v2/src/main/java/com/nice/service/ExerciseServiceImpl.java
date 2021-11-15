package com.nice.service;

import com.nice.dto.ExerciseDto;
import com.nice.exception.EmptyListException;
import com.nice.exception.ExerciseNotFoundException;
import com.nice.exception.MissingMandatoryElementException;
import com.nice.mapstruct.MapstructMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nice.repository.ExerciseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final MapstructMapper mapstructMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<ExerciseDto> getExercises(Pageable pageable) throws EmptyListException{

        if((exerciseRepository.findAll(pageable)).isEmpty())  {
            throw new EmptyListException("List is empty");
        }

        return exerciseRepository.findAll(pageable).map(e -> mapstructMapper.exerciseToExerciseDto(e));

    }

    @Override
    @Transactional(readOnly = true)
    public Optional <ExerciseDto> getExerciseById(UUID id) throws ExerciseNotFoundException {

        if(exerciseRepository.findById(id).isEmpty()) {
            throw new ExerciseNotFoundException("Exercise with given id doesn't exist");
        }

        return exerciseRepository.findById(id).map(e -> mapstructMapper.exerciseToExerciseDto(e));
    }

    @Override
    public UUID insertExercise(ExerciseDto exercise) throws MissingMandatoryElementException {

        if(exercise.getTitle().isEmpty()) {
            throw new MissingMandatoryElementException("Bad request");
        }

        try {
            return exerciseRepository.saveAndFlush(mapstructMapper.exerciseDtoToExercise(exercise)).getId();

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Duplicate parameters");
        }

    }


    @Override
    public ExerciseDto updateExercise(UUID id, ExerciseDto exercise) {


        ExerciseDto exerciseFromDb = mapstructMapper.exerciseToExerciseDto(exerciseRepository.findById(id).get());


        if(exercise.getTitle().length() <= 0) {

            throw new NullPointerException("Bodypart is missing");
        }
        exerciseFromDb.setTitle(exercise.getTitle());
        exerciseFromDb.setDescription(exercise.getDescription());

        List<String> bodyParts = exercise.getBodyParts();


        for(String bodyPart : bodyParts) {
            if (bodyPart.length() <= 0) {

                throw new NullPointerException("Bodypart is missing");
            }
        }
            exerciseFromDb.setBodyParts(exercise.getBodyParts());


            exerciseRepository.save(mapstructMapper.exerciseDtoToExercise(exerciseFromDb));

            return exercise;
        }

    @Override
    public void deleteExercise(UUID id) {
        exerciseRepository.deleteById(id);
    }
}
