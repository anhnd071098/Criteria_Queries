package kr.company.wooseok.cms.qa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_QA")
@Data
public class QA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qa_seq;
    private String qs_name;
    private int qs_type;
    private String qs_title;
    private String qs_content;
    private String qs_email;
    private String qs_phone;
    private boolean qs_attachment;
    private Date qs_reg_dt;
    private String as_content;
    private Date as_reg_dt;
    private int as_reg_adm;
    private Date as_mod_dt;
    private int as_mod_adm;
}
