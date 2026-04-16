package user_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import user_service.dto.UserDto;

@Slf4j
@Service
public class UserService {

    public UserDto createUser(UserDto userDto) {
        log.info("Creating user : {}",userDto);
        return userDto;
    }
}
