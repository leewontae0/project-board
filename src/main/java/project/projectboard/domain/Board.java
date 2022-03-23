package project.projectboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Column
    private String title;

    @Lob
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private User writer;


}
