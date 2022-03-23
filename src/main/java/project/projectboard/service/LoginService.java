package project.projectboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.projectboard.domain.User;
import project.projectboard.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String loginId, String password) {
        return userRepository.findByLoginId(loginId)
                .stream()
                .filter(m -> m.getPassword().equals(password))
                .findFirst()
                .orElse(null);

    }
}
