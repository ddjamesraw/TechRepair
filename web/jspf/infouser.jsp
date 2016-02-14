<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div align="justify">
    <div class="container">
        <div class="row-fluid">
            <div class="span7 well">
                <b>Логин: </b><c:out value="${userdata[0]}"/><br/>
                <b>ФИО:</b><c:out value="${userdata[1]}"/><br/>
                <b>Телефон:</b><c:out value="${userdata[2]}"/><br/> 
                <c:if test="${userdata[3] != null}">
                    <b>E-mail:</b><c:out value="${userdata[3]}"/><br/> 
                    <b>Адрес:</b><c:out value="${userdata[4]}"/><br/> 
                    <b>№ паспорта:</b><c:out value="${userdata[5]}"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
