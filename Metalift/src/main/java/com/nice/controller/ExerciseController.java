package com.nice.controller;

import com.nice.dto.ExerciseDto;
import com.nice.entity.Exercise;

import com.nice.mapstruct.MapstructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nice.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
@Transactional
public class ExerciseController {

    @Autowired
    private final ExerciseService exerciseService;

    @Autowired
    private MapstructMapper mapstructMapper;

    /** The function receives a GET request, processes it and gives back a list of exercises as a response.
    */
     @GetMapping
     @Transactional(readOnly= true)
    public ResponseEntity<Page<ExerciseDto>> getAllGames(Pageable pageable) {

         Page<Exercise> exercises = exerciseService.getExercises(pageable);
            List<ExerciseDto> list = new ArrayList<ExerciseDto>();
               for(Exercise exercise : exercises) {
                list.add(mapstructMapper.exerciseToExerciseDto(exercise));
               }

               Page<ExerciseDto> page = new PageImpl<>(list);

               return ResponseEntity.ok(page);

    }

    //The function receives a GET request, processes it, and gives back a exercise for given id
    @GetMapping("/{exerciseId}")
    @Transactional(readOnly= true)
    public ResponseEntity <ExerciseDto> getExercise(@PathVariable UUID exerciseId) {

      return  ResponseEntity.ok(mapstructMapper.exerciseToExerciseDto(exerciseService.getExerciseById(exerciseId)));

    }

    /**The function receives a POST request, processes it, creates a new exercise and saves it to the database, and returns a resource link to the created exercise.
    */

    @PostMapping
    public ResponseEntity<ExerciseDto> saveExercise(@RequestBody Exercise exercise) {
        ExerciseDto exercise1 = mapstructMapper.exerciseToExerciseDto(exerciseService.insert(exercise));

        return ResponseEntity.created(URI.create("http://localhost:8080/api/v1/exercises" + exercise1.getId())).body(exercise1);

    }

    /** The function updates details of the exercise
     */
    @PutMapping({"/{exerciseId}"})
    public ResponseEntity <ExerciseDto> updateGame(@PathVariable("exerciseId") UUID exerciseId, @RequestBody Exercise exercise) {

        return ResponseEntity.ok(mapstructMapper.exerciseToExerciseDto(exerciseService.updateExercise(exerciseId, exercise)));
    }

    /** The function deletes given exercise
     */

    @DeleteMapping({"/{exerciseId}"})
    public ResponseEntity<ExerciseDto> deleteExercise(@PathVariable("exerciseId") UUID exerciseId) {
        exerciseService.deleteExercise(exerciseId);

        return ResponseEntity.noContent().build();
    }
}

