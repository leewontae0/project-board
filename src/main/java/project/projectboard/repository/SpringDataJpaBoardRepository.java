package project.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projectboard.domain.Board;

import java.util.Optional;

public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long>, BoardRepository {

    Optional<Board> findByTitle(String name);
}
