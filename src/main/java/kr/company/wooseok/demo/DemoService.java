package kr.company.wooseok.demo;

import kr.company.wooseok.common.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public List<Demo> getDataDemo() {
        return demoRepository.getDataDemo();
    }

    public List<Demo> getDataByParam(String name, boolean status) {
        return demoRepository.getDataByParam(name, status);
    }

    public List<Demo> getDataByParam3(String name, boolean status) {
        return demoRepository.getDataByParam3(name, status);
    }

    public List<Demo> getDataByParam4(Pageable pageable) {
        return demoRepository.getDataByParam4(pageable);
    }

    public int totalRow() {
        return demoRepository.getDataByParam4();
    }

    public List<Demo> testPaging(Pageable pageable, Paging paging) {
        return demoRepository.testPaging(pageable, paging);
    }

    /*public List<Demo> getByName(Pageable pageable, String name) {
        return demoRepository.getByName(pageable, nameLike(name));
    }*/
}
