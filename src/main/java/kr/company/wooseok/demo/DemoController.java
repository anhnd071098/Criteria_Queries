package kr.company.wooseok.demo;

import kr.company.wooseok.cms.common.Pagination;
import kr.company.wooseok.common.CommonInject;
import kr.company.wooseok.common.Paging;
import kr.company.wooseok.common.SupportPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;
    @Autowired
    private CommonInject commonInject;

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoCriteriaQueries dm;

    @GetMapping(value = "/demo/one")
    @ResponseBody
    public List<Demo> getData() {
        return demoService.getDataDemo();
    }

    @GetMapping(value = "/demo/two/{name}/{status}")
    @ResponseBody
    public List<Demo> getDataByParam(@PathVariable String name, @PathVariable boolean status) {
        return demoService.getDataByParam(name, status);
    }

    @GetMapping(value = "/demo/three/{name}/{status}")
    @ResponseBody
    public List<Demo> getDataByParam3(@PathVariable String name, @PathVariable boolean status) {
        return demoService.getDataByParam3(name, status);
    }

    //    http://localhost:8080/demo/pagding?page=1&size=5
    @GetMapping(value = "/demo/pagding")
    @ResponseBody
    public List<Demo> getDataByParam4(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "1") Integer size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        return demoService.getDataByParam4(pageable);
    }

    @GetMapping(value = "/demo/class/properties")
    @ResponseBody
    public void getDataByParam5(@ModelAttribute("paging") Paging paging, Model model) throws ClassNotFoundException {
//        Paging paging = new Paging(new Paging());

//        Data test
        paging.setPage(2);
        paging.setSize(5);
        paging.setSortType("DESC");
        paging.setSortBy("name");
//        End Data test

        paging.setClassName("Demo");
        Pageable pageable = paging.createPaging();
        int totalRow = demoService.totalRow();
        SupportPaging supportPaging = new SupportPaging();
        supportPaging.createPaging(paging, totalRow, model);
        List<Demo> list = demoService.getDataByParam4(pageable);
    }

    @GetMapping(value = "/demo/paging")
    public String testPaging(@ModelAttribute("paging") Paging paging, Model model) throws ClassNotFoundException {
        paging.setClassName("Demo");
        Pageable pageable = paging.createPaging();
        int totalRow = demoService.totalRow();
        commonInject.getSupportPaging().createPaging(paging, totalRow, model);
        List<Demo> list = demoService.testPaging(pageable, paging);
        model.addAttribute("list", list);
        return "en/admin/content/list/list";
    }

    @GetMapping(value = "/spec/test")
    public String specTest(Model model) throws ClassNotFoundException {
        Paging paging = new Paging();

//        Data test
        paging.setPage(2);
        paging.setSize(5);
        paging.setSortType("DESC");
        paging.setSortBy("name");
//        End Data test

        paging.setClassName("Demo");
        Pageable pageable = paging.createPaging();
        int totalRow = demoService.totalRow();
        SupportPaging supportPaging = new SupportPaging();
        supportPaging.createPaging(paging, totalRow, model);
//        List<Demo> list = demoService.getByName(pageable, "anh");
        String condition = "name";
        String keyWord = "a";
        Page<Demo> list = null;
        if (condition.equals("name")) {
            list = demoRepository.findAll(DemoSpec.getEmployeesByNameSpec(keyWord), pageable);
        } else {
            list = demoRepository.findAll(DemoSpec.getEmployeesByStatusSpec(true), pageable);
        }
        return "";
    }

    @GetMapping(value = "/cri")
    public String criteriaQueries() {
        Demo demo = new Demo();
        demo.setSearchItem("name");
        demo.setKeyWord("h");
        List<Demo> demos = dm.getListDemoBySearch(demo);
        return "";
    }

    @GetMapping(value = "/list")
    public String listTemplate(@ModelAttribute("demo") Demo demo,
                               Model model) {
//        Việc 1 lấy dữ liệu
        List<Demo> list = dm.getListDemoBySearch(demo);
        model.addAttribute("list", list);
//        phân trang
        int countCandidate = dm.countDemo(demo);
        Pagination pagination = new Pagination();
        model.addAttribute("paging", pagination.createPagingString(demo.getPage(), demo.getSize(), countCandidate));
        model.addAttribute("list", list);
        return "/en/admin/content/list/list";
    }
}
