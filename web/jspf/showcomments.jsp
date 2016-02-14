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
                        <b><font color="blue"><c:out value="${it[0]}" /></font><br/> 
                            <c:out value="${it[1]}" /></b><br/>   
                        <c:out value="${it[2]}" />
                     </div>
                </c:forEach>
            </div>
        </div>
    </div><br/>
    <c:choose>
        <c:when test="${role == 'client'}">
            <div class="container">
                <div class="row">
                    <div class="span4 well" style="padding-bottom:0">
                        <form accept-charset="UTF-8" action="Controller" method="POST">
                            <input type="hidden" name="action" value="add_comment" />
                            <input type="hidden" name="login" value="login" />
                            <textarea class="span4" id="new_message" name="message" placeholder="Введите сообщение" rows="5"></textarea>
                            <button class="btn btn-info" type="submit">Отправить</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <c:if test="${role!='administrator' && role!='specialist' && role!='master'}">
                Чтобы оставить свой отзыв, Вы должны быть авторизованы
            </c:if>    
        </c:otherwise>
    </c:choose>
</div>
