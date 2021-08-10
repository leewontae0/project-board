package project.projectboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.projectboard.domain.Board;
import project.projectboard.service.BoardService;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards/new")
    public String createForm() {
        return "boards/createBoardForm";
    }

    @PostMapping("/boards/new")
    public String create(BoardForm form) {
        Board board = new Board();
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());

        boardService.write(board);

        return "redirect:/";
    }

    @GetMapping("/boards")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }

    @GetMapping("/boards/edit")
    public String editForm() {
        return "boards/editBoardForm";
    }

    @PostMapping("boards/edit")
    public String edit(BoardForm form) {
        Board board = boardService.findOne(form.getId()).get();
        board.setContent(form.getContent());
        boardService.deleteById(board.getId());
        boardService.write(board);

        return "redirect:/";
    }

    @GetMapping("/boards/delete")
    public String DeleteForm() {
        return "boards/deleteBoardForm";
    }

    @PostMapping("boards/delete")
    public String Delete(BoardForm form) {
        boardService.deleteById(form.getId());

        return "redirect:/";
    }
}
