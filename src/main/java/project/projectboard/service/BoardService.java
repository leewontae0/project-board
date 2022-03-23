package project.projectboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.projectboard.controller.BoardForm;
import project.projectboard.domain.Board;
import project.projectboard.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> getBoard(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10); // default size 값이 10인데, 굳이 필요한 코드일까?

        return boardRepository.findAll(pageable);
    }

    @Transactional
    public Long write(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> findBoards() { return boardRepository.findAll(); }

    public Optional<Board> findOne(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void edit(BoardForm form) {
        Board findBoard = boardRepository.findById(form.getId()).get();
        findBoard.setTitle(form.getTitle());
        findBoard.setContent(form.getContent());
    }
}
