package user_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import user_service.dto.UserDto;
import user_service.entity.User;
import user_service.repository.UserRepository;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto input) {

        final User createdUser = User.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .address(input.getAddress())
                .alerting(input.isAlerting())
                .energyAlertingThreshold(input.getEnergyAlertingThreshold())
                .build();

        User savedUser = userRepository.save(createdUser);

        return toDto(savedUser);
    }

    public UserDto getUserById(Long userId) {

        return userRepository.findById(userId)
                .map(this::toDto)
                .orElse(null);
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress())
                .alerting(user.isAlerting())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();

    }

    public void updateUser(Long userId, UserDto userDto) {
        User updateUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        updateUser.setFirstName(userDto.getFirstName());
        updateUser.setLastName(userDto.getLastName());
        updateUser.setEmail(userDto.getEmail());
        updateUser.setAddress(userDto.getAddress());
        updateUser.setAlerting(userDto.isAlerting());
        updateUser.setEnergyAlertingThreshold(userDto.getEnergyAlertingThreshold());

        userRepository.save(updateUser);
    }

    public void deleteUser(Long userId) {

        User deleteUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.delete(deleteUser);
    }
}
