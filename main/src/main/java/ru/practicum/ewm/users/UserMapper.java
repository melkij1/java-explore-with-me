package ru.practicum.ewm.users;

import lombok.experimental.UtilityClass;
import ru.practicum.ewm.users.dto.UserDto;
import ru.practicum.ewm.users.dto.UserNewDto;
import ru.practicum.ewm.users.dto.UserShortDto;

@UtilityClass
public class UserMapper {
    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public UserShortDto toUserShortDto(User user) {
        return new UserShortDto(
                user.getId(),
                user.getName()
        );
    }

    public User toUser(UserNewDto userNewDto) {
        return new User(
                userNewDto.getName(),
                userNewDto.getEmail()
        );
    }
}
