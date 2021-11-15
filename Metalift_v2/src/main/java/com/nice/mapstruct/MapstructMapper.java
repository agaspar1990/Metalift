package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.dto.UserDto;
import com.nice.entity.Exercise;
import com.nice.entity.User;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MapstructMapper {

    ExerciseDto exerciseToExerciseDto(Exercise exercise);
    Exercise exerciseDtoToExercise(ExerciseDto exercise);
    UserDto userToUserDto(User user);


    User userDtoToUser(UserDto request);
}
