package project.projectboard.service;

import org.springframework.transaction.annotation.Transactional;
import project.projectboard.domain.Board;
import project.projectboard.repository.BoardRepository;
import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long write(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long memberId) {
        return boardRepository.findById(memberId);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

}
