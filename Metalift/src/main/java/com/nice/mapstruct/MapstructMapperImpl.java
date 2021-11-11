package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.dto.TrainingDto;
import com.nice.dto.UserDto;
import com.nice.entity.Exercise;

import com.nice.entity.Training;
import com.nice.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;


@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class MapstructMapperImpl implements MapstructMapper{
    public ExerciseDto exerciseToExerciseDto(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        ExerciseDto exerciseDto = new ExerciseDto();

        exerciseDto.setId(exercise.getId());
        exerciseDto.setTitle(exercise.getTitle());
        exerciseDto.setDescription(exercise.getDescription());
        exerciseDto.setBodypart(exercise.getBodypart());

        return exerciseDto;
    }

    public TrainingDto trainingToTrainingDto(Training training) {
            if ( training == null ) {
                return null;
            }

            TrainingDto trainingDto = new TrainingDto();

                trainingDto.setId(training.getId());
                trainingDto.setTitle(training.getTitle());
                trainingDto.setDescription(training.getDescription());


            return trainingDto;
    }


    public UserDto userToUserDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAddressLine(user.getAddressLine());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }
}
