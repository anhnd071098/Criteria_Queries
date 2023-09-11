<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $('#sizeSelect').val($('#size').val());
    $('#sizeSelect').change(function () {
        $('#page').val(1);
        $('#size').val($('#sizeSelect').val());
        $('#searchForm').submit();
    });
    $('#sortBy').change(function () {
        $('#page').val(1);
        $('#size').val($('#sizeSelect').val());
        $('#searchForm').submit();
    });
    $('#btnSearch').click(function () {
        $('#searchForm').submit();
    })
    $('#keyWord').keyup(function () {
        if ($(this).val() == '') {
            $('#searchForm').submit();
        }
    });

    $('.pagination>a').click(function () {
        $('#page').val($(this).attr("data-num"));
        $('#searchForm').submit();
    })

    $('.dataSort').click(function () {
        let sort = $('#sortType').val();
        if (sort == '') {
            sort = 'ASC';
        } else {
            if (sort == 'ASC') {
                sort = 'DESC';
            } else {
                sort = 'ASC';
            }
        }
        $('#sortBy').val($(this).attr("data-sort"));
        $('#sortType').val(sort);
        $('#searchForm').submit();
    })
</script>
