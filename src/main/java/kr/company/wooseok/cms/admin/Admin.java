package kr.company.wooseok.cms.admin;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_ADMIN")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ad_seq;
    private String ad_name;
    private String ad_email;
    private String ad_address;
    private String ad_Id;
    private String ad_pw;
}
