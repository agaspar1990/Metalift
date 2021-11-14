package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.entity.Exercise;
import com.nice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapstructMapper {

    ExerciseDto exerciseToExerciseDto(Exercise exercise);
    Exercise exerciseDtoToExercise(ExerciseDto exercise);

}
