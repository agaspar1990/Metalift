package com.nice.mapstruct;

import com.nice.dto.ExerciseDto;
import com.nice.dto.UserDto;
import com.nice.entity.Exercise;
import com.nice.entity.Exercise.ExerciseBuilder;
import com.nice.entity.Role;
import com.nice.entity.User;
import com.nice.entity.User.UserBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-14T23:49:22+0100",
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

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setFullName( user.getFullName() );
        userDto.setPassword( user.getPassword() );
        userDto.setAuthorities( grantedAuthorityCollectionToRoleSet( user.getAuthorities() ) );

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto request) {
        if ( request == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( request.getId() );
        user.username( request.getUsername() );
        user.password( request.getPassword() );
        user.fullName( request.getFullName() );

        return user.build();
    }

    protected Role grantedAuthorityToRole(GrantedAuthority grantedAuthority) {
        if ( grantedAuthority == null ) {
            return null;
        }

        Role role = new Role();

        role.setAuthority( grantedAuthority.getAuthority() );

        return role;
    }

    protected Set<Role> grantedAuthorityCollectionToRoleSet(Collection<GrantedAuthority> collection) {
        if ( collection == null ) {
            return null;
        }

        Set<Role> set = new HashSet<Role>( Math.max( (int) ( collection.size() / .75f ) + 1, 16 ) );
        for ( GrantedAuthority grantedAuthority : collection ) {
            set.add( grantedAuthorityToRole( grantedAuthority ) );
        }

        return set;
    }
}
