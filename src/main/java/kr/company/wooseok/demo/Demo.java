package kr.company.wooseok.demo;

import kr.company.wooseok.common.Paging;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "demo")
@Data
@Component
public class Demo extends Paging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    private boolean status;
}
