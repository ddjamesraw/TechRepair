<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div align="justify">
    <font color="blue"><h4>Статистика за период с <b><c:out value="${stat_date_begin}"/></b>
    по <b><c:out value="${stat_date_end}"/></b></h4></font><br/>
        
    <c:if test="${stat_count_orders != null}">
        <b>Общее количество заказов</b>  ----->
        <font color="blue"><b><c:out value="${stat_count_orders}"/></b></font><br/><br/>
    </c:if>

    <c:if test="${stat_count_orders_by_category != null}">
        <b>Количество заказов по категориям:</b><br/>
        <c:forEach items="${stat_count_orders_by_category}" var="it">
            <i><c:out value="${it[0]}" /></i> -----> <font color="blue"><b><c:out value="${it[1]}" /></b></font><br/>
        </c:forEach><br/>
    </c:if>

    <c:if test="${stat_count_orders_by_master != null}">
        <b>Количество выполненных каждым мастером заказов:</b><br/>
        <c:forEach items="${stat_count_orders_by_master}" var="it">
            <c:if test="${it[0] == 'empty'}">
                <i><c:out value="Необработанные заказы" /></i> -----> <font color="blue"><b><c:out value="${it[1]}" /></b></font><br/>
            </c:if>
            <c:if test="${it[0] != 'empty'}">
                <i><c:out value="${it[0]}" /></i> -----> <font color="blue"><b><c:out value="${it[1]}" /></b></font><br/>
            </c:if>
        </c:forEach><br/>
    </c:if>
            
    <c:if test="${stat_total_summ != null}">
        <b>Общая стоимость заказов с учетом скидок</b>  ----->
        <font color="blue"><b><c:out value="${stat_total_summ}"/> руб.</b></font><br/><br/>
    </c:if>
</div>