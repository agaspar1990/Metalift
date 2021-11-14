package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.entity.Exercise;
import com.nice.entity.Exercise.ExerciseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-14T21:36:41+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class MapstructMapperImpl implements MapstructMapper {

    @Override
    public ExerciseDto exerciseToExerciseDto(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        ExerciseDto exerciseDto = new ExerciseDto();

        exerciseDto.setId( exercise.getId() );
        exerciseDto.setTitle( exercise.getTitle() );
        exerciseDto.setDescription( exercise.getDescription() );
        List<String> list = exercise.getBodyParts();
        if ( list != null ) {
            exerciseDto.setBodyParts( new ArrayList<String>( list ) );
        }

        return exerciseDto;
    }

    @Override
    public Exercise exerciseDtoToExercise(ExerciseDto exercise) {
        if ( exercise == null ) {
            return null;
        }

        ExerciseBuilder exercise1 = Exercise.builder();

        exercise1.id( exercise.getId() );
        exercise1.title( exercise.getTitle() );
        exercise1.description( exercise.getDescription() );
        List<String> list = exercise.getBodyParts();
        if ( list != null ) {
            exercise1.bodyParts( new ArrayList<String>( list ) );
        }

        return exercise1.build();
    }
}
