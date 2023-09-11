package kr.company.wooseok.cms.content;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_CONTENT")
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int content_seq;
    private String content_title;
    private String content_text_en;
    private String content_text_kr;
    private String content_hyper_text_en;
    private String content_hyper_text_kr;
    private Boolean content_delete;
    private Date content_reg_dt;
    private int content_reg_adm;
    private Date content_mod_dt;
    private int content_mod_adm;
    private boolean content_display;
}
