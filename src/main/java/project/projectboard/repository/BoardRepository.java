package project.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projectboard.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
