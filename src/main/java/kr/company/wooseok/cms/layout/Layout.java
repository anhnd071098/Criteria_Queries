package kr.company.wooseok.cms.layout;

import kr.company.wooseok.cms.common.Paging;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_LAYOUT")
@Data
public class Layout extends Paging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lo_seq;
    private String lo_type;
    private String lo_title;
    private String lo_descr;
    private String lo_link;
    private String lo_target_blank;
    private String lo_display;
    private int lo_sort;
    private int lo_img;
    private int lo_reg_adm;
    private Date lo_reg_dt;
    private int lo_mod_adm;
    private Date lo_mod_dt;
}
