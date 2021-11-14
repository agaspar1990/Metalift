package mapper;

import com.nice.dto.UserDto;
import com.nice.entity.Role;
import com.nice.entity.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-14T21:36:42+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserViewMapperImpl extends UserViewMapper {

    @Override
    public UserDto toUserView(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setFullName( user.getFullName() );
        userDto.setPassword( user.getPassword() );
        userDto.setAuthorities( roleSetToRoleSet( user.getAuthorities() ) );

        return userDto;
    }

    @Override
    public List<UserDto> toUserView(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toUserView( user ) );
        }

        return list;
    }

    protected Role roleToRole(org.springframework.context.annotation.Role role) {
        if ( role == null ) {
            return null;
        }

        Role role1 = new Role();

        return role1;
    }

    protected Set<Role> roleSetToRoleSet(Set<org.springframework.context.annotation.Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( org.springframework.context.annotation.Role role : set ) {
            set1.add( roleToRole( role ) );
        }

        return set1;
    }
}
