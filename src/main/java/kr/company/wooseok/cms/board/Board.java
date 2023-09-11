package kr.company.wooseok.cms.board;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_BOARD")
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_seq;
    private String board_name;
    private int board_type;
}
