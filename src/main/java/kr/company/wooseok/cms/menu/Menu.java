package kr.company.wooseok.cms.menu;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MENU")
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menu_seq;
    private String menu_name_en;
    private String menu_name_kr;
    private String menu_link;
    private int menu_sort;
    private boolean menu_target_blank;
    private boolean menu_display_en;
    private boolean menu_display_kr;
    private int menu_top;
    private int menu_reg_adm;
    private Date menu_reg_dt;
    private int menu_mod_adm;
    private Date menu_mod_dt;
}
