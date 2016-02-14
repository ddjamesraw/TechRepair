<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div align="justify">
    <div class="carousel2 shadow"> 
        <div class="carousel-button-left2"><a href="#"></a></div> 
        <div class="carousel-button-right2"><a href="#"></a></div> 
        <div class="carousel-wrapper"> 
            <div class="carousel-items"> 
                <c:forEach var="it" items="${listcomments}">
                     <div class="carousel-block">
                        <c:choose>
                            <c:when test="${it[0] != null}">
                                <c:if test="${it[3]=='true'}">
                                    <input type="checkbox" class="comstatus" name="${'com'.concat(it[4])}" checked/>
                                </c:if>
                                <c:if test="${it[3]=='false'}">
                                    <input type="checkbox" class="comstatus" name="${'com'.concat(it[4])}"/>
                                </c:if>&nbsp;
                                <b><c:out value="${it[0]}" /><br/> 
                                    <c:out value="${it[1]}" /></b><br/>   
                                <c:out value="${it[2]}" /><br/>
                                <a href="Controller?action=removecomment&id_comment=${it[4]}">Удалить</a>
                            </c:when>
                            <c:otherwise>
                                <div class="container">
                                    <div class="row-fluid">
                                        <div class="span7 well">
                                            <i>Отзывов не найдено!</i>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                     </div>
                </c:forEach>    
            </div>
        </div>
    </div>
</div>
