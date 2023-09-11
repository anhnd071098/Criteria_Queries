package kr.company.wooseok.common;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.HashMap;
@Component
public class SupportPaging {
    public void createPaging(Paging paging, int totalRow, Model model) {
        model.addAttribute("pagingHtml",this.createPagingString(paging.getPage(), paging.getSize(),totalRow));
    }

    public HashMap<String, String> createPagingString(int currentPage, int pageSize, int totalRow) {
        HashMap<String, String> map = new HashMap<String, String>();
        int totalPage;
        if (totalRow % pageSize == 0) {
            totalPage = totalRow / pageSize;
        } else {
            totalPage = (totalRow / pageSize) + 1;
        }
        String pagingString = "<section class=\"pagination\">";
        if (totalRow > 1) {
            pagingString = pagingString + "<a class=\"arrow\" data-num=\"1\"><i class=\"icon arrows-left\"></i></a>";
        }


        if (currentPage > 1) {
            int prePage = currentPage - 1;
            pagingString = pagingString + "<a class=\"arrow\" data-num=\"" + prePage + "\"><i class=\"icon arrow-left\"></i></a>";
        }

        if (totalPage < 6) {/*Neu tong so trang < 6 --> in het cac so trang (6 trang dau co dinh)*/
            for (int i = 1; i <= totalPage; i++) {
                if (currentPage == i) {
                    pagingString += "<a class=\"active\" data-num=\"" + i + "\">" + i + "</a>";
                } else {
                    pagingString += "<a data-num=\"" + i + "\">" + i + "</a>";
                }
            }
        } else {
            if (currentPage - 6 < 0) { /* trang 1 ~ 6 */
                for (int i = 1; i <= 6; i++) {
                    if (currentPage == i) {
                        pagingString += "<a class=\"active\" data-num=\"" + i + "\">" + i + "</a>";
                    } else {
                        pagingString += "<a data-num=\"" + i + "\">" + i + "</a>";
                    }
                }
            } else {
                if (currentPage + 3 > totalPage) { /* Neu trang hien tai + 3 > tong so trang --> sap het --> chi in tu trang hien tai -2 den trang cuoi cung (totalPage)*/
                    for (int i = currentPage - 2; i <= totalPage; i++) {
                        if (currentPage == i) {
                            pagingString += "<a class=\"active\" data-num=\"" + i + "\">" + i + "</a>";
                        } else {
                            pagingString += "<a data-num=\"" + i + "\">" + i + "</a>";
                        }
                    }
                } else { /*Trang hien tai + 3 < totalPage -->in tu trang hien tai -2 den trang hien tai +3*/
                    for (int i = currentPage - 2; i <= currentPage + 3; i++) {
                        if (currentPage == i) {
                            pagingString += "<a class=\"active\" data-num=\"" + i + "\">" + i + "</a>";
                        } else {
                            pagingString += "<a data-num=\"" + i + "\">" + i + "</a>";
                        }
                    }
                }

            }
        }


        if (currentPage < totalPage) {
            int nextPage = currentPage + 1;
            pagingString = pagingString + "<a class=\"arrow\" data-num=\"" + nextPage + "\"><i class=\"icon arrow-right\"></i></a>";
        }

        if (totalRow > 1) {
            pagingString = pagingString + "<a class=\"arrow\" data-num=\"" + totalPage + "\"><i class=\"icon arrows-right\"></i></a>";
        }
        pagingString = pagingString + "</section>";

        map.put("page", pagingString);
        map.put("totalRow", String.valueOf(totalRow));
        return map;
    }
}
