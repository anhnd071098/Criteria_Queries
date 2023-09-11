<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/en/admin/include/header.jsp" charEncoding="UTF-8"/>
<body>
<c:import url="/WEB-INF/views/en/admin/include/navigation.jsp" charEncoding="UTF-8"/>

<div class="main-content">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-12">
                <!-- Header -->
                <div class="header">
                    <div class="header-body">
                        <div class="row align-items-center">
                            <div class="col">
                                <!-- Title -->
                                <h1 class="header-title text-truncate">Tin Tức</h1>
                            </div>

                            <c:import url="/WEB-INF/views/en/admin/include/user-info.jsp" charEncoding="UTF-8"/>

                        </div>
                        <!-- / .row -->
                        <div class="row align-items-center">
                            <div class="col">
                                <!-- Nav -->
                                <ul class="nav nav-tabs nav-overflow header-tabs">
                                    <li class="nav-item">
                                        <a href="#" class="nav-link text-nowrap">
                                            PAGE 01
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link text-nowrap active">
                                            PAGE 02
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Tab content -->
                <c:if test="${successMess != null}">
                    <div class="alert alert-primary alert-dismissible fade show" role="alert">${successMess}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </c:if>
                <c:if test="${errorMess != null}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">${errorMess}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </c:if>
                <div class="tab-content">
                    <div class="tab-pane fade show active">
                        <div class="card" data-list=''>
                            <form:form action="/list" modelAttribute="demo" id="searchForm"
                                       method="get">
                                <form:input type="text" class="form-control" path="page" id="page"/>
                                <form:input type="text" class="form-control" path="size" id="size"/>
                                <form:input type="text" class="form-control" path="sortBy" id="sortBy"/>
                                <form:input type="text" class="form-control" path="sortType" id="sortType"/>
                                <div class="card-header">
                                    <div class="row align-items-center col-4">
                                        <div class="col col-md-6">
                                            <select class="form-select" id="sizeSelect">
                                                <option value="5">5 dòng</option>
                                                <option value="10">10 dòng</option>
                                                <option value="20">20 dòng</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row align-items-center col-8">
                                        <div class="col col-md-3"></div>
                                        <div class="col col-md-3">
                                            <form:select class="form-select" id="searchItem" path="searchItem">
                                                <option value="">Tất Cả</option>
                                                <option value="name">Name</option>
                                                <option value="status">Status</option>
                                            </form:select>
                                        </div>
                                        <div class="col col-md-6">
                                            <div class="input-group">
                                                <form:input class="form-control" id="keyWord" path="keyWord"
                                                            type="search"
                                                            placeholder="Nhập từ khóa tìm kiếm"/>
                                                <span class="input-group-text" id="btnSearch"> <i
                                                        class="fe fe-search"> </i> </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                            <div class="table-responsive">
                                <table class="table table-sm text-center table-hover table-nowrap card-table">
                                    <thead>
                                    <tr>
                                        <th class="col-8"><a class="dataSort" data-sort="name" href="#">Name</a></th>
                                        <th><a class="dataSort" data-sort="status" href="#">Status</a></th>
                                    </tr>
                                    </thead>
                                    <tbody class="list fs-base">
                                    <c:if test="${empty list}">
                                        <tr>
                                            <td colspan="8" class="text-center">Không có dữ liệu</td>
                                        </tr>
                                    </c:if>
                                    <c:forEach items="${list}" var="item">
                                        <tr>
                                            <td>${item.name}</td>
                                            <td>${item.status}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="card-footer d-flex justify-content-center">
                                ${paging.page}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/views/en/admin/include/script.jsp" charEncoding="UTF-8"/>
<c:import url="/WEB-INF/views/en/admin/content/list/script.jsp" charEncoding="UTF-8"/>