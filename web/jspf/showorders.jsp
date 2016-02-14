<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div align="justify">
    <div class="carousel3 shadow"> 
       <div class="carousel-button-left3"><a href="#"></a></div> 
       <div class="carousel-button-right3"><a href="#"></a></div> 
       <div class="carousel-wrapper"> 
           <div class="carousel-items"> 
                <c:forEach var="it" items="${listorders}">
                    <div class="carousel-block">
                        <font color="blue"><b>Описание:</b></font>&nbsp;<c:out value="${it[0]}" /><br/> 
                        <font color="blue"><b>Дата принятия:</b></font>&nbsp;<c:out value="${it[1]}" /><br/>   
                        <font color="blue"><b>Дата закрытия:</b></font>&nbsp;<c:out value="${it[2]}" /><br/> 
                        <font color="blue"><b>Исполнитель:</b></font>&nbsp;<c:out value="${it[5]}" />&nbsp;(тел.&nbsp;<c:out value="${it[6]}" />)<br/> 
                        <font color="blue"><b>Цена за единицу услуги:</b></font>&nbsp;<c:out value="${it[9]}" />&nbsp;бел. руб.<br/>   
                        <font color="blue"><b>Количество:</b></font>&nbsp;<c:out value="${it[3]}" /><br/>   
                        <font color="blue"><b>Скидка, %:</b></font>&nbsp;<c:out value="${it[4]}" /><br/> 
                        <font color="blue"><b>Стоимость:</b></font>&nbsp;<c:out value="${it[7]}" />&nbsp;бел. руб.<br/>   
                        <font color="blue"><b>Состояние:</b></font>&nbsp;<c:out value="${it[8]}" /><br/>   
                    </div>
                </c:forEach>
           </div>
       </div>
    </div>
</div>
