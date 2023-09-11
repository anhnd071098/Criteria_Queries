package kr.company.wooseok.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommonInject {
    @Autowired
    private SupportPaging supportPaging;
}
