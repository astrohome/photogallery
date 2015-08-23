<%@tag description="List images code" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@attribute name="menuItems" type="java.util.LinkedHashMap<java.lang.String, java.lang.String>" %>
<%@attribute name="type" type="java.lang.String" %>
<%@attribute name="showLogin" type="java.lang.Boolean" %>


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">
                    <h:graphicImage library="images" name="logo.jpg" alt="Brand" height="25px"/>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <c:forEach items="${menuItems}" var="item">
                        <li
                                <c:if test="${(requestScope['javax.servlet.forward.servlet_path'] eq item.key)}">
                                    class="active"
                                </c:if>

                                <c:if test="${type eq 'admin'}">
                                    <c:if test="${(fn:length(requestScope['javax.servlet.forward.query_string']) > 0) and
                               fn:contains(requestScope['javax.servlet.forward.query_string'],
                               fn:substringAfter(item.key, '?'))}">
                                        class="active"
                                    </c:if>
                                </c:if>
                                >

                            <a href="${item.key}"><spring:message code="${item.value}"/></a>
                        </li>
                    </c:forEach>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="!isAuthenticated()">
                        <li class="btn-primary">
                            <a href="/login" style="color: white;"><spring:message code="login"/></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li>
                        <c:if test="${type ne 'admin'}">
                            <p class="nav navbar-text" style="color: #ffffff;"><spring:message code="logged-in-as"/></p>

                            <form id="logout-form" name="logoutform" style="display: none"
                                  action="<c:url value="/j_spring_security_logout" />">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" style="color: #ffffff;"
                                   data-toggle="dropdown"><sec:authentication
                                        property="principal.username"/> <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/profile">
                                            <spring:message code="menu.user.my-profile"/>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#" onclick="document.logoutform.submit()"><spring:message
                                                code="logout"/></a>
                                    </li>
                                </ul>
                            </li>

                        </c:if>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </div>
</nav>