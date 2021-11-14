package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.dto.TrainingDto;
import com.nice.dto.UserDto;
import com.nice.entity.Exercise;
import com.nice.entity.Exercise.ExerciseBuilder;
import com.nice.entity.Training;
import com.nice.entity.Training.TrainingBuilder;
import com.nice.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-13T18:22:29+0100",
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
    public TrainingDto trainingToTrainingDto(Training training) {
        if ( training == null ) {
            return null;
        }

        TrainingDto trainingDto = new TrainingDto();

        trainingDto.setId( training.getId() );
        trainingDto.setTitle( training.getTitle() );
        trainingDto.setDescription( training.getDescription() );

        return trainingDto;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setAddressLine( user.getAddressLine() );

        return userDto;
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

    @Override
    public Training trainingDtoToTraining(TrainingDto training) {
        if ( training == null ) {
            return null;
        }

        TrainingBuilder training1 = Training.builder();

        training1.id( training.getId() );
        training1.title( training.getTitle() );
        training1.description( training.getDescription() );

        return training1.build();
    }

    @Override
    public User userDtoToUser(UserDto user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setId( user.getId() );
        user1.setFirstName( user.getFirstName() );
        user1.setLastName( user.getLastName() );
        user1.setEmail( user.getEmail() );
        user1.setPassword( user.getPassword() );
        user1.setPhoneNumber( user.getPhoneNumber() );
        user1.setAddressLine( user.getAddressLine() );

        return user1;
    }
}
