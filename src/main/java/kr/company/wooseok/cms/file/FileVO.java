package kr.company.wooseok.cms.file;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_FILE")
@Data
public class FileVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int file_seq;
    private String target_dir;
    private String file_uuid;
    private String file_name;
    private String file_ext;
    private String file_type;
    private String file_path;
    private int file_size;
    private Date file_reg_dtm;
    private int post_seq;
    private int qa_seq;
}
