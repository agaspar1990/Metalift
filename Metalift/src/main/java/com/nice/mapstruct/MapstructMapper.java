package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.dto.TrainingDto;
import com.nice.dto.UserDto;
import com.nice.entity.Exercise;
import com.nice.entity.Training;
import com.nice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapstructMapper {

ExerciseDto exerciseToExerciseDto(Exercise exercise);
TrainingDto trainingToTrainingDto(Training training);
UserDto userToUserDto(User user);
}
