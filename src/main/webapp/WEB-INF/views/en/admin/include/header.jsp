<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="PDSOFT CMS"/>
    <title>JARVIS CMS</title>
    <link rel="shortcut icon" href="/assets/cms/favicon/favi.ico"
          type="image/x-icon"/>
    <!-- Map CSS -->
    <link rel="stylesheet" href="/assets/cms/css/mapbox-gl.css"/>
    <!-- Libs CSS -->
    <link rel="stylesheet" href="/assets/cms/css/libs.bundle.css"/>
    <!-- Theme CSS -->
    <link rel="stylesheet" href="/assets/cms/css/theme.bundle.css"/>

    <link rel="stylesheet" href="/assets/cms/plugin/sweetalert2/sweetalert2.min.css"/>
    <%-- Custom CSS--%>
    <link rel="stylesheet" href="/assets/cms/css/index.css"/>

    <link rel="stylesheet" href="/assets/cms/css/mapbox-gl.css"/>
    <link rel="stylesheet" href="/assets/cms/css/libs.bundle.css"/>
    <link rel="stylesheet" href="/assets/cms/css/theme.bundle.css"/>
    <link rel="stylesheet" href="/assets/cms/plugin/sweetalert2/sweetalert2.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src='https://cdn.tiny.cloud/1/m862mtwmvofelufcxf6kpr7rr30u4mh13bb09ks2g0xg8gdf/tinymce/5/tinymce.min.js'
            referrerpolicy="origin">
    </script>
    <style>
        .table-sm thead th {
            font-size: 13px;
        }

        .page-item {
            cursor: pointer;
        }

        .captchaImage {
            width: 120px;
        }

        .menu-list a,
        .menu-list input {
            display: inline-block;
        }

        .menu-list input {
            width: 30%;
        }

        .menu-list .sort-item {
            width: 10%;
        }

        .menu-list .menu-item {
            display: flex;
            justify-content: space-between;
            padding: .8rem 0;
        }

        .menu-list .select-item {
            width: 8%;
        }

        .menu-list .select-item option[value='No Use'] {
            color: red;
        }

        .menu-list a {
            color: #283e59;
        }
    </style>

</head>
