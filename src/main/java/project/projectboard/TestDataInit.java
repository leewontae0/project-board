package project.projectboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.projectboard.domain.Board;
import project.projectboard.domain.User;
import project.projectboard.repository.BoardRepository;
import project.projectboard.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @PostConstruct
    public void init() {
        //테스터 추가

        User user = new User();
        user.setLoginId("test");
        user.setPassword("test!");
        user.setUsername("테스터");
        userRepository.save(user);

        //게시글 추가

        for (int i = 1; i < 15; i++) {
            User user_i = new User();
            user_i.setUsername("테스트 용 회원" + i);

            userRepository.save(user_i);

            Board board = new Board();
            board.setWriter(user_i);
            board.setTitle("테스트" + i);
            board.setContent("테스트 용 게시글 입니다.");

            boardRepository.save(board);

        }
    }
}
