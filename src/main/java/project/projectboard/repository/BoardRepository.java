package project.projectboard.repository;

import project.projectboard.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    Optional<Board> findById(Long id);
    Optional<Board> findByTitle(String title);
    List<Board> findAll();
    void deleteById(Long id);
}
