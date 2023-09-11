<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src='${pageContext.request.contextPath}/assets/cms/js/mapbox-gl.js'></script>
<script src="${pageContext.request.contextPath}/assets/cms/js/vendor.bundle.js"></script>
<script src="${pageContext.request.contextPath}/assets/cms/js/theme.bundle.js"></script>
<script src="${pageContext.request.contextPath}/assets/cms/plugin/sweetalert2/sweetalert2.all.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        <c:if test="${not empty alert}">
        Swal.fire({
            text: "${alert}",
            icon: 'error',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
        })
        </c:if>
    });
</script>
</body>
</html>
