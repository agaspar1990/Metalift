package mapper;

import com.nice.dto.UserDto;
import com.nice.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-14T21:36:41+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserEditMapperImpl extends UserEditMapper {

    @Override
    public User create(UserDto request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setId( request.getId() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setFullName( request.getFullName() );

        afterCreate( request, user );
        afterUpdate( request, user );

        return user;
    }

    @Override
    public void update(UserDto request, User user) {
        if ( request == null ) {
            return;
        }

        if ( request.getId() != null ) {
            user.setId( request.getId() );
        }
        if ( request.getUsername() != null ) {
            user.setUsername( request.getUsername() );
        }
        if ( request.getPassword() != null ) {
            user.setPassword( request.getPassword() );
        }
        if ( request.getFullName() != null ) {
            user.setFullName( request.getFullName() );
        }

        afterCreate( request, user );
        afterUpdate( request, user );
    }
}
