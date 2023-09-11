package kr.company.wooseok.cms.post;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_POST")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_seq;
    private int board_seq;
    private String post_title_en;
    private String post_title_kr;
    private String post_desc_en;
    private String post_desc_kr;
    private String post_text_en;
    private String post_text_kr;
    private String post_hyper_text_en;
    private String post_hyper_text_kr;
    private boolean post_delete;
    private Date post_reg_dt;
    private int post_reg_adm;
    private Date post_mod_dt;
    private int post_mod_adm;
}
