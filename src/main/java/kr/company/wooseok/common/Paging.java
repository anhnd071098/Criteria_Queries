package kr.company.wooseok.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class Paging {
    private Integer page;
    private Integer size;
    private String sortBy;
    private String sortType;

    private String className;

    private String searchItem;

    private String keyWord;

    private final String ENTITY_PATH = "kr.company.wooseok.demo.";

    public Paging() {
        this.page = 1;
        this.size = 10;
    }

    public Paging(Integer page, Integer size, String sortBy, String sortType, String className) {
        this.page = page;
        this.size = size;
        this.sortBy = sortBy;
        this.sortType = sortType;
        this.className = className;
    }

    public Integer getPage() {
        return page == 0 ? 1 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size == 0 ? 10 : size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortType() {
        return sortType == "" ? "DESC" : sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSearchItem() {
        return searchItem == null ? "" : searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getKeyWord() {
        return keyWord == null ? "" : keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Pageable createPaging() throws ClassNotFoundException {
        Class<?> c = Class.forName(ENTITY_PATH + className);
        Field[] properties = c.getDeclaredFields();
        Pageable pageable = null;
        Boolean check = false;
        for (Field item : properties) {
            if (item.getName().equals(sortBy)) {
                check = true;
                break;
            }
        }
        page = page == null ? 1 : page;
        page = page == 0 ? 1 : page;
        size = size == null ? 10 : size;
        size = size == 0 ? 10 : size;
        sortType = sortType == null ? "DESC" : sortType;
        sortType = sortType == "" ? "DESC" : sortType;
        if (check) {

            if (sortBy != null && !sortBy.equals("")) {
                Sort sort = null;
                if (sortType.equals("ASC")) {
                    sort = Sort.by(Sort.Direction.ASC, sortBy);
                } else {
                    sort = Sort.by(Sort.Direction.DESC, sortBy);
                }
                pageable = PageRequest.of(page - 1, size, sort);
            } else {
                pageable = PageRequest.of(page - 1, size);
            }
        } else {
            System.out.println("SORT BY : " + sortBy + " NOT FOUND IN CLASS :" + className);
            pageable = PageRequest.of(page - 1, size);
        }
        return pageable;
    }
}
