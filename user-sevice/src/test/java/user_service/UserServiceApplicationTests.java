package user_service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import user_service.entity.User;
import user_service.repository.UserRepository;
import user_service.service.UserService;

@Slf4j
@SpringBootTest
public class UserServiceApplicationTests {

    private final int NUMBER_OF_USERS = 10;

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @Test
    void addUsersToDb() {
        for(int i = 1; i <= NUMBER_OF_USERS; i++) {
            var user = User.builder()
                    .firstName("Fn"+i)
                    .lastName("Ln"+ i)
                    .email("user"+ i+ "@example.com")
                    .address(i+"Example St")
                    .alerting(i%2 ==0)
                    .energyAlertingThreshold(1000.0 + i)
                    .build();
            userRepository.save(user);
        }
        log.info("User Repository populated successfully");
    }
}
