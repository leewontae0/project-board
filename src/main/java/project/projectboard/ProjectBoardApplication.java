package project.projectboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.projectboard.domain.Board;
import project.projectboard.domain.User;
import project.projectboard.repository.BoardRepository;
import project.projectboard.repository.UserRepository;

import java.util.stream.IntStream;

@SpringBootApplication
public class ProjectBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBoardApplication.class, args);
	}

}
