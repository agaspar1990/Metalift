package mapper;

import com.nice.dto.UserDto;
import com.nice.entity.User;
import com.nice.repository.UserRepository;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserViewMapper {

    @Autowired
    private UserRepository userRepository;

    public abstract UserDto toUserView(User user);

    public abstract List<UserDto> toUserView(List<User> users);

    public UserDto toUserViewById(UserDto id) {
        if (id == null) {
            return null;
        }
        return toUserView(userRepository.getById(id));
    }

}
