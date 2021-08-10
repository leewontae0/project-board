package project.projectboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projectboard.repository.BoardRepository;
import project.projectboard.repository.MemoryBoardRepository;
import project.projectboard.service.BoardService;

@Configuration
public class SpringConfig {

    private final BoardRepository boardRepository;

    public SpringConfig(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository);
    }
}
