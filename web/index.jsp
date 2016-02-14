<%@ taglib prefix="mytags" uri="/WEB-INF/tags/mytags.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru" >
    <head>
        <link rel="shortcut icon" href="img/computer.png" type="image/png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechRepair</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css">        
        <link rel="stylesheet" type="text/css" href="css/style.css">             
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-modal.js"></script>
        <script src="js/jquery.min.js"></script>   
        <script src="js/jquery.cookie.js"></script>
        <script src="js/jquery.leanModal.min.js"></script>   
        <script src="js/jquery.uploadfile.js"></script>
        <script src="js/jscript.js"></script>
        <script src="js/newsrss.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">google.load("feeds", "1");</script>
        <script type="text/javascript" src="js/carousel.js"></script>  <!-- подключаем наш скрипт -->
        <link rel="stylesheet" type="text/css" href="css/styles-carousel.css"> <!-- подключаем стилевой файл -->
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                        <mytags:menu/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="container">
                <div class="span2">
                    <jsp:include page="jspf/contacts.jsp"/>
                </div>
                <div class="span7">
                        <c:choose>
                            <c:when test="${content != null}">
                                <c:if test="${content == 'showusers'}">
                                    <%@include file="jspf/showusers.jsp" %>
                                </c:if>
                                <c:if test="${content == 'showorders'}">
                                    <%@include file="jspf/showorders.jsp" %>
                                </c:if>
                                <c:if test="${content == 'showcomments'}">
                                    <%@include file="jspf/showcomments.jsp" %>
                                </c:if>
                                <c:if test="${content == 'shownews'}">
                                    <%@include file="jspf/shownews.jsp" %>
                                </c:if>
                                <c:if test="${content == 'getstatistic'}">
                                    <%@include file="jspf/getstatistic.jsp" %>
                                </c:if>
                                <c:if test="${content == 'pricelist'}">
                                    <%@include file="jspf/pricelist.jsp" %>
                                </c:if>
                                <c:if test="${content == 'showadmincomments'}">
                                    <%@include file="jspf/showadmincomments.jsp" %>
                                </c:if>
                                <c:if test="${content == 'showadminorders'}">
                                    <%@include file="jspf/showadminorders.jsp" %>
                                </c:if>                                <c:if test="${content == 'showaddorderresult'}">
                                    <%@include file="jspf/showaddorderresult.jsp" %>
                                </c:if>
                                <c:if test="${content == 'infouser'}">
                                    <%@include file="jspf/infouser.jsp" %>
                                </c:if>
                                <c:if test="${content == 'adduserpage'}">
                                    <%@include file="jspf/adduser.jsp" %>
                                </c:if>
                                <c:if test="${content == 'permissiodenied'}">
                                    <%@include file="jspf/permissiodenied.jsp" %>
                                </c:if>                            
                                <c:if test="${content == 'badlogin'}">
                                    <%@include file="jspf/badlogin.jsp" %>
                                </c:if>                            
                            </c:when>
                            <c:otherwise>
                                <%@include file="jspf/about.jsp" %>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="span2">
                        <jsp:include page="jspf/other.jsp" />
                    </div>
                </div>
                <jsp:include page="jspf/footer.jsp" />
                <jsp:include page="jspf/hiddenwindows.jsp" />
            </div>
        </div>
    </body>
</html>
