<%@tag description="Generic page" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="menu" fragment="true" %>
<%@attribute name="bottom" fragment="true" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" type="image/png" href="/resources/favicon.ico"/>
    <title>
        <jsp:invoke fragment="title"/>
    </title>

    <%@include file="../views/include/head_system.jsp" %>
    <jsp:invoke fragment="header"/>
</head>
<body>

<jsp:invoke fragment="menu"/>

<div class="container-fluid" id="main-container">
    <jsp:doBody/>
</div>

<%@include file="../views/include/bottom_system.jsp" %>
<jsp:invoke fragment="bottom"/>

</body>
</html>