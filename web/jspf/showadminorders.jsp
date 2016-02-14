<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div align="justify">
    <c:forEach var="it" items="${listadminorders}">
        <c:choose>
            <c:when test="${it[0] != null}">
                <div class="container">
                    <div class="row-fluid">
                        <div class="span7 well">
                            <div class="container">
                                <div class="span3">
                                    <b>Описание:&nbsp;</b><c:out value="${it[1]}"/><br/>
                                    <b>Клиент:&nbsp;</b><c:out value="${it[3]}"/><br/>
                                    <b>Логин:&nbsp;</b><c:out value="${it[2]}"/><br/>
                                    <b>Дом. адрес:&nbsp;</b><c:out value="${it[4]}"/><br/>
                                    <b>E-mail:&nbsp;</b><c:out value="${it[5]}"/><br/>
                                    <b>№ паспорта:&nbsp;</b><c:out value="${it[6]}"/><br/>
                                    <b>Контактный телефон:&nbsp;</b><c:out value="${it[7]}"/><br/>
                                    <b>Состояние:&nbsp;</b><c:out value="${it[14]}"/><br/>
                                </div>
                                <div class="span4">
                                    <b>Дата и время приема:&nbsp;</b><c:out value="${it[9]}"/><br/>
                                    <b>Дата и время закрытия:&nbsp;</b><c:out value="${it[10]}"/><br/>
                                    <b>Количество:&nbsp;</b><c:out value="${it[8]}"/><br/>
                                    <b>Скидка:&nbsp;</b><c:out value="${it[11]}"/><br/>
                                    <b>Исполнитель:&nbsp;<c:out value="${it[12]}"/><br/>
                                    Тел.:&nbsp;</b><c:out value="${it[13]}"/><br/>
                                    <b>Итого:&nbsp;</b><c:out value="${it[15]}"/><br/>
                                    <b>Стоимость услуги:&nbsp;</b><c:out value="${it[16]}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="row-fluid">
                        <div class="span7 well">
                            <i>Заказов не найдено!</i>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
