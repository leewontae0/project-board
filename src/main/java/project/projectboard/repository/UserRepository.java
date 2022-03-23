package project.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projectboard.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByLoginId(String loginId);
}
