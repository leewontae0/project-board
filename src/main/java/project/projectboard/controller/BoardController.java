package project.projectboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.projectboard.SessionConst;
import project.projectboard.domain.Board;
import project.projectboard.domain.User;
import project.projectboard.service.BoardService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/boards")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }

    @GetMapping("/boards")
    public String board(@PageableDefault Pageable pageable, Model model) {
        Page<Board> boards = boardService.getBoard(pageable);
        model.addAttribute("boards", boards);

        return "boards/list";
    }

    @GetMapping("/boards/create")
    public String createForm() {
        return "boards/create";
    }

    @PostMapping("/boards/create")
    public String create(@SessionAttribute(name = SessionConst.LOGIN_USER) User user, BoardForm form) {
        Board board = new Board();
        board.setWriter(user);
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());

        boardService.write(board);

        return "redirect:/";
    }

    @GetMapping("/boards/edit")
    public String editForm() {
        return "boards/edit";
    }

//    @PostMapping("boards/edit")
    public String edit(BoardForm form) {
        Board board = boardService.findOne(form.getId()).get();
        board.setContent(form.getContent());
        boardService.deleteById(board.getId());
        boardService.write(board);

        return "redirect:/";
    }

    @PostMapping("boards/edit")
    public String editBoard(@SessionAttribute(name = SessionConst.LOGIN_USER) User user, @Valid @ModelAttribute BoardForm form, BindingResult result) {
        if (boardService.findOne(form.getId()).get().getWriter().getId() != user.getId()) {
            result.reject("editFail", "수정 요청하신 글의 작성자가 아닙니다.");
            return "boards/edit";
        }

        boardService.edit(form);

        return "redirect:/";
    }

    @GetMapping("boards/delete")
    public String delete() {
        return "boards/delete";
    }

    @PostMapping("boards/delete")
    public String deleteBoard(BoardForm form) {
        boardService.deleteById(form.getId());

        return "redirect:/";
    }
}
