package com.nice.controller;

import com.nice.dto.ExerciseDto;

import com.nice.exception.EmptyListException;
import com.nice.exception.ExerciseNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nice.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.UUID;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {


    private final ExerciseService exerciseService;


    /** The function receives a GET request, processes it and gives back a list of exercises as a response.
    */
     @GetMapping
     @Transactional(readOnly= true)
    public ResponseEntity<Page<ExerciseDto>> getAllGames(Pageable pageable) throws EmptyListException {


         return ResponseEntity.ok(exerciseService.getExercises(pageable));

    }



    //The function receives a GET request, processes it, and gives back a exercise for given id
    @GetMapping("/{id}")
    @Transactional(readOnly= true)
    public ResponseEntity <ExerciseDto> getExercise(@PathVariable UUID id) throws ExerciseNotFoundException {

        return ResponseEntity.of(exerciseService.getExerciseById(id));

    }

    /**The function receives a POST request, processes it, creates a new exercise and saves it to the database, and returns a resource link to the created exercise.
    */

    @PostMapping
    public ResponseEntity <Void> saveExercise(@Valid @RequestBody ExerciseDto exercise) {

        try {

            return ResponseEntity.created(URI.create("http://localhost:8080/api/v1/exercises/" + exerciseService.insertExercise(exercise))).build();
        }
        catch (Exception e) {
            throw new DataIntegrityViolationException("Duplicate parameters");
        }
    }

    /** The function updates details of the exercise
     */
    @PutMapping({"/{id}"})
    public ResponseEntity <Void> updateExercise(@Valid @PathVariable("id") UUID id, @RequestBody ExerciseDto exercise) {

        exerciseService.updateExercise(id, exercise);

        return ResponseEntity.accepted().build();

    }

    /** The function deletes given exercise
     */

    @DeleteMapping({"/{exerciseId}"})
    public ResponseEntity<ExerciseDto> deleteExercise(@PathVariable("exerciseId") UUID exerciseId) {
        exerciseService.deleteExercise(exerciseId);

        return ResponseEntity.noContent().build();
    }
}

